package anaju_martins.VetSystem_API.controllers;

import anaju_martins.VetSystem_API.domain.appointment.Appointment;
import anaju_martins.VetSystem_API.domain.appointment.AppointmentRequestDTO;
import anaju_martins.VetSystem_API.domain.appointment.AppointmentResponseDTO;
import anaju_martins.VetSystem_API.services.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentResponseDTO> addAppointment(@RequestBody @Valid AppointmentRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.addAppointment(dto));
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResponseDTO>> findAll() {
        return ResponseEntity.ok(appointmentService.findAll());
    }
}
