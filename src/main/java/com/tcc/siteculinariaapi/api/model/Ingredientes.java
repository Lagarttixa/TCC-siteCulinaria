package com.tcc.siteculinariaapi.api.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "INGREDIENTES")
public class Ingredientes {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INGREDIENTE")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "ID_RECEITA")
    private Receitas receitas;

    @NotBlank
    @Column(name = "NOME_INGREDIENTE")
    private String nome;


    @ManyToOne
    @JoinColumn(name = "ID_MEDIDA")
    private Medidas medidas;

    @NotBlank
    @Column(name = "QTD_MEDIDA")
    private String quantidadeMedida;

}
