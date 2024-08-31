package com.example.Desafio.Frases.Repository;

import com.example.Desafio.Frases.Model.FraseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraseRepository extends JpaRepository<FraseModel, Long> {
}
