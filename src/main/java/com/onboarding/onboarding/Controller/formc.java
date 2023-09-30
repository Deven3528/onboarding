package com.onboarding.onboarding.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.context.Context;

import com.onboarding.onboarding.Dao.UserData;
import com.onboarding.onboarding.Dao.UserDataRepository;
import com.onboarding.onboarding.email.EmailService;
import com.onboarding.onboarding.service.UTMGenerator;




@Controller
public class formc {

    @Autowired
    private UserDataRepository userRepository;
    @Autowired
    private EmailService emailService;


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
             model.addAttribute("utmLink", utmLink);
             model.addAttribute("email",email);
             
             //send the mail
                Context context = new Context();
                context.setVariable("userName", fullName);
                context.setVariable("utmLink", utmLink);
                context.setVariable("email", email);

                emailService.sendWelcomeEmail("thoratdeven319@gmail.com", "welcome to Community","email",context);
           
            
             userRepository.save(user);
 
            
             // Email sending
             return "dashboad"; // Redirect to dashboard
         } catch (Exception e) {
             e.printStackTrace(); 
             return "error"; 
         }
     }
     
     
 }
 
