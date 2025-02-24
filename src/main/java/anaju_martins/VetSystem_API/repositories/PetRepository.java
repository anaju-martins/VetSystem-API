package anaju_martins.VetSystem_API.repositories;

import anaju_martins.VetSystem_API.domain.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
