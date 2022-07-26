package com.tcc.siteculinariaapi.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Problema {

    private Integer status;
    private LocalDateTime dataHora;
    private String titulo;
    private List<Campo> campos;

    @Getter
    @AllArgsConstructor
    public static class Campo{
        private String local;
        private String mensagem;
    }

}
