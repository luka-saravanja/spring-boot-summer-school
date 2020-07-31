package com.ag04smarts.sha.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DummyClinicService {

    private String clinicWebUrl;
    private String clinicFacebook;
    private DummyClinicWebData dummyClinicWebData;
    private ClinicName clinicName;

    public DummyClinicService(@Value("${clinic.web.url}") String clinicWebUrl,
                              @Value("${clinic.url.facebook}") String clinicFacebook,
                              DummyClinicWebData dummyClinicWebData,
                              ClinicName clinicName) {
        this.clinicWebUrl = clinicWebUrl;
        this.clinicFacebook = clinicFacebook;
        this.dummyClinicWebData = dummyClinicWebData;
        this.clinicName = clinicName;
    }


    public DummyClinicWebData getClinicWebData() {
        dummyClinicWebData.setClinicWebUrl(this.clinicWebUrl);
        dummyClinicWebData.setClinicFacebook(clinicFacebook);
        return dummyClinicWebData;
    }

    public String getClinicName() {
        return clinicName.getClinicName();
    }
}
