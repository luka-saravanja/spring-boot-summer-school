package com.ag04smarts.sha.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DummyClinicService {


    private String clinicFacebook;
    private DummyClinicWebData dummyClinicWebData;
    private ClinicName clinicName;

    public DummyClinicService(
                              @Value("${clinic.url.facebook}") String clinicFacebook,
                              DummyClinicWebData dummyClinicWebData,
                              ClinicName clinicName) {
        this.clinicFacebook = clinicFacebook;
        this.dummyClinicWebData = dummyClinicWebData;
        this.clinicName = clinicName;
    }


    public DummyClinicWebData getClinicWebData() {
        dummyClinicWebData.setClinicFacebook(this.clinicFacebook);
        return dummyClinicWebData;
    }

    public String getClinicName() {
        return clinicName.getClinicName();
    }
}
