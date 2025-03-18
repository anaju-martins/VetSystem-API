package anaju_martins.VetSystem_API.controllers;

import anaju_martins.VetSystem_API.domain.medical.MedicalRecordRequestDTO;
import anaju_martins.VetSystem_API.domain.medical.MedicalRecordResponseDTO;
import anaju_martins.VetSystem_API.services.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical-records")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @PostMapping
    public ResponseEntity<MedicalRecordResponseDTO> createRecord(@RequestBody MedicalRecordRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicalRecordService.createRecord(dto));
    }

    @GetMapping
    public ResponseEntity<List<MedicalRecordResponseDTO>> getAll() {
        return ResponseEntity.ok(medicalRecordService.findAll());
    }
}
