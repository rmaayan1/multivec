package il.org.multivec.Models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Awards", indexes = {
        @Index(columnList = "Award_Name"),
        @Index(columnList = "Is_Deleted")
})
public class Award {
    @Id
    @Column(name = "Award_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    @Column(name = "Award_Name")
    private String awardName;
    @ManyToOne(fetch = FetchType.LAZY)
    private Award originalEntry;
    @OneToMany(mappedBy = "originalEntry")
    private Set<Award> suggestions = new HashSet<>();
    @ManyToMany(mappedBy = "awards")
    private Set<Book> awardedBooks = new HashSet<>();
    @Column(name = "Is_Deleted", nullable = false)
    private Boolean isDeleted;

    public BigInteger getId() {
        return id;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public Award getOriginalEntry() {
        return originalEntry;
    }

    public void setOriginalEntry(Award originalEntry) {
        this.originalEntry = originalEntry;
    }

    public Set<Award> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(Set<Award> suggestions) {
        this.suggestions = suggestions;
    }

    public Set<Book> getAwardedBooks() {
        return awardedBooks;
    }

    public void setAwardedBooks(Set<Book> awardedBooks) {
        this.awardedBooks = awardedBooks;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
