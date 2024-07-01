package com.vpn.nodeclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class NodeClient {

	public static void main(String[] args) {
		SpringApplication.run(NodeClient.class, args);
	}


	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

}
