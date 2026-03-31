package guru.springframework.sdjpa_intro.bootstrap;

import guru.springframework.sdjpa_intro.domain.Book;
import guru.springframework.sdjpa_intro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        Book bookDDD = new Book("Domain Driven Design", "12345", "RandomPublisher");
        Book saveBookDDD = bookRepository.save(bookDDD);

        Book bookSIA = new Book("Spring In Action", "67890", "RandomPublisher");
        Book saveBookSIA = bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book ID: " + book.getId());
            System.out.println("Book Title: " + book.getTitle());
            System.out.println("Book ISBN: " + book.getIsbn());
            System.out.println("Book Publisher: " + book.getPublisher());
        });
    }
}
