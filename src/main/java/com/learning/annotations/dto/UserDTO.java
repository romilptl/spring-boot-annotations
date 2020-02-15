package com.learning.annotations.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String contact;
}
