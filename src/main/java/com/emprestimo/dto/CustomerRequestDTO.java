package com.emprestimo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CustomerRequestDTO {
    private int age;
    private String name;
    private String cpf;
    double income;
    private String location;
}
