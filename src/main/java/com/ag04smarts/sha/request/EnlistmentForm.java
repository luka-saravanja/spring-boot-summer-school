package com.ag04smarts.sha.request;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ag04smarts.sha.model.enums.Gender;
import com.ag04smarts.sha.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnlistmentForm {

    @JsonIgnore
    private Long patientId;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Email
    private String email;
    private String phone;
    private Integer age;
    @NotNull
    private Gender gender;
    @NotNull
    private Status status;

    public EnlistmentForm(@NotBlank String firstName, @NotBlank String lastName, @NotBlank @Email String email, String phone, Integer age, @NotNull Gender gender, @NotNull Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
        this.status = status;
    }

}
