package il.org.multivec;

import il.org.multivec.Enums.BookType;
import il.org.multivec.Enums.PublicationType;
import il.org.multivec.Enums.TargetAudience;
import il.org.multivec.Models.Book;
import il.org.multivec.Models.Person;
import il.org.multivec.Repositories.BookRepository;
import il.org.multivec.Repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MultivecApplicationTests {
    @Autowired private BookRepository bookRepository;
    @Autowired private PersonRepository personRepository;

    @Test
    @Transactional
    void contextLoads() {
        Person authorIn = new Person();
        authorIn.setFirstName("Author's first name");
        authorIn.setLastName("Author's last name");
        authorIn.setDeleted(false);
        authorIn = personRepository.save(authorIn);

        Book bookIn = new Book();
        bookIn.setHebrewName("אבגד");
        bookIn.setEnglishName("Abcd");
        bookIn.setBookType(BookType.NOVEL);
        bookIn.setPrimaryGenre("Best Genre Ever");
        bookIn.setSecondaryGenre("Genre number 5");
        bookIn.setHebrewPublishingDate(new Date());
        bookIn.setOriginalPublishingDate(new Date());
        bookIn.setDeleted(false);
        bookIn.setPublicationType(PublicationType.ORIGINAL);
        bookIn.setTargetAudience(TargetAudience.ADULTS);
        Set<Person> authors = new HashSet<>();
        authors.add(authorIn);
        bookIn.setAuthors(authors);
        bookIn = bookRepository.save(bookIn);

        Optional<Book> bookOutOptional = bookRepository.findById(bookIn.getId());
        assertTrue(bookOutOptional.isPresent());
        Book bookOut = bookOutOptional.get();
        assertEquals(bookOut.getId(), bookIn.getId());
        Person authorOut = bookOut.getAuthors().iterator().next();
        assertEquals(authorOut.getId(), authorIn.getId());

    }

}
