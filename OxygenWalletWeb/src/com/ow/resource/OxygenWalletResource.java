package com.ow.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ow.dto.AddMoney;
import com.ow.dto.FinalSettelment;
import com.ow.dto.User;
import com.ow.dto.Wallet;

@Path("/oxygen-ecash")
public class OxygenWalletResource {
	private AtomicInteger autoWalletId;
	private Map<Integer, Wallet> walletMap;

	public OxygenWalletResource() {
		walletMap = new ConcurrentHashMap<Integer, Wallet>();
		autoWalletId = new AtomicInteger(1);
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public double getWalletBalance(@QueryParam("walletId") int walletId) {

		Wallet wallet = null;

		wallet = walletMap.get(walletId);
		if (wallet != null) {
			return wallet.getBalance();
		}
		return 0.0;
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public StreamingOutput createWallet(InputStream is)
			throws ParserConfigurationException, SAXException, IOException {
		// give user it will return wallet as XML response
		User user = null;
		user = buildUser(is);

		Wallet wallet = null;
		wallet = new Wallet();
		wallet.setWalletId(autoWalletId.incrementAndGet());
		wallet.setUser(user);
		wallet.setBalance(0.0);
		wallet.setStatus("Active");
		walletMap.put(wallet.getWalletId(), wallet);
		WalletStreamingOutPut walletStreamingOutPut = new WalletStreamingOutPut(
				buildWallet(wallet));

		return walletStreamingOutPut;

	}

	// It Will Read the XML from Request And convert it to User-Object

	private User buildUser(InputStream is) throws ParserConfigurationException,
			SAXException, IOException {

		DocumentBuilderFactory documentBuilderFactory = null;
		DocumentBuilder documentBuilder = null;
		Document document = null;

		documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilder = documentBuilderFactory.newDocumentBuilder();
		document = documentBuilder.parse(is);

		User user = null;
		user = new User();

		NodeList children = document.getFirstChild().getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);

			if (child.getNodeType() == Node.ELEMENT_NODE) {

				if (child.getNodeName().equalsIgnoreCase("username")) {
					user.setUserName(child.getTextContent());

				} else if (child.getNodeName().equalsIgnoreCase("mobileNo")) {
					user.setMobileNo(child.getTextContent());

				} else if (child.getNodeName().equalsIgnoreCase("emailId")) {
					user.setEmailId(child.getTextContent());
				}
			}
		}

		return user;

	}

	// It will Convert Wallet as a XML which is returned by createWallet() as
	// response

	private String buildWallet(Wallet wallet) {

		StringBuffer sb = new StringBuffer();

		sb.append("<Wallet>").append("<walletId>").append(wallet.getWalletId())
				.append("</walletId>").append("<User>").append("<userName>")
				.append(wallet.getUser().getUserName()).append("</userName>")
				.append("<mobileNo>").append(wallet.getUser().getMobileNo())
				.append("</mobileNo>").append("<emailId>")
				.append(wallet.getUser().getEmailId()).append("</emailId>")
				.append("</User>").append("<balance>")
				.append(wallet.getBalance()).append("</balance>")
				.append("<status>").append(wallet.getStatus())
				.append("</status>").append("</Wallet>");

		return sb.toString();

	}

	// This is callBack method...which is called by JAX-RS runtime
	final private class WalletStreamingOutPut implements StreamingOutput {
		private String wallet;

		public WalletStreamingOutPut(String wallet) {
			this.wallet = wallet;
		}

		@Override
		public void write(OutputStream os) throws IOException,
				WebApplicationException {
			PrintWriter pw = new PrintWriter(os);
			pw.print(wallet);
			pw.close();
			os.close();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public StreamingOutput addCash(InputStream is)
			throws ParserConfigurationException, SAXException, IOException {
		// Give AddMoney it will return wallet XML as response
		AddMoney addMoney = null;
		addMoney = buildAddMoney(is);
		Wallet wallet = null;
		wallet = walletMap.get(addMoney.getWalletId());
		wallet.setBalance(addMoney.getAmount());
		return new WalletStreamingOutPut(buildWallet(wallet));
	}

	private AddMoney buildAddMoney(InputStream is)
			throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory documentBuilderFactory = null;
		DocumentBuilder documentBuilder = null;
		Document document = null;

		documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilder = documentBuilderFactory.newDocumentBuilder();
		document = documentBuilder.parse(is);
		AddMoney addMoney = null;
		addMoney = new AddMoney();

		NodeList children = document.getFirstChild().getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);

			if (child.getNodeType() == Node.ELEMENT_NODE) {

				if (child.getNodeName().equalsIgnoreCase("walletId")) {
					addMoney.setWalletId(Integer.parseInt(child
							.getTextContent()));
				} else if (child.getNodeName().equalsIgnoreCase("userName")) {
					addMoney.setUserName(child.getTextContent());
				} else if (child.getNodeName().equalsIgnoreCase("fromAccount")) {
					addMoney.setFromAccount(child.getTextContent());
				} else if (child.getNodeName().equalsIgnoreCase("amount")) {
					addMoney.setAmount(Double.parseDouble(child
							.getTextContent()));
				}
			}
		}
		return addMoney;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_XML)
	public StreamingOutput deactivateWallet(@QueryParam("walletId") int walletId) {
		// Give WalletId it will return FinallSettelment Details
		Wallet wallet = null;
		FinalSettelment finalSettelment = null;
		wallet = walletMap.get(walletId);
		if (wallet != null) {
			finalSettelment = new FinalSettelment();
			wallet.setStatus("Closed");
			finalSettelment.setWalletId(walletId);
			finalSettelment.setUserName(wallet.getUser().getUserName());
			finalSettelment.setBalance(wallet.getBalance());
		}
		return new WalletStreamingOutPut(
				convertFinalSettelMent(finalSettelment));

	}

	private String convertFinalSettelMent(FinalSettelment finalSettelment) {
		StringBuffer sb = new StringBuffer();

		sb.append("<FinalSettelment>").append("<walletId>")
				.append(finalSettelment.getWalletId()).append("</walletId>")
				.append("<userName>").append(finalSettelment.getUserName())
				.append("</userName>").append("<balance>")
				.append(finalSettelment.getBalance()).append("</balance>");

		return sb.toString();
	}
}
