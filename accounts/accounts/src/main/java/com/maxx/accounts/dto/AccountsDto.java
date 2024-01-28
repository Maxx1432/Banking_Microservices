package com.maxx.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(
        name = "Account",
        description = "Schema to hold Account information"
)
public class AccountsDto {

    @Pattern(regexp = "(^$|[0-9]{10})",message = "Please enter a valid Account number of 10 digits")
    @NotEmpty(message = "Account number can not be a null or empty")
    @Schema(
            description = "Account Number of the customer", example = "1234567890"
    )
    private Long accountNumber;

    @NotEmpty(message = "AccountType can not be a null or empty")
    @Schema(
            description = "Account type of the customer",example = "Saving"
    )
    private String accountType;

    @NotEmpty(message = "BranchAddress can not be a null or empty")
    @Schema(
            description = "BranchAddress of the Bank", example = "123, Street"
    )
    private String branchAddress;

    public AccountsDto() {

    }
}
