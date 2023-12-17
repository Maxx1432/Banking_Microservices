package com.maxx.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountsDto {

    @Pattern(regexp = "(^$|[0-9]{10})",message = "Please enter a valid Account number of 10 digits")
    @NotEmpty(message = "Account number can not be a null or empty")
    private Long accountNumber;

    @NotEmpty(message = "AccountType can not be a null or empty")
    private String accountType;

    @NotEmpty(message = "BranchAddress can not be a null or empty")
    private String branchAddress;

    public AccountsDto() {

    }
}
