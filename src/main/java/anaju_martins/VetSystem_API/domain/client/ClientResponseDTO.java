package anaju_martins.VetSystem_API.domain.client;

import anaju_martins.VetSystem_API.domain.pet.Pet;

import java.util.List;

public record ClientResponseDTO (Long id, String name, String email, String phone, List<Pet> pets){
}
