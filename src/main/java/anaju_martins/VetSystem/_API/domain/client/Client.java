package anaju_martins.VetSystem._API.domain.client;

import anaju_martins.VetSystem._API.domain.appointment.Appointment;
import anaju_martins.VetSystem._API.domain.pet.Pet;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Client {

    private Long id;
    private String name;
    private String email;
    private String phone;

    @OneToMany
    private List<Pet> pets = new ArrayList<>();

    @OneToMany
    private Set<Appointment> appointments = new HashSet<>();

    public Client() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
