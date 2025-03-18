package anaju_martins.VetSystem_API.domain.medical;

import anaju_martins.VetSystem_API.domain.pet.PetResponseDTO;

import java.util.List;

public record MedicalRecordResponseDTO(Long id, PetResponseDTO pet) {
    public MedicalRecordResponseDTO(MedicalRecord record) {
        this(
                record.getId(),
                new PetResponseDTO(record.getPet())
        );
    }
}
