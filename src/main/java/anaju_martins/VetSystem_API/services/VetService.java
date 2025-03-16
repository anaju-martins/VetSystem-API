package anaju_martins.VetSystem_API.services;

import anaju_martins.VetSystem_API.domain.veterinarian.Veterinarian;
import anaju_martins.VetSystem_API.domain.veterinarian.VeterinarianRequestDTO;
import anaju_martins.VetSystem_API.domain.veterinarian.VeterinarianResponseDTO;
import anaju_martins.VetSystem_API.repositories.VeterinarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VetService {

    @Autowired
    private VeterinarianRepository vetRepository;

    public VeterinarianResponseDTO createVet(VeterinarianRequestDTO data) {
        Veterinarian vet = new Veterinarian(
                data.name(),
                data.crmvet(),
                data.speciality()
        );

        Veterinarian savedVet = vetRepository.save(vet);
        return toVeterinarianResponseDTO(savedVet);
    }

    public VeterinarianResponseDTO findById(Long id) {
        Veterinarian vet = vetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vet id not found"));

        return toVeterinarianResponseDTO(vet);
    }

    public List<VeterinarianResponseDTO> findAll() {
        return vetRepository.findAll().stream()
                .map(this::toVeterinarianResponseDTO)
                .collect(Collectors.toList());
    }

    public void deleteVet(Long id) {
        vetRepository.deleteById(id);
    }



    private VeterinarianResponseDTO toVeterinarianResponseDTO(Veterinarian vet) {
        return new VeterinarianResponseDTO(
                vet.getId(),
                vet.getName(),
                vet.getCrmvet(),
                vet.getSpecialty()
        );
    }

}
