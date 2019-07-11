package sharma.springframework.spring5webapp.bootstrap;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sharma.springframework.spring5webapp.model.Author;
import sharma.springframework.spring5webapp.model.Book;
import sharma.springframework.spring5webapp.repositories.AuthorRepository;
import sharma.springframework.spring5webapp.repositories.BookRepository;
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

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
//used with ApplicationListener***********************************************
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        initData();
//    }
    private  void initData(){
        Author kuldeep = new Author("Kuldeep", "Sharma");
        Book book = new Book("Spring book", "123456", "Sharma Publication");
        kuldeep.getBooks().add(book);
        book.getAuthors().add(kuldeep);
        authorRepository.save(kuldeep);
        bookRepository.save(book);

         kuldeep = new Author("Kuldeep1", "Sharma1");
         book = new Book("Spring book1", "1234561", "Sharma Publication1");
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
