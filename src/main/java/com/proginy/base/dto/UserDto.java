package com.proginy.base.dto;

import lombok.Data;

@Data
public class UserDto
{
    private String firstName;
    private String lastName;
    private String email;

    public UserDto()
    {
    }
}
