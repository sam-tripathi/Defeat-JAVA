package com.paramatech.service.registry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {

    @GetMapping("/userServiceFallback")
    public String userServiceFallbackMethod(){
        return "User Service is taking longer than Expected" +
                "Please Try again later";
    }

    @GetMapping("/whatsappServiceFallback")
    public String whatsappServiceFallbackMethod(){
        return "Whatsapp Service is taking longer than Expected" +
                "Please Try again later";
    }

}
