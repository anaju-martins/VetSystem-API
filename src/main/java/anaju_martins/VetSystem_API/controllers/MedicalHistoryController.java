package anaju_martins.VetSystem_API.controllers;

import anaju_martins.VetSystem_API.domain.medical.MedicalHistoryRequestDTO;
import anaju_martins.VetSystem_API.domain.medical.MedicalHistoryResponseDTO;
import anaju_martins.VetSystem_API.services.MedicalHistoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical-history")
public class MedicalHistoryController {

    @Autowired
    private MedicalHistoryService medicalHistoryService;

    @PostMapping
    public ResponseEntity<MedicalHistoryResponseDTO> createHistory(@RequestBody @Valid MedicalHistoryRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(medicalHistoryService.createHistory(dto));
    }

    @GetMapping
    public ResponseEntity<List<MedicalHistoryResponseDTO>> getAll(){
        return ResponseEntity.ok(medicalHistoryService.findAll());
    }
}
