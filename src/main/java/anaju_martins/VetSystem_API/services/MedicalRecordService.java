package anaju_martins.VetSystem_API.services;

import anaju_martins.VetSystem_API.domain.medical.MedicalRecord;
import anaju_martins.VetSystem_API.domain.medical.MedicalRecordRequestDTO;
import anaju_martins.VetSystem_API.domain.medical.MedicalRecordResponseDTO;
import anaju_martins.VetSystem_API.domain.pet.Pet;
import anaju_martins.VetSystem_API.repositories.MedicalRecordRepository;
import anaju_martins.VetSystem_API.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Autowired
    private PetRepository petRepository;

    public MedicalRecordResponseDTO createRecord(MedicalRecordRequestDTO dto){
        Pet pet = petRepository.findById(dto.petId())
                .orElseThrow(() -> new RuntimeException("Pet not found"));

        MedicalRecord record = new MedicalRecord();
        record.setPet(pet);

        medicalRecordRepository.save(record);
        return new MedicalRecordResponseDTO(record);

    }

    public List<MedicalRecordResponseDTO> findAll(){
        return medicalRecordRepository.findAll()
                .stream()
                .map(MedicalRecordResponseDTO::new)
                .toList();
    }
}
