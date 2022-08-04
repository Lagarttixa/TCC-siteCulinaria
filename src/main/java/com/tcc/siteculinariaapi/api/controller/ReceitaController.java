package com.tcc.siteculinariaapi.api.controller;

import com.tcc.siteculinariaapi.api.model.Receita;
import com.tcc.siteculinariaapi.api.model.Usuario;
import com.tcc.siteculinariaapi.api.repository.ReceitaRepository;
import com.tcc.siteculinariaapi.api.service.ReceitaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private ReceitaService receitaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Receita adicionar(@Valid @RequestBody Receita receita){

        return receitaService.salvar(receita);
    }

    @GetMapping
    public List<Receita> listar(){
        return receitaRepository.findAll();
    }
}
