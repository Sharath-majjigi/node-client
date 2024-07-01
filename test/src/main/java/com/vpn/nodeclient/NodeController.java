package com.vpn.nodeclient;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/node")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NodeController {

    RestTemplate restTemplate;

    @PostConstruct
    public void registerNode() {
        Node node = new Node("node1", "localhost", 8081);
        restTemplate.postForObject("http://localhost:8080/central-server/node/register", node, String.class);
    }

    @GetMapping("/test")
    public String testNode() {
        return "Hii i am one of the registered node, request proxied successfully !";
    }
}