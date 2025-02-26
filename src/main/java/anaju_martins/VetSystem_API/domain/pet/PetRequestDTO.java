package anaju_martins.VetSystem_API.domain.pet;

public record PetRequestDTO(String name, String species, String breed, String gender, int age, Long clientId) {
}
