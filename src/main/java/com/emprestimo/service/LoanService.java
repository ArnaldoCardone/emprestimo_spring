package com.emprestimo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.emprestimo.dto.CustomerRequestDTO;
import com.emprestimo.dto.LoansResponseDTO;

@Service
public class LoanService {
 
    public List<LoansResponseDTO> determineLoans(CustomerRequestDTO customerRequestDTO) {
        
        int age = customerRequestDTO.getAge();
        double income = customerRequestDTO.getIncome();
        String location = customerRequestDTO.getLocation();
        //String name = customerRequestDTO.getName();
        //String cpf = customerRequestDTO.getCpf();

        List<LoansResponseDTO> loans = new ArrayList<>();
        
        if(income <= 3000){
            loans.add(new LoansResponseDTO( "PERSONAL",  4));
            loans.add(new LoansResponseDTO( "GUARANTEED",  3));
        }
System.out.println("income: "+income);

        if(income <= 5000){
            loans.add(new LoansResponseDTO( "CONSIGMENT",  2));
        }

        if(income <= 3000 && income <= 5000 && age >= 30 && "SP".equalsIgnoreCase(location)) {
            loans.add(new LoansResponseDTO( "PERSONAL",  4));
            loans.add(new LoansResponseDTO( "GUARANTEED",  3));
        }
        
        if(loans.isEmpty()){
            loans.add(new LoansResponseDTO( "NO LOANS ALLOWED",  0));
        }
        
        return loans;
    }
}
