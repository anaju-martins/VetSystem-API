package anaju_martins.VetSystem_API.domain.pet;

public record PetResponseDTO(Long id, String name, String species, String breed, String gender, int age, Long clientId) {

}