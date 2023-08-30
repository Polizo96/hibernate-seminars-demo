package gr.aueb.cf.seminars.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "TEACHERS")
public class Teacher extends AbstractEntity {

    @Column(name = "SSN", length = 10, unique = true, nullable = false)
    private String ssn;

    @Column(name = "FIRSTNAME", length = 50, nullable = true, unique = false)
    private String firstname;

    @Column(name = "LASTNAME", length = 50, nullable = true, unique = false)
    private String lastname;

    @OneToMany(mappedBy = "teacher")
    private List<Seminar> seminars = new ArrayList<>();

    protected List<Seminar> getSeminars() {
        return seminars;
    }

    public boolean addSeminar(Seminar seminar) {
        if (seminar == null || seminar.getTeacher() == this) return false;
        seminar.setTeacher(this);
        this.seminars.add(seminar);
        return true;
    }

    protected void setSeminars(List<Seminar> seminars) {
        this.seminars = seminars;
    }

    public List<Seminar> getAllSeminars() {
        return Collections.unmodifiableList(getSeminars());
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
