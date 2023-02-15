package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicesApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesApiGatewayApplication.class, args);
	}

}
