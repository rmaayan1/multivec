package il.org.multivec.Models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Nicknames", indexes = {
        @Index(columnList = "Is_Deleted")
})
public class Nickname {
    @Id
    @Column(name = "Nickname_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Nickname originalEntry;
    @OneToMany(mappedBy = "originalEntry")
    private Set<Nickname> suggestions = new HashSet<>();
    @Column(name = "Is_Deleted", nullable = false)
    private Boolean isDeleted;

    public BigInteger getId() {
        return id;
    }

    public Nickname getOriginalEntry() {
        return originalEntry;
    }

    public void setOriginalEntry(Nickname originalEntry) {
        this.originalEntry = originalEntry;
    }

    public Set<Nickname> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(Set<Nickname> suggestions) {
        this.suggestions = suggestions;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
