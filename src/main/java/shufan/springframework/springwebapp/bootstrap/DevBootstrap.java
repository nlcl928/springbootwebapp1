package shufan.springframework.springwebapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import shufan.springframework.springwebapp.model.Author;
import shufan.springframework.springwebapp.model.Book;
import shufan.springframework.springwebapp.model.Publisher;
import shufan.springframework.springwebapp.repositories.AuthorRepository;
import shufan.springframework.springwebapp.repositories.BookRepository;
import shufan.springframework.springwebapp.repositories.PublisherRepository;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher hc = new Publisher();
        hc.setName("Harper Collins");

        Publisher rm = new Publisher();
        rm.setName("Ren Min");

        publisherRepository.save(hc);
        publisherRepository.save(rm);

        // shufan
        Author shufan = new Author("Shufan", "Wang");
        Book tij = new Book("Thinking In Java", "12345", hc);
        shufan.getBooks().add(tij);
        tij.getAuthors().add(shufan);

        authorRepository.save(shufan);
        bookRepository.save(tij);

        //Nick
        Author nick = new Author("Nick","Wang");
        Book jfwa = new Book("Java for Web Applications", "54321", rm);
        nick.getBooks().add(jfwa);
        jfwa.getAuthors().add(nick);

        authorRepository.save(nick);
        bookRepository.save(jfwa);

    }
}
