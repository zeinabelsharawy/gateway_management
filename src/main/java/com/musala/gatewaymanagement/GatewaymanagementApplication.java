package com.musala.gatewaymanagement;

import com.musala.gatewaymanagement.config.JpaAuditingConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(JpaAuditingConfiguration.class)
public class GatewaymanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewaymanagementApplication.class, args);
	}

}
