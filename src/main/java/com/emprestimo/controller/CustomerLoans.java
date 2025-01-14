package com.emprestimo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emprestimo.dto.CustomerRequestDTO;
import com.emprestimo.dto.LoansResponseDTO;
import com.emprestimo.service.LoanService;


@RestController
@RequestMapping("/customer-loans")
public class CustomerLoans {
    
    @Autowired
    private  LoanService loanService;

    @PostMapping
    public Map<String, Object> postMethodName(@RequestBody CustomerRequestDTO customerRequestDTO) {
        
        List<LoansResponseDTO> loans = loanService.determineLoans(customerRequestDTO);

        Map<String, Object> response = new HashMap<>();
        response.put("customer", customerRequestDTO.getName());
        response.put("loans", loans);

        return response;
        
        
    }
    
    
}
