package il.org.multivec.Models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "Persons", indexes = {
        @Index(columnList = "First_Name"),
        @Index(columnList = "Last_Name"),
        @Index(columnList = "Is_Deleted")
})
public class Person {
    @Id
    @Column(name = "Person_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    @Column(nullable = false, name = "First_Name")
    private String firstName;
    @Column(nullable = false, name = "Last_Name")
    private String lastName;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> authoredBooks = new HashSet<>();
    @ManyToMany(mappedBy = "editors")
    private Set<Book> editedBooks = new HashSet<>();
    @ManyToMany(mappedBy = "translators")
    private Set<Book> translatedBooks = new HashSet<>();
    @ManyToMany(mappedBy = "illustrators")
    private Set<Book> illustratedBooks = new HashSet<>();
    @ManyToMany(mappedBy = "frontCoverIllustrators")
    private Set<Book> frontCoverIllustratedBooks = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private Person originalEntry;
    @OneToMany(mappedBy = "originalEntry")
    private Set<Person> suggestions = new HashSet<>();
    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
            name = "Person_Nickname",
            joinColumns = { @JoinColumn(name = "Person_Id") },
            inverseJoinColumns = { @JoinColumn(name = "Nickname_Id") }
    )
    private Set<Nickname> nicknames = new HashSet<>();
    @Column(name = "Is_Deleted", nullable = false)
    private Boolean isDeleted;

    public BigInteger getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getAuthoredBooks() {
        return authoredBooks;
    }

    public void setAuthoredBooks(Set<Book> authoredBooks) {
        this.authoredBooks = authoredBooks;
    }

    public Set<Book> getEditedBooks() {
        return editedBooks;
    }

    public void setEditedBooks(Set<Book> editedBooks) {
        this.editedBooks = editedBooks;
    }

    public Set<Nickname> getNicknames() {
        return nicknames;
    }

    public void setNicknames(Set<Nickname> nicknames) {
        this.nicknames = nicknames;
    }

    public Set<Book> getTranslatedBooks() {
        return translatedBooks;
    }

    public void setTranslatedBooks(Set<Book> translatedBooks) {
        this.translatedBooks = translatedBooks;
    }

    public Set<Book> getIllustratedBooks() {
        return illustratedBooks;
    }

    public void setIllustratedBooks(Set<Book> illustratedBooks) {
        this.illustratedBooks = illustratedBooks;
    }

    public Set<Book> getFrontCoverIllustratedBooks() {
        return frontCoverIllustratedBooks;
    }

    public void setFrontCoverIllustratedBooks(Set<Book> frontCoverIllustratedBooks) {
        this.frontCoverIllustratedBooks = frontCoverIllustratedBooks;
    }

    public Person getOriginalEntry() {
        return originalEntry;
    }

    public void setOriginalEntry(Person originalEntry) {
        this.originalEntry = originalEntry;
    }

    public Set<Person> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(Set<Person> suggestions) {
        this.suggestions = suggestions;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
