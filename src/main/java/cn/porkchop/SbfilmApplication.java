package cn.porkchop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:conf/value.properties",ignoreResourceNotFound = true)
public class SbfilmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbfilmApplication.class, args);
	}
}