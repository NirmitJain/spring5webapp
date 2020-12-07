package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.module.Author;
import guru.springframework.spring5webapp.module.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author one = new Author("one","author");
        Book bookOne = new Book("titleOne","3244354");

        Author two = new Author("two","Author");
        Book bookTwo = new Book("titleTwo","3433454");

        one.getBooks().add(bookOne);
        bookOne.getAuthors().add(one);

        two.getBooks().add(bookTwo);
        bookTwo.getAuthors().add(two);

        authorRepository.save(one);
        authorRepository.save(two);

        bookRepository.save(bookOne);
        bookRepository.save(bookTwo);

        System.out.println("BootStrap started");
        System.out.println("Number of books : " + bookRepository.count());
    }

}
