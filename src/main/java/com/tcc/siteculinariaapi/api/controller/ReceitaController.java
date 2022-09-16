package com.tcc.siteculinariaapi.api.controller;

import com.tcc.siteculinariaapi.api.model.Receitas;
import com.tcc.siteculinariaapi.api.repository.ReceitaRepository;
import com.tcc.siteculinariaapi.api.service.ReceitaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public List<Receitas> listar(){

        return receitaRepository.findAll();
    }

    @GetMapping("/{receitaId}")
    public ResponseEntity<Receitas> buscarPorId(@PathVariable Long receitaId){
        return receitaRepository.findById(receitaId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Receitas adicionar(@Valid @RequestBody Receitas receitas){

        return receitaService.salvar(receitas);
    }

    @DeleteMapping("/{receitaId}")
    public ResponseEntity<Void> deletar(@PathVariable Long receitaId){
        if(!receitaRepository.existsById(receitaId)){
            return ResponseEntity.notFound().build();
        }

        receitaService.excluir(receitaId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{receitaId}")
    public ResponseEntity<Receitas> atualizar(@Valid @PathVariable Long receitaId,
                                                 @RequestBody Receitas receitas){
        if(!receitaRepository.existsById(receitaId)){
            return ResponseEntity.notFound().build();
        }

        receitas.setId(receitaId);
        receitas = receitaService.salvar(receitas);
        return ResponseEntity.ok(receitas);
    }
}
