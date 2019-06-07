package com.nakkunakku.linkme.healthy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HealthCheckController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String healthy() {
        return "OK";
    }
    
    @RequestMapping(value = "/healthy", method = RequestMethod.GET)
    public String healthCheck() {
        return "OK";
    }
}
