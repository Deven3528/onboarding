package com.onboarding.onboarding.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


import com.onboarding.onboarding.Dao.UserData;
import com.onboarding.onboarding.Dao.UserDataRepository;

import com.onboarding.onboarding.service.UTMGenerator;




@Controller
public class formc {

    @Autowired
    private UserDataRepository userRepository;
    


    private String baseUtmLink = "http://localhost:8006/redirect";
    

    @PostMapping("/Submit")
    public String handleSubmit(Model model, UserData formData, Object email) {
        try {
             // Generate a unique UTM link for the user
             String utmSource = "email";
             String utmMedium = "email";
             String utmCampaign = "onboarding";
             boolean isRegister = true; 
             String utmLink = UTMGenerator.generateUniqueUTMLink(baseUtmLink,utmSource, utmMedium, utmCampaign, isRegister);
 
             // Save user data to the database
             UserData user = new UserData();
             user.setFullName("Deven Surendra Thorat");
             user.setEmail("Thoratdeven319@gmail.com");
             user.setUtmLink(utmLink);

             // Extract the first name 
             String fullName = user.getFullName();
             String[] nameParts = fullName.split(" ");
             String firstName = nameParts[0];
             model.addAttribute("userName", firstName);
             
             
            
             userRepository.save(user);
 
            
             // Email sending
             return "dashboad"; // Redirect to dashboard
         } catch (Exception e) {
             e.printStackTrace(); 
             return "error"; 
         }
     }
     
     
 }
 
