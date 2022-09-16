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
@Table(name = "TIPO_RECEITA")
public class TipoReceita {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "ID_TIPO_RECEITA")
    private Long id;

    @NotBlank
    @Column(name = "NOME_TIPO_RECEITA")
    private String nome;

}
