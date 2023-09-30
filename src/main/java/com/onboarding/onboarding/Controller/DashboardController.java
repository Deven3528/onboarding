package com.onboarding.onboarding.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class DashboardController {
    @GetMapping("/dashboad")
    public String showDashboard() {
        return "dashboad"; 
    }
}
