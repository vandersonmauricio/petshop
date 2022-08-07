package com.example.petshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoVet {
    private Long id;
    private String nome;
    private String cpf;
    private Integer idade;
    private String datadeadmissao;
}
