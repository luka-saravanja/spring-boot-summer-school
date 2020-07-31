package com.ag04smarts.sha.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:sha.properties")
public class DummyClinicWebData {

    private String clinicWebUrl;
    private String clinicFacebook;
    @Value("${clinic.url.linkedin}")
    private String clinicLinkedIn;
    @Value("${clinic.url.twitter}")
    private String clinicTwitter;


    @Override
    public String toString() {
        return "DummyClinicSocialNetworks{" +
            "clinicLinkedIn='" + clinicLinkedIn + '\'' +
            ", clinicTwitter='" + clinicTwitter + '\'' +
            '}';
    }


    public String getClinicLinkedIn() {
        return clinicLinkedIn;
    }

    public void setClinicLinkedIn(String clinicLinkedIn) {
        this.clinicLinkedIn = clinicLinkedIn;
    }

    public String getClinicTwitter() {
        return clinicTwitter;
    }

    public void setClinicTwitter(String clinicTwitter) {
        this.clinicTwitter = clinicTwitter;
    }

    public String getClinicWebUrl() {
        return clinicWebUrl;
    }

    public void setClinicWebUrl(String clinicWebUrl) {
        this.clinicWebUrl = clinicWebUrl;
    }

    public String getClinicFacebook() {
        return clinicFacebook;
    }

    public void setClinicFacebook(String clinicFacebook) {
        this.clinicFacebook = clinicFacebook;
    }
}
