package comsda.model;

import javax.persistence.*;

@Entity
@Table(name = "doctor")

public class Doctor {

    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doctor_name", length = 40)
    private String doctorName;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    public Doctor(String doctorName, Hospital hospital) {
        this.doctorName = doctorName;
        this.hospital = hospital;
    }

    @Override
    public String toString() {
        return getId()+ " " + doctorName;

    }

    public Doctor() {
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
