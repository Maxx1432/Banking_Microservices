package com.maxx.accounts.service;

import com.maxx.accounts.dto.CustomerDetailsDto;

public interface ICustomerService {
    /**
     *
     * @param mobileNumber - Input Mobile number
     * @return Customer Details based on a iven mobileNumber
     */
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId);
}
