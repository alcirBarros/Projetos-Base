package br;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "SEQ_RECEBIMENTO", sequenceName = "S_RECEBIMENTO", allocationSize = 1)
@Table(name = "PostgreSql")
public class PostgreSql implements Serializable {

    private static final long serialVersionUID = -5564268200989050349L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RECEBIMENTO")
    @Column(name = "isn_recebimento")
    private int idemployee;
    private String firstname;
    private String lastname;
    private String email;

    public int getIdemployee() {
        return idemployee;
    }

    public void setIdemployee(int idemployee) {
        this.idemployee = idemployee;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
