package anaju_martins.VetSystem_API.domain.medical;

import java.time.LocalDateTime;

public record MedicalHistoryRequestDTO (LocalDateTime date, String diagnosis, String treatment, Long medicalRecordID, Long vetID){
}
