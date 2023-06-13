package com.example.block7crudvalidation_v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
@EntityScan
@EnableFeignClients
@EnableDiscoveryClient
//Esta etiqueta me resuleve problemas de compatibilidad entre cloud y spring boot 3.0
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class Block7CrudValidationV2Application {

	public static void main(String[] args) {
		SpringApplication.run(Block7CrudValidationV2Application.class, args);
	}

}