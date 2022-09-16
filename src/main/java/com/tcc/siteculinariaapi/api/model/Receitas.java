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
@Table(name = "RECEITAS")
public class Receitas {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "ID_RECEITA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "NOME")
    private String nome;

    @NotBlank
    @Column(name = "TEMPO_PREPARO")
    private String tempoPreparo;

    @NotBlank
    @Column(name = "RENDIMENTO_QTDE")
    private String redimentoQuantidade;

    @NotBlank
    @Column(name = "MODO_PREPARO")
    private String modoPreparo;


    @Column(name = "INFO")
    private String info;


    @ManyToOne
    @JoinColumn(name = "ID_TIPO_RECEITA")
    private TipoReceita tipoReceita;

}
