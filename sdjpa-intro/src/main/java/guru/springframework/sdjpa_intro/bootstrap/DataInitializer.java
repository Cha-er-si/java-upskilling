package guru.springframework.sdjpa_intro.bootstrap;

import guru.springframework.sdjpa_intro.domain.Book;
import guru.springframework.sdjpa_intro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book bookDDD = new Book("Domain Driven Design", "12345", "RandomPublisher");

        System.out.println("ID: " + bookDDD.getId());

        Book saveBookDDD = bookRepository.save(bookDDD);

        System.out.println("ID: " + saveBookDDD.getId());

        Book bookSIA = new Book("Spring In Action", "67890", "RandomPublisher");

        System.out.println("ID: " + bookSIA.getId());

        Book saveBookSIA = bookRepository.save(bookSIA);

        System.out.println("ID: " + saveBookSIA.getId());

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book ID: " + book.getId());
            System.out.println("Book Title: " + book.getTitle());
            System.out.println("Book ISBN: " + book.getIsbn());
            System.out.println("Book Publisher: " + book.getPublisher());
        });
    }
}
