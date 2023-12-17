package com.maxx.accounts.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CustomerDto {

    @NotEmpty(message = "Name can not be empty")
    @Size(min = 5,max = 30, message = "The length of the customer name should be between 5 and 30")
    private String name;

    @NotEmpty(message = "Email can not be empty")
    @Email(message = "please enter a valid email address")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})",message = "Please enter a valid contact number of 10 digits")
    private String mobileNumber;

    private AccountsDto accountsDto;
}
