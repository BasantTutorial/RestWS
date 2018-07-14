package com.ch.resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.StreamingOutput;

@Path("/order")
public class OrderResource {
	/*
	 * This method read the data from request body by using inputStream(file
	 * reader approach) in char by char
	 */
	@Path("/new/is")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public StreamingOutput newOrder(InputStream is) throws IOException {
		StringBuffer buffer = null;
		ContentWriter writer = null;
		buffer = new StringBuffer();
		int count = is.read();
		while (count != -1) {
			buffer.append((char) count);
			count = is.read();
		}
		writer = new ContentWriter(buffer.toString());
		return writer;
	}

	/*
	 * This method read the data from request body by using inputStream(buffered
	 * reader approach) in line by line
	 */
	@Path("/new/reader")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public StreamingOutput newOrder(Reader reader) throws IOException {

		StringBuffer buffer = null;
		ContentWriter writer = null;
		BufferedReader br = null;
		String line = null;

		buffer = new StringBuffer();
		br = new BufferedReader(reader);
		line = br.readLine();

		while (line != null) {
			buffer.append(line);
			line = br.readLine();
		}
		writer = new ContentWriter(buffer.toString());
		return writer;
	}

	/*
	 * This method read the data from request body by using byte[] in char by
	 * char
	 */
	@Path("/new/byte")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public StreamingOutput newOrder(byte[] rawData) {

		StringBuffer buffer = null;
		ContentWriter writer = null;

		buffer = new StringBuffer();
		for (byte data : rawData) {
			buffer.append((char) data);
		}
		writer = new ContentWriter(buffer.toString());
		return writer;
	}

	@Path("/new/form")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public StreamingOutput newOrder(MultivaluedMap<String, String> mapParameters) {
		StringBuffer buffer = null;
		ContentWriter writer = null;
		buffer = new StringBuffer();
		for (String paramName : mapParameters.keySet()) {
			buffer.append(paramName + " :");
			List<String> values = mapParameters.get(paramName);
			for (String value : values) {
				buffer.append(value);
			}
		}

		writer = new ContentWriter(buffer.toString());
		return writer;
	}

	@SuppressWarnings("resource")
	@Path("/new/file")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public StreamingOutput newOrder(File file) throws IOException {

		StringBuffer buffer = null;
		ContentWriter writer = null;
		FileInputStream fis = null;

		buffer = new StringBuffer();

		if (file != null) {
			fis = new FileInputStream(file);
			int i = fis.read();
			while (i != -1) {
				buffer.append((char) i);
				i = fis.read();
			}
		}

		writer = new ContentWriter(buffer.toString());
		return writer;

	}

	/*
	 * Not Working.. ==========
	 * 
	 * @Path("/new/char")
	 * 
	 * @POST
	 * 
	 * @Consumes(MediaType.TEXT_PLAIN)
	 * 
	 * @Produces(MediaType.TEXT_PLAIN) public StreamingOutput newOrder(char[]
	 * data) { return new ContentWriter(new String(data)); }
	 */

	@Path("/new/data")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public StreamingOutput newOrder(String data) {
		return new ContentWriter(data);
	}

	private final class ContentWriter implements StreamingOutput {

		private String data;

		public ContentWriter(String data) {
			this.data = data;
		}

		@Override
		public void write(OutputStream os) throws IOException,
				WebApplicationException {
			os.write(data.getBytes());
		}

	}

}
