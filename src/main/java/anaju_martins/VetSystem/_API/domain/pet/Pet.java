package anaju_martins.VetSystem._API.domain.pet;

import anaju_martins.VetSystem._API.domain.appointment.Appointment;
import anaju_martins.VetSystem._API.domain.client.Client;
import anaju_martins.VetSystem._API.domain.medical.MedicalHistory;
import anaju_martins.VetSystem._API.domain.medical.MedicalRecord;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pet {

    private Long id;
    private String name;
    private String species;
    private String breed;
    private String gender;
    private Integer age;

    @ManyToOne
    private Client client;

    @OneToOne
    private MedicalRecord record;

    @OneToMany
    private Set<Appointment> appointments = new HashSet<>();

    public Pet() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getBreed() {
        return breed;
    }

    public Integer getAge() {
        return age;
    }
}
