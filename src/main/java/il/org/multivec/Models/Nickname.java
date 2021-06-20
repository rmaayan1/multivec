package il.org.multivec.Models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "Nicknames")
public class Nickname {
    @Id
    @Column(name = "Nickname_Id")
    private BigInteger id;

    @ManyToOne
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
