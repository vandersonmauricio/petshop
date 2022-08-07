package com.example.petshop.model;

import com.example.petshop.validations.NotZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veterinario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VETERINARIO_ID")
    private Long id;
    @NotBlank(message = "o nome não pode ser nulo")
    @Pattern(regexp = "^[A-Z]+(.)*", message = "Primeira letra do nome deve ser maiúscula")
    private String nome;
    @CPF(message = "cpf inválido")
    @Column(unique = true)
    private String cpf;
    @NotZero
    private Integer idade;
    @NotBlank(message = "admissao não pode ser nula")
    private String datadeadmissao;
    @ManyToMany
    @JoinColumn(name = "VETERINARIO_ID")
    private List<Animal> animal=new ArrayList<>();

}
