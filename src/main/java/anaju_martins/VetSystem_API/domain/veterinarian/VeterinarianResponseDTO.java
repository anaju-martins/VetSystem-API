package anaju_martins.VetSystem_API.domain.veterinarian;

public record VeterinarianResponseDTO(Long id, String name, String crmvet, String speciality) {
    public VeterinarianResponseDTO(Veterinarian veterinarian) {
        this(
                veterinarian.getId(),
                veterinarian.getName(),
                veterinarian.getCrmvet(),
                veterinarian.getSpecialty()
        );
    }
}
