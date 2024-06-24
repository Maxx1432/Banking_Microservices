package com.maxx.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "CustomerDetails",
        description = "Schema to hold Customer, Account, Cards and Loans information"
)
public class CustomerDetailsDto {

    @Schema(
            description = "Name of the customer",example = "Maxx"
    )
    @NotEmpty(message = "Name can not be empty")
    @Size(min = 5,max = 30, message = "The length of the customer name should be between 5 and 30")
    private String name;

    @Schema(
            description = "Email of the customer",example = "Maxx@gmail.com"
    )
    @NotEmpty(message = "Email can not be empty")
    @Email(message = "please enter a valid email address")
    private String email;

    @Schema(
            description = "Mobile number of the customer",example = "9998979695"
    )
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Please enter a valid contact number of 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Accounts details of the customer"
    )
    private AccountsDto accountsDto;

    @Schema(
            description = "Loans details of the customer"
    )
    private LoansDto loansDto;

    @Schema(
            description = "Cards details of the customer"
    )
    private CardsDto cardsDto;
}
