package il.org.multivec.Models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Publishers", indexes = {
        @Index(columnList = "Name"),
        @Index(columnList = "Is_Deleted")
})
public class Publisher {
    @Id
    @Column(name = "Publisher_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    @Column(name = "Name", nullable = false)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher originalEntry;
    @OneToMany(mappedBy = "originalEntry")
    private Set<Publisher> suggestions = new HashSet<>();
    @Column(name = "Is_Deleted", nullable = false)
    private Boolean isDeleted;

    public BigInteger getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Publisher getOriginalEntry() {
        return originalEntry;
    }

    public void setOriginalEntry(Publisher originalEntry) {
        this.originalEntry = originalEntry;
    }

    public Set<Publisher> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(Set<Publisher> suggestions) {
        this.suggestions = suggestions;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
