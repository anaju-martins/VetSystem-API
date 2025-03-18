package anaju_martins.VetSystem_API.domain.appointment;

import java.time.LocalDateTime;

public record AppointmentResponseDTO(Long id, LocalDateTime date, Integer Status) {
}
