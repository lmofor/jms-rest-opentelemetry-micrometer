package pdc.telemetrie.jaegerpdc;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication
@EnableJms
public class JaegerpdcApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaegerpdcApplication.class, args);
	}

}
