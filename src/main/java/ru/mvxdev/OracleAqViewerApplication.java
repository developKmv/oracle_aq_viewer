package ru.mvxdev;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import ru.mvxdev.objects.ConnectionORA;

@SpringBootApplication
public class OracleAqViewerApplication implements ApplicationContextAware {

	@Autowired
	private static ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ctx = applicationContext;
	}



	public static void main(String[] args) {
		SpringApplication.run(OracleAqViewerApplication.class, args);
		//ConnectionORA connectionORA = ctx.getBean("connectionORA",ConnectionORA.class);

	}
}
