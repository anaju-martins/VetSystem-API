package anaju_martins.VetSystem_API.services;

import anaju_martins.VetSystem_API.domain.appointment.Appointment;
import anaju_martins.VetSystem_API.domain.appointment.AppointmentRequestDTO;
import anaju_martins.VetSystem_API.domain.appointment.AppointmentResponseDTO;
import anaju_martins.VetSystem_API.domain.appointment.AppointmentStatus;
import anaju_martins.VetSystem_API.domain.client.Client;
import anaju_martins.VetSystem_API.domain.pet.Pet;
import anaju_martins.VetSystem_API.domain.veterinarian.Veterinarian;
import anaju_martins.VetSystem_API.repositories.AppointmentRepository;
import anaju_martins.VetSystem_API.repositories.ClientRepository;
import anaju_martins.VetSystem_API.repositories.PetRepository;
import anaju_martins.VetSystem_API.repositories.VeterinarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    public AppointmentResponseDTO addAppointment(AppointmentRequestDTO dto) {
        Client client = clientRepository.findById(dto.clientID())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Pet pet = petRepository.findById(dto.petID())
                .orElseThrow(() -> new RuntimeException("Pet not found"));

        Veterinarian vet = veterinarianRepository.findById(dto.vetId())
                .orElseThrow(() -> new RuntimeException("Vet not found"));

        Appointment appointment = new Appointment();
        appointment.setDate(dto.date());
        appointment.setStatus(dto.status());
        appointment.setClient(client);
        appointment.setPet(pet);
        appointment.setVet(vet);

        appointmentRepository.save(appointment);
        return new AppointmentResponseDTO(appointment);
    }

    public List<AppointmentResponseDTO> findAll() {
        return appointmentRepository.findAll()
                .stream()
                .map(AppointmentResponseDTO::new)
                .toList();
    }
}
