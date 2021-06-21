package il.org.multivec.Models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Nicknames")
public class Nickname {
    @Id
    @Column(name = "Nickname_Id")
    private BigInteger id;


    @ManyToOne(fetch = FetchType.LAZY)
    private Nickname originalEntry;

    @OneToMany(mappedBy = "originalEntry")
    private Set<Nickname> suggestions = new HashSet<>();
}
