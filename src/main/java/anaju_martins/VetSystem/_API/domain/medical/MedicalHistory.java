package anaju_martins.VetSystem._API.domain.medical;

import anaju_martins.VetSystem._API.domain.veterinarian.Veterinarian;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;

public class MedicalHistory {

    private LocalDateTime date;
    private String diagnosis;
    private String treatment;

    @ManyToOne
    private MedicalRecord medicalRecord;

    @OneToOne
    private Veterinarian vet;

    public MedicalHistory(){}

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
