package com.tcc.siteculinariaapi.api.controller;

import com.tcc.siteculinariaapi.api.model.Ingredientes;
import com.tcc.siteculinariaapi.api.repository.IngredienteRepository;
import com.tcc.siteculinariaapi.api.service.IngredienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Autowired
    private IngredienteService ingredienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredientes adicionar(@Valid @RequestBody Ingredientes ingredientes){

        return ingredienteService.salvar(ingredientes);
    }

    @GetMapping
    public List<Ingredientes> listar(){
        return ingredienteRepository.findAll();
    }


    @GetMapping("/{ingredienteId}")
    public ResponseEntity<Ingredientes> buscarPorId(@PathVariable Long ingredienteId){
        return ingredienteRepository.findById(ingredienteId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{ingredienteId}")
    public ResponseEntity<Void> deletar(@PathVariable Long ingredienteId){
        if(!ingredienteRepository.existsById(ingredienteId)){
            return ResponseEntity.notFound().build();
        }

        ingredienteService.excluir(ingredienteId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{ingredienteId}")
    public ResponseEntity<Ingredientes> atualizar(@Valid @PathVariable Long ingredienteId,
                                                  @RequestBody Ingredientes ingredientes){
        if(!ingredienteRepository.existsById(ingredienteId)){
            return ResponseEntity.notFound().build();
        }

        ingredientes.setId(ingredienteId);
        ingredientes = ingredienteService.salvar(ingredientes);
        return ResponseEntity.ok(ingredientes);
    }
}
