package anaju_martins.VetSystem._API.domain.appointment;

import anaju_martins.VetSystem._API.domain.pet.Pet;
import anaju_martins.VetSystem._API.domain.client.Client;
import anaju_martins.VetSystem._API.domain.veterinarian.Veterinarian;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;

public class Appointment {

    private Long id;
    private LocalDateTime date;
    private Integer status;

    @ManyToOne
    private Client client;
    @ManyToOne
    private Pet pet;
    @ManyToOne
    private Veterinarian vet;


    public AppointmentStatus getStatus() {
        return AppointmentStatus.valueOf(status);
    }

    public void setAppointmentStatus(AppointmentStatus status){
        if(status == null){
            this.status = status.getCode();
        }
    }
}
