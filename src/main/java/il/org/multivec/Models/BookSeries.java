package il.org.multivec.Models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Book_Series", indexes = {
        @Index(columnList = "Series_Name"),
        @Index(columnList = "IsDeleted")
})
public class BookSeries {
    @Id
    @Column(name = "Series_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    @Column(name = "Series_Name")
    private String seriesName;
    @OneToMany(mappedBy = "series")
    private Set<Book> books;
    @ManyToOne(fetch = FetchType.LAZY)
    private BookSeries originalEntry;
    @OneToMany(mappedBy = "originalEntry")
    private Set<BookSeries> suggestions = new HashSet<>();
    @Column(name = "Is_Deleted", nullable = false)
    private Boolean isDeleted;

    public BigInteger getId() {
        return id;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public BookSeries getOriginalEntry() {
        return originalEntry;
    }

    public void setOriginalEntry(BookSeries originalEntry) {
        this.originalEntry = originalEntry;
    }

    public Set<BookSeries> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(Set<BookSeries> suggestions) {
        this.suggestions = suggestions;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
