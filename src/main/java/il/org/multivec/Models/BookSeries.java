package il.org.multivec.Models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Set;

@Entity
@Table(name = "BookSeries", indexes = {
        @Index(columnList = "Series_Name")
})
public class BookSeries {
    @Id
    @Column(name = "Series_Id")
    private BigInteger id;
    @Column(name = "Series_Name")
    private String seriesName;
    @OneToMany(mappedBy = "series")
    private Set<Book> books;

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
}
