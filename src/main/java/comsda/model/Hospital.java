package comsda.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "hospital")

public class Hospital {

    @Id
    @Column(name = "hospital_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hospital_name", length = 40)
    private String hospitalName;

    @OneToMany (mappedBy = "hospital")
    private List<Doctor> doctors;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public Hospital() {
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}
