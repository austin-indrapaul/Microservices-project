package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicesDepartmentserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesDepartmentserviceApplication.class, args);
	}

}
