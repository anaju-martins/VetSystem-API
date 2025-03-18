package anaju_martins.VetSystem_API.domain.pet;

public record PetResponseDTO(Long id, String name, String species, String breed, String gender, int age, Long clientId) {

    public PetResponseDTO(Pet pet) {
        this(
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