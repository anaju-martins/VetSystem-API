package anaju_martins.VetSystem_API.services;

import anaju_martins.VetSystem_API.domain.medical.MedicalHistory;
import anaju_martins.VetSystem_API.domain.medical.MedicalHistoryRequestDTO;
import anaju_martins.VetSystem_API.domain.medical.MedicalHistoryResponseDTO;
import anaju_martins.VetSystem_API.domain.medical.MedicalRecord;
import anaju_martins.VetSystem_API.domain.veterinarian.Veterinarian;
import anaju_martins.VetSystem_API.repositories.MedicalHistoryRepository;
import anaju_martins.VetSystem_API.repositories.MedicalRecordRepository;
import anaju_martins.VetSystem_API.repositories.VeterinarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalHistoryService {

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    public MedicalHistoryResponseDTO createHistory(MedicalHistoryRequestDTO dto) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(dto.medicalRecordID())
                .orElseThrow(() -> new RuntimeException(("Medical Record not found")));

        Veterinarian vet = veterinarianRepository.findById(dto.vetID())
                .orElseThrow(() -> new RuntimeException(("Veterinarian not found")));

        MedicalHistory history = new MedicalHistory();
        history.setDate(dto.date());
        history.setDiagnosis(dto.diagnosis());
        history.setTreatment(dto.treatment());
        history.setMedicalRecord(medicalRecord);
        history.setVet(vet);

        medicalHistoryRepository.save(history);
        return new MedicalHistoryResponseDTO(history);
    }

    public List<MedicalHistoryResponseDTO> findAll(){
        return medicalHistoryRepository.findAll()
                .stream()
                .map(MedicalHistoryResponseDTO::new)
                .toList();
    }
}
