package com.onboarding.onboarding.service;

import java.util.UUID;

public class UTMGenerator {
     public static String generateUniqueUTMLink(String baseUtmLink,String utmSource, String utmMedium, String utmCampaign, boolean isRegister) {
        // Generate a unique identifier (e.g., UUID)
        String uniqueId = UUID.randomUUID().toString();

        // Create the UTM link with the unique identifier
         // Update with your actual redirect endpoint
        String utmLink = String.format("%s?utm_source=%s&utm_medium=%s&utm_campaign=%s&register=%s&uniqueId=%s",
            baseUtmLink, utmSource, utmMedium, utmCampaign, isRegister, uniqueId);

    return utmLink;
    }
}
