package anaju_martins.VetSystem_API.domain.appointment;

import java.time.LocalDateTime;

public record AppointmentRequestDTO(LocalDateTime date, Integer status, Long clientID, Long petID, Long vetId) {
}
