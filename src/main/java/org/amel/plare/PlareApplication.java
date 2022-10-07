package org.amel.plare;

import org.amel.plare.dobak.SpinflyTorus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/** main 메인 클래스
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PlareApplication {

	public static void main(String[] args) {
		// SpringApplication.run(PlareApplication.class, args);
		SpinflyTorus.makeDonutsFly();
	}

}
