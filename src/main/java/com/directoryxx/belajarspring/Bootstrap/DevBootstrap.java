package com.directoryxx.belajarspring.Bootstrap;

import com.directoryxx.belajarspring.Model.Author;
import com.directoryxx.belajarspring.Model.Book;
import com.directoryxx.belajarspring.Model.Publisher;
import com.directoryxx.belajarspring.Repositories.AuthorRepository;
import com.directoryxx.belajarspring.Repositories.BookRepository;
import com.directoryxx.belajarspring.Repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

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

    private void initData(){

        Publisher publish = new Publisher();
        publish.setName("Dinamika");

        publisherRepository.save(publish);

        //Angga
        Author angga = new Author("Angga","Wijaya");
        Book book1 = new Book("Rancang Bangun Blabla","1234",publish);
        angga.getBooks().add(book1);
        book1.getAuthors().add(angga);

        authorRepository.save(angga);
        bookRepository.save(book1);

        //Angga2
        Author angga2 = new Author("Angga","Wijaya");
        Book book2 = new Book("Analisis Blabla","1234",publish);
        angga2.getBooks().add(book2);
        //book2.getAuthors().add(angga2);

        authorRepository.save(angga2);
        bookRepository.save(book2);

    }
}
