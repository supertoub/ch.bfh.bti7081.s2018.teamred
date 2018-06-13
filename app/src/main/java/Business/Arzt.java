package Business;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="arzt")
public class Arzt extends User {
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="patient_id")
    private List<Patient> patients;

    public Arzt(String userName, String name, String surname, String pwd, List<Patient> patients) {
        super(name, surname, pwd);
        this.patients = patients;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
