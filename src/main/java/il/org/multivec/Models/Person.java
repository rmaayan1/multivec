package il.org.multivec.Models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "Persons", indexes = {
        @Index(columnList = "First_Name"),
        @Index(columnList = "Last_Name"),
})
public class Person {
    @Id
    @Column(name = "Person_Id")
    private BigInteger id;
    @Column(nullable = false, name = "First_Name")
    private String firstName;
    @Column(nullable = false, name = "Last_Name")
    private String lastName;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> authoredBooks = new HashSet<>();
    @ManyToMany(mappedBy = "editors")
    private Set<Book> editedBooks = new HashSet<>();
    @OneToMany(mappedBy = "person")
    private Set<Nickname> nicknames;
    @ManyToMany(mappedBy = "translators")
    private Set<Book> translatedBooks = new HashSet<>();
    @ManyToMany(mappedBy = "illustrators")
    private Set<Book> illustratedBooks = new HashSet<>();
    @ManyToMany(mappedBy = "frontCoverIllustrators")
    private Set<Book> frontCoverIllustratedBooks = new HashSet<>();
}
