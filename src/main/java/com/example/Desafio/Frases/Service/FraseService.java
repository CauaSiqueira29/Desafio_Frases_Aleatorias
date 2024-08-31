package com.example.Desafio.Frases.Service;

import com.example.Desafio.Frases.Dto.FraseDto;
import com.example.Desafio.Frases.Model.FraseModel;
import com.example.Desafio.Frases.Repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class FraseService {

    @Autowired
    private FraseRepository repository;

    public FraseDto retornaFraseAleatoria(){
        List<FraseModel> frases = repository.findAll();

        if(frases.isEmpty()){
            throw new NoSuchElementException("Não foi encontrada nenhuma frase");
        }

        return frases.stream()
                .skip(new Random().nextInt(frases.size()))
                .findFirst()
                .map(f -> new FraseDto(f.getTitulo(), f.getFrase(),
                        f.getPersonagem(), f.getPoster()))
                .get();
    }

    public FraseDto cadastrarFrase(FraseDto data){
        FraseModel frase = new FraseModel(data);
        repository.save(frase);
        return new FraseDto(frase.getTitulo(), frase.getFrase(), frase.getPersonagem(), frase.getPoster());
    }

    public FraseDto atualizaFrasePorId(Long id, FraseDto data){
        var pegaFrase = repository.findById(id);

        if (pegaFrase.isPresent()){
            var frase = pegaFrase.get();
            if(data.titulo() != null){
                frase.setTitulo(data.titulo());
            }
            if(data.frase() != null){
                frase.setFrase(data.frase());
            }
            if(data.personagem() != null){
                frase.setPersonagem(data.personagem());
            }
            if(data.poster() != null){
                frase.setPoster(data.poster());
            }

            FraseModel fraseAtualizada = repository.save(frase);
            return new FraseDto(fraseAtualizada.getTitulo(), fraseAtualizada.getFrase(), fraseAtualizada.getPersonagem(), fraseAtualizada.getPoster());
        }

        return null;
    }

    public FraseDto deletarFrasePorId(Long id){
        var buscaFrase = repository.findById(id);

        if(buscaFrase.isPresent()){
            var frase = buscaFrase.get();
            var mostraFrase = new FraseDto(frase.getTitulo(), frase.getFrase(), frase.getPersonagem(), frase.getPoster());
            repository.delete(frase);
            return mostraFrase;
        }

        throw new NoSuchElementException("Frase não encontrada pelo id: " + id);
    }

}
