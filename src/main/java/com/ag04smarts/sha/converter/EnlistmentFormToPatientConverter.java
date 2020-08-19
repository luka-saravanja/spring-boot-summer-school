package com.ag04smarts.sha.converter;

import com.ag04smarts.sha.model.Patient;
import com.ag04smarts.sha.request.EnlistmentForm;
import com.sun.istack.Nullable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EnlistmentFormToPatientConverter implements Converter<EnlistmentForm, Patient> {

    @Nullable
    @Override
    public Patient convert(EnlistmentForm form) {
        if (form == null) {
            return null;
        }
        return Patient.builder()
            .firstName(form.getFirstName())
            .lastName(form.getLastName())
            .email(form.getEmail())
            .phoneNumber(form.getPhone())
            .age(form.getAge())
            .status(form.getStatus())
            .gender(form.getGender())
            .build();
    }
}
