package com.onboarding.onboarding.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class RedirectController {
     @GetMapping("/redirect")
    public String redirectUser(@RequestParam("register") boolean isRegister) {
        
        if (isRegister) {
            return "redirect:/dashboad";
        } else {
            return "redirect:/form"; 
        }
    }
}
