package com.maxx.accounts.service;

import com.maxx.accounts.dto.CustomerDto;

public interface IAccountsService {
    /**
     *
     * @param customerDto - customerDto Object
     */
    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return Accounts Details based on a given mobileNumber
     */
    CustomerDto fetchAccount(String mobileNumber);
}
