package com.maxx.accounts.service.impl;

import com.maxx.accounts.dto.AccountsDto;
import com.maxx.accounts.dto.CardsDto;
import com.maxx.accounts.dto.CustomerDetailsDto;
import com.maxx.accounts.dto.LoansDto;
import com.maxx.accounts.entity.Accounts;
import com.maxx.accounts.entity.Customer;
import com.maxx.accounts.exception.ResourceNotFoundException;
import com.maxx.accounts.mapper.AccountsMapper;
import com.maxx.accounts.mapper.CustomerMapper;
import com.maxx.accounts.repository.AccountsRepository;
import com.maxx.accounts.repository.CustomerRepository;
import com.maxx.accounts.service.ICustomerService;
import com.maxx.accounts.service.client.CardsFeignClient;
import com.maxx.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServieImpl implements ICustomerService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;
    /**
     * @param mobileNumber - Input Mobile number
     * @return Customer Details based on a iven mobileNumber
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException("Customer", "MobileNumber", mobileNumber)
        );

        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                ()-> new ResourceNotFoundException("Account", "CustomerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(correlationId,mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto>cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationId,mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;
    }
}
