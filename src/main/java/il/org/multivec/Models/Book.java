package il.org.multivec.Models;

import il.org.multivec.Enums.AwardStatus;
import il.org.multivec.Enums.BookType;
import il.org.multivec.Enums.PublicationType;
import il.org.multivec.Enums.TargetAudience;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "Books", indexes = {
        @Index(columnList = "Hebrew_Name"),
        @Index(columnList = "English_Name"),
        @Index(columnList = "Publication_Type"),
        @Index(columnList = "Number_Of_Pages"),
        @Index(columnList = "Book_Type"),
        @Index(columnList = "Primary_Genre"),
        @Index(columnList = "Secondary_Genre"),
        @Index(columnList = "Target_Audience"),
        @Index(columnList = "ISBN", unique = true),
        @Index(columnList = "Danacode", unique = true),
        @Index(columnList = "Gefen_Award_Status"),
        @Index(columnList = "Gefen_Nomination_year"),
        @Index(columnList = "IsDeleted")
})
public class Book {
    @Id
    @Column(name = "Book_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    @Column(nullable = false, name = "Hebrew_Name")
    private String hebrewName;
    @Column(nullable = false, name = "English_Name")
    private String englishName;
    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
            name = "Book_Author",
            joinColumns = { @JoinColumn(name = "Book_Id") },
            inverseJoinColumns = { @JoinColumn(name = "Person_Id") }
    )
    private Set<Person> authors = new HashSet<>();
    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
            name = "Book_Editor",
            joinColumns = { @JoinColumn(name = "Book_Id") },
            inverseJoinColumns = { @JoinColumn(name = "Person_Id") }
    )
    private Set<Person> editors = new HashSet<>();
    @ManyToOne
    private BookSeries series;
    @Enumerated(EnumType.STRING)
    @Column(name = "Publication_Type", nullable = false)
    private PublicationType publicationType;
    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
            name = "Book_Translator",
            joinColumns = { @JoinColumn(name = "Book_Id") },
            inverseJoinColumns = { @JoinColumn(name = "Person_Id") }
    )
    private Set<Person> translators = new HashSet<>();
    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
            name = "Book_Publisher",
            joinColumns = { @JoinColumn(name = "Book_Id") },
            inverseJoinColumns = { @JoinColumn(name = "Publisher_Id") }
    )
    private Set<Publisher> publishers = new HashSet<>();
    @Column(name = "Original_Publishing_Date", nullable = false)
    private Date originalPublishingDate;
    @Column(name = "Hebrew_Publishing_Date", nullable = false)
    private Date hebrewPublishingDate;
    @Column(name = "Number_Of_Pages")
    private int numberOfPages;
    @Enumerated(EnumType.STRING)
    @Column(name = "Book_Type", nullable = false)
    private BookType bookType;
    @Column(name = "Primary_Genre", nullable = false)
    private String primaryGenre;
    @Column(name = "Secondary_Genre", nullable = false)
    private String SecondaryGenre;
    @Enumerated(EnumType.STRING)
    @Column(name = "Target_Audience", nullable = false)
    private TargetAudience targetAudience;
    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
            name = "Book_Illustrator",
            joinColumns = { @JoinColumn(name = "Book_Id") },
            inverseJoinColumns = { @JoinColumn(name = "Person_Id") }
    )
    private Set<Person> illustrators = new HashSet<>();
    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
            name = "Book_Front_Cover_Illustrator",
            joinColumns = { @JoinColumn(name = "Book_Id") },
            inverseJoinColumns = { @JoinColumn(name = "Person_Id") }
    )
    private Set<Person> frontCoverIllustrators = new HashSet<>();
    @Column(name = "ISBN")
    private BigInteger ISBN;
    @Column(name = "Danacode")
    private String danacode;
    @Enumerated(EnumType.STRING)
    @Column(name = "Gefen_Award_Status")
    private AwardStatus gefenAwardStatus;
    @Column(name = "Gefen_Nomination_year")
    private Date gefenNominationYear;
    @ManyToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Book_Award",
            joinColumns = { @JoinColumn(name = "Book_Id") },
            inverseJoinColumns = { @JoinColumn(name = "Award_Id") }
    )
    private Set<Award> awards = new HashSet<>();
    @Lob
    @Column(name = "Cover_Image", columnDefinition="BLOB")
    private byte[] coverImage;
    @Column(name = "Comments")
    private String comments;
    @ManyToOne(fetch = FetchType.LAZY)
    private Book originalEntry;
    @OneToMany(mappedBy = "originalEntry")
    private Set<Book> suggestions = new HashSet<>();
    @Column(name = "Is_Deleted", nullable = false)
    private Boolean isDeleted;

    public BigInteger getId() {
        return id;
    }

    public String getHebrewName() {
        return hebrewName;
    }

    public void setHebrewName(String hebrewName) {
        this.hebrewName = hebrewName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public Set<Person> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Person> authors) {
        this.authors = authors;
    }

    public Set<Person> getEditors() {
        return editors;
    }

    public void setEditors(Set<Person> editors) {
        this.editors = editors;
    }

    public BookSeries getSeries() {
        return series;
    }

    public void setSeries(BookSeries series) {
        this.series = series;
    }

    public PublicationType getPublicationType() {
        return publicationType;
    }

    public void setPublicationType(PublicationType publicationType) {
        this.publicationType = publicationType;
    }

    public Set<Person> getTranslators() {
        return translators;
    }

    public void setTranslators(Set<Person> translators) {
        this.translators = translators;
    }

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }

    public Date getOriginalPublishingDate() {
        return originalPublishingDate;
    }

    public void setOriginalPublishingDate(Date originalPublishingDate) {
        this.originalPublishingDate = originalPublishingDate;
    }

    public Date getHebrewPublishingDate() {
        return hebrewPublishingDate;
    }

    public void setHebrewPublishingDate(Date hebrewPublishingDate) {
        this.hebrewPublishingDate = hebrewPublishingDate;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public String getPrimaryGenre() {
        return primaryGenre;
    }

    public void setPrimaryGenre(String primaryGenre) {
        this.primaryGenre = primaryGenre;
    }

    public String getSecondaryGenre() {
        return SecondaryGenre;
    }

    public void setSecondaryGenre(String secondaryGenre) {
        SecondaryGenre = secondaryGenre;
    }

    public TargetAudience getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(TargetAudience targetAudience) {
        this.targetAudience = targetAudience;
    }

    public Set<Person> getIllustrators() {
        return illustrators;
    }

    public void setIllustrators(Set<Person> illustrators) {
        this.illustrators = illustrators;
    }

    public Set<Person> getFrontCoverIllustrators() {
        return frontCoverIllustrators;
    }

    public void setFrontCoverIllustrators(Set<Person> frontCoverIllustrators) {
        this.frontCoverIllustrators = frontCoverIllustrators;
    }

    public BigInteger getISBN() {
        return ISBN;
    }

    public void setISBN(BigInteger ISBN) {
        this.ISBN = ISBN;
    }

    public String getDanacode() {
        return danacode;
    }

    public void setDanacode(String danacode) {
        this.danacode = danacode;
    }

    public AwardStatus getGefenAwardStatus() {
        return gefenAwardStatus;
    }

    public void setGefenAwardStatus(AwardStatus gefenAwardStatus) {
        this.gefenAwardStatus = gefenAwardStatus;
    }

    public Date getGefenNominationYear() {
        return gefenNominationYear;
    }

    public void setGefenNominationYear(Date gefenNominationYear) {
        this.gefenNominationYear = gefenNominationYear;
    }

    public Set<Award> getAwards() {
        return awards;
    }

    public void setAwards(Set<Award> awards) {
        this.awards = awards;
    }

    public byte[] getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(byte[] coverImage) {
        this.coverImage = coverImage;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Book getOriginalEntry() {
        return originalEntry;
    }

    public void setOriginalEntry(Book originalEntry) {
        this.originalEntry = originalEntry;
    }

    public Set<Book> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(Set<Book> suggestions) {
        this.suggestions = suggestions;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
