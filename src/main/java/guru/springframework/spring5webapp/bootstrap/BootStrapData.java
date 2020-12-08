package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.module.Author;
import guru.springframework.spring5webapp.module.Book;
import guru.springframework.spring5webapp.module.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class BootStrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author one = new Author("one","author");
        Book bookOne = new Book("titleOne","3244354");

        Publisher publisher = new Publisher("publisher","lane z","x city", "y state", 123433L);

        publisherRepository.save(publisher);

        one.getBooks().add(bookOne);
        bookOne.getAuthors().add(one);

        bookOne.setPublisher(publisher);
        publisher.getBooks().add(bookOne);


        authorRepository.save(one);
        bookRepository.save(bookOne);
        publisherRepository.save(publisher);

        System.out.println("Publisher Count : " + publisherRepository.count());

        Author two = new Author("two","Author");
        Book bookTwo = new Book("titleTwo","3433454");


        two.getBooks().add(bookTwo);
        bookTwo.getAuthors().add(two);

        bookTwo.setPublisher(publisher);
        publisher.getBooks().add(bookTwo);

        authorRepository.save(two);
        bookRepository.save(bookTwo);
        publisherRepository.save(publisher);


        System.out.println("BootStrap started");
        System.out.println("Number of books : " + bookRepository.count() + "\n" + "Publisher has Books  : " + publisher.getBooks().size());

    }

}
