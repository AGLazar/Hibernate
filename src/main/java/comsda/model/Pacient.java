package comsda.model;

import javax.persistence.*;

@Entity
@Table (name = "pacient")

public class Pacient {

    @Id
    @Column (name = "pacient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "pacient_name", length = 40, unique = true)
    private String pacientName;

    @Column ( name = "pecient_age", nullable = false)
    private Long pacientAge;

    @OneToOne (cascade = CascadeType.ALL)
    private Email email;

    public Pacient() {

    }

    public Pacient(String pacientName, Long pacientAge, Email email) {
        this.pacientName = pacientName;
        this.pacientAge = pacientAge;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPacientName() {
        return pacientName;
    }

    public void setPacientName(String pacientName) {
        this.pacientName = pacientName;
    }

    public Long getPacientAge() {
        return pacientAge;
    }

    public void setPacientAge(Long pacientAge) {
        this.pacientAge = pacientAge;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pacient{" +
                "email=" + email +
                '}';
    }
}
