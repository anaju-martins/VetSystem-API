package anaju_martins.VetSystem._API.domain.medical;

import anaju_martins.VetSystem._API.domain.pet.Pet;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecord {

    private Long id;

    @OneToOne
    private Pet pet;

    @OneToMany
    private List<MedicalHistory> medicalHistory = new ArrayList<>();

    public MedicalRecord(){}


    public Long getId() {
        return id;
    }


}
