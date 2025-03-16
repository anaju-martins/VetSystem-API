package anaju_martins.VetSystem_API.controllers;

import anaju_martins.VetSystem_API.domain.pet.Pet;
import anaju_martins.VetSystem_API.domain.pet.PetRequestDTO;
import anaju_martins.VetSystem_API.domain.pet.PetResponseDTO;
import anaju_martins.VetSystem_API.services.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    public ResponseEntity<PetResponseDTO> addPet(@RequestBody @Valid PetRequestDTO body) {
        PetResponseDTO responseDTO = petService.createPet(body);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetResponseDTO> getPetById(@PathVariable Long id) {
        PetResponseDTO responseDTO = petService.findById(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PetResponseDTO>> getPets() {
        List<PetResponseDTO> pets = petService.getAllPets();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<PetResponseDTO> deletePetById(@PathVariable Long id) {
        petService.deletePet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
