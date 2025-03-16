package anaju_martins.VetSystem_API.controllers;

import anaju_martins.VetSystem_API.domain.veterinarian.VeterinarianRequestDTO;
import anaju_martins.VetSystem_API.domain.veterinarian.VeterinarianResponseDTO;
import anaju_martins.VetSystem_API.services.VetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vet")
public class VetController {

    @Autowired
    private VetService vetService;

    @PostMapping
    public ResponseEntity<VeterinarianResponseDTO> createVet( @RequestBody @Valid VeterinarianRequestDTO data) {
        VeterinarianResponseDTO createdVet = vetService.createVet(data);
        return new ResponseEntity<>(createdVet, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeterinarianResponseDTO> getVetById(@PathVariable Long id) {
        VeterinarianResponseDTO responseDTO = vetService.findById(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VeterinarianResponseDTO>> getAllVet() {
        List<VeterinarianResponseDTO> responseDTO = vetService.findAll();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteVetById(@PathVariable Long id) {
        vetService.deleteVet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
