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
    @NotBlank(message = "{name.not.blank}")
    private String firstName;
    @NotBlank(message = "{lastname.not.blank}")
    private String lastName;
    @NotBlank
    @Email(message = "{email.wrong}")
    private String email;
    private String phone;
    private Integer age;
    @NotNull
    private Gender gender;
    @NotNull
    private Status status;


}
