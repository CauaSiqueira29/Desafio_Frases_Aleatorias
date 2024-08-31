package com.example.Desafio.Frases.Controller;

import com.example.Desafio.Frases.Dto.FraseDto;
import com.example.Desafio.Frases.Service.FraseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("series")
public class FraseController {

    @Autowired
    private FraseService service;

    @GetMapping("/frases")
    private FraseDto retornaFraseAleatoria(){
        return service.retornaFraseAleatoria();
    }

    @PostMapping("/cadastra")
    private FraseDto cadastraFrase(@RequestBody @Valid FraseDto data){
        return service.cadastrarFrase(data);
    }

    @PutMapping("/atualiza/{id}")
    private FraseDto atualizaFrase(@PathVariable Long id, @RequestBody @Valid FraseDto data){
        return service.atualizaFrasePorId(id, data);
    }

    @DeleteMapping("/deleta/{id}")
    private FraseDto deletaFrasePorId(@PathVariable Long id){
        return service.deletarFrasePorId(id);
    }
}
