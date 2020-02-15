package com.learning.annotations.modal;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Component
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    private String contact;

}
