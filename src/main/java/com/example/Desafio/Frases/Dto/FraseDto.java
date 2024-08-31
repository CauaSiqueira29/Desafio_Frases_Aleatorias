package com.example.Desafio.Frases.Dto;

import jakarta.validation.constraints.NotBlank;

public record FraseDto(@NotBlank String titulo,
                       @NotBlank String frase,
                       @NotBlank String personagem,
                       @NotBlank String poster) {
}
