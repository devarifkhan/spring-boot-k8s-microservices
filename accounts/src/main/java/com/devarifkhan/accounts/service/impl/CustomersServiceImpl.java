package com.devarifkhan.accounts.service.impl;

import com.devarifkhan.accounts.dto.AccountsDto;
import com.devarifkhan.accounts.dto.CardsDto;
import com.devarifkhan.accounts.dto.CustomerDetailsDto;
import com.devarifkhan.accounts.dto.LoansDto;
import com.devarifkhan.accounts.entity.Accounts;
import com.devarifkhan.accounts.entity.Customer;
import com.devarifkhan.accounts.exception.ResourceNotFoundException;
import com.devarifkhan.accounts.mapper.AccountsMapper;
import com.devarifkhan.accounts.mapper.CustomerMapper;
import com.devarifkhan.accounts.repository.AccountsRepository;
import com.devarifkhan.accounts.repository.CustomerRepository;
import com.devarifkhan.accounts.service.Client.CardsFeignClient;
import com.devarifkhan.accounts.service.Client.LoansFeignClient;
import com.devarifkhan.accounts.service.ICustomersService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomersServiceImpl implements ICustomersService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;

    }
}