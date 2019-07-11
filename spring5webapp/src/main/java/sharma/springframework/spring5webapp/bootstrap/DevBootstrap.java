package sharma.springframework.spring5webapp.bootstrap;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sharma.springframework.spring5webapp.model.Author;
import sharma.springframework.spring5webapp.model.Book;
import sharma.springframework.spring5webapp.model.Publisher;
import sharma.springframework.spring5webapp.repositories.AuthorRepository;
import sharma.springframework.spring5webapp.repositories.BookRepository;
import sharma.springframework.spring5webapp.repositories.PublisherRepository;
/*

Both of them provides the same functionality and the only difference between CommandLineRunner and ApplicationRunner is
CommandLineRunner.run() accepts String array[] whereas ApplicationRunner.run() accepts ApplicationArguments as argument.
*/


@Component
//public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
//public class DevBootstrap implements CommandLineRunner {
public class DevBootstrap implements ApplicationRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    //used with ApplicationListener***********************************************
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        initData();
//    }
    private  void initData(){
        Author kuldeep = new Author("Kuldeep", "Sharma");
        Publisher publisher = new Publisher("Divit Publication","Shyam Nagar");
        publisherRepository.save(publisher);
        Book book = new Book("Spring book", "123456", publisher);
        kuldeep.getBooks().add(book);
        book.getAuthors().add(kuldeep);
        authorRepository.save(kuldeep);
        bookRepository.save(book);

         kuldeep = new Author("Kuldeep1", "Sharma1");
         publisher = new Publisher("Raghav Publication","Shyam Nagar");
         publisherRepository.save(publisher);
         book = new Book("Spring book1", "1234561", publisher);
         kuldeep.getBooks().add(book);
         book.getAuthors().add(kuldeep);
         authorRepository.save(kuldeep);
         bookRepository.save(book);


    }

//    @Override
//    public void run(String... args) throws Exception {
//        initData();
//    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initData();
    }
}
