package com.ag04smarts.sha.model;


import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity {

    private String firstName;
    private String lastName;

}
