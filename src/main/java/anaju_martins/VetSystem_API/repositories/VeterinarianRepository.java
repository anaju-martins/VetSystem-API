package anaju_martins.VetSystem_API.repositories;

import anaju_martins.VetSystem_API.domain.veterinarian.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {
}
