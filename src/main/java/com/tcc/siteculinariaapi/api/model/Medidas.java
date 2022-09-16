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
@Table(name = "MEDIDAS")
public class Medidas {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "ID_MEDIDA")
    private Long id;

    @NotBlank
    @Column(name = "NOME_MEDIDA")
    private String nome;

}
