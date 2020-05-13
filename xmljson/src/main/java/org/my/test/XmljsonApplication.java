package org.my.test;

import com.crif.cff.shared.commons.util.CFFTypesRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication	//(exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
@EnableAutoConfiguration(exclude = {
	    org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
	})
public class XmljsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmljsonApplication.class, args);
	}
	
	@Configuration
	public class XmljsonConfig {
		
		@Bean
		public CFFTypesRepository cffTypesRepository() {
			return new CFFTypesRepository();
		}
	}

}
