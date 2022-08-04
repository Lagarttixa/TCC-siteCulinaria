package com.tcc.siteculinariaapi.api.model;

import com.tcc.siteculinariaapi.api.enums.TipoQuantidadeEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ingrediente {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String quantidade;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_quantidade")
    private TipoQuantidadeEnum tipoQuantidade;

}
