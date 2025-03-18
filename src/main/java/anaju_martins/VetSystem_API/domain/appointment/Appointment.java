package anaju_martins.VetSystem_API.domain.appointment;

import anaju_martins.VetSystem_API.domain.pet.Pet;
import anaju_martins.VetSystem_API.domain.client.Client;
import anaju_martins.VetSystem_API.domain.veterinarian.Veterinarian;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties({"pets"})
    private Client client;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    @JsonIgnore
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "vet_id")
    @JsonIgnore
    private Veterinarian vet;


    public AppointmentStatus getStatus() {
        return AppointmentStatus.valueOf(status);
    }

    public void setAppointmentStatus(AppointmentStatus status){
        if(status == null){
            this.status = status.getCode();
        }
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Client getClient() {
        return client;
    }

    public Pet getPet() {
        return pet;
    }

    public Veterinarian getVet() {
        return vet;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setVet(Veterinarian vet) {
        this.vet = vet;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
