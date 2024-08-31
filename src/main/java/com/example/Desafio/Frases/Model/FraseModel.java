package com.example.Desafio.Frases.Model;

import com.example.Desafio.Frases.Dto.FraseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Frases")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FraseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String frase;

    private String personagem;

    private String poster;

    public FraseModel(FraseDto data){
        this.titulo = data.titulo();
        this.frase = data.frase();
        this.personagem = data.personagem();
        this.poster = data.poster();
    }

}
