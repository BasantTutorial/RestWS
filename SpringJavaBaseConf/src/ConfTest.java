import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.bean.Person;
import com.spring.config.AppConfig;

public class ConfTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);
		Person p = context.getBean("person", Person.class);
		p.display();
	}
}
