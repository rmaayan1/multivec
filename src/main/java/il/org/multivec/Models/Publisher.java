package il.org.multivec.Models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Publishers")
public class Publisher {
    @Id
    @Column(name = "Publisher_Id")
    private BigInteger id;
    @Column(name = "Name", nullable = false)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher originalEntry;

    @OneToMany(mappedBy = "originalEntry")
    private Set<Publisher> suggestions = new HashSet<>();

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
}
