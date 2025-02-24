package anaju_martins.VetSystem_API.repositories;

import anaju_martins.VetSystem_API.domain.medical.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {
}
