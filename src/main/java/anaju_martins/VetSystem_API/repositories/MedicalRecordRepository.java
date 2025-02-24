package anaju_martins.VetSystem_API.repositories;

import anaju_martins.VetSystem_API.domain.medical.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
}
