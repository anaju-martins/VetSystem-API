package anaju_martins.VetSystem._API.domain.veterinarian;

import anaju_martins.VetSystem._API.domain.appointment.Appointment;
import anaju_martins.VetSystem._API.domain.medical.MedicalHistory;
import anaju_martins.VetSystem._API.domain.medical.MedicalRecord;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


import java.util.HashSet;
import java.util.Set;

public class Veterinarian {

    private Long id;
    private String nome;
    private String crmvet;
    private String specialty;

    @OneToMany
    private Set<Appointment> appointments = new HashSet<>();

    public Veterinarian() {}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCrmvet() {
        return crmvet;
    }

    public String getSpecialty() {
        return specialty;
    }
}
