package patient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "patients")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column
    private String email;
    @Column
    private String phone;
    @Column(nullable = false)
    private String streetName;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String country;

    public Patient() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(patientId, patient.patientId) &&
            firstName.equals(patient.firstName) &&
            lastName.equals(patient.lastName) &&
            Objects.equals(email, patient.email) &&
            Objects.equals(phone, patient.phone) &&
            streetName.equals(patient.streetName) &&
            city.equals(patient.city) &&
            country.equals(patient.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, firstName, lastName, email, phone, streetName, city, country);
    }

    @Override
    public String toString() {
        return "Patient{" +
            "patientId=" + patientId +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", streetName='" + streetName + '\'' +
            ", city='" + city + '\'' +
            ", country='" + country + '\'' +
            '}';
    }

}
