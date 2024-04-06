package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.ListarPetsDTO;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<ListarPetsDTO> listarTodosDisponiveis (){
        List<Pet> petsDisponiveis = petRepository.findAllByAdotadoFalse();
        List<ListarPetsDTO> listarPetsDisponiveisDTO = petsDisponiveis.stream()
                .map(ListarPetsDTO::new)
                .collect(Collectors.toList());

        return listarPetsDisponiveisDTO;
    }
}