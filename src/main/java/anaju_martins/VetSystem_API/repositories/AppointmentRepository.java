package anaju_martins.VetSystem_API.repositories;

import anaju_martins.VetSystem_API.domain.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
