package anaju_martins.VetSystem_API.domain.medical;

import anaju_martins.VetSystem_API.domain.veterinarian.VeterinarianResponseDTO;

import java.time.LocalDateTime;

public record MedicalHistoryResponseDTO(Long id, LocalDateTime date, String diagnosis, String treatment, MedicalRecordResponseDTO medicalRecord, VeterinarianResponseDTO vet) {

    public MedicalHistoryResponseDTO(MedicalHistory history){
        this(
                history.getId(),
                history.getDate(),
                history.getDiagnosis(),
                history.getTreatment(),
                new MedicalRecordResponseDTO(history.getMedicalRecord()),
                new VeterinarianResponseDTO(history.getVet())
        );
    }
}
