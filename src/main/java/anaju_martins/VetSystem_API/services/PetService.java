package anaju_martins.VetSystem_API.services;

import anaju_martins.VetSystem_API.domain.client.Client;
import anaju_martins.VetSystem_API.domain.pet.Pet;
import anaju_martins.VetSystem_API.domain.pet.PetRequestDTO;
import anaju_martins.VetSystem_API.domain.pet.PetResponseDTO;
import anaju_martins.VetSystem_API.repositories.ClientRepository;
import anaju_martins.VetSystem_API.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ClientRepository clientRepository;

    public PetResponseDTO createPet(PetRequestDTO data) {
        Client client = clientRepository.findById(data.clientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Pet pet = new Pet(
                data.name(),
                data.species(),
                data.breed(),
                data.gender(),
                data.age(),
                client
        );

        Pet savedPet = petRepository.save(pet);
        return toPetResponseDTO(savedPet);
    }

    public PetResponseDTO findById(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found"));
        return toPetResponseDTO(pet);
    }

    public List<PetResponseDTO> getAllPets() {
        return petRepository.findAll().stream().
                map(this::toPetResponseDTO).
                collect(Collectors.toList());
    }

    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

    private PetResponseDTO toPetResponseDTO(Pet pet) {
        return new PetResponseDTO(
                pet.getId(),
                pet.getName(),
                pet.getSpecies(),
                pet.getBreed(),
                pet.getGender(),
                pet.getAge(),
                pet.getClient().getId()
        );
    }

}
