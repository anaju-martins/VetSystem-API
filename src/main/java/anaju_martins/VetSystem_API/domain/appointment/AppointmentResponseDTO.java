package anaju_martins.VetSystem_API.domain.appointment;

import anaju_martins.VetSystem_API.domain.client.ClientResponseDTO;
import anaju_martins.VetSystem_API.domain.pet.PetResponseDTO;
import anaju_martins.VetSystem_API.domain.veterinarian.VeterinarianResponseDTO;

import java.time.LocalDateTime;

public record AppointmentResponseDTO(Long id, LocalDateTime date, AppointmentStatus Status, ClientResponseDTO client, PetResponseDTO pet, VeterinarianResponseDTO vet) {
    public AppointmentResponseDTO (Appointment appointment) {
        this (
                appointment.getId(),
                appointment.getDate(),
                appointment.getStatus(),
                new ClientResponseDTO(appointment.getClient()),
                new PetResponseDTO(appointment.getPet()),
                new VeterinarianResponseDTO(appointment.getVet())
        );
    }
}
