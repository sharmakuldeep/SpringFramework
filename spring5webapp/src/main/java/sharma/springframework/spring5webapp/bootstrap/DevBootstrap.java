package sharma.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sharma.springframework.spring5webapp.model.Author;
import sharma.springframework.spring5webapp.model.Book;
import sharma.springframework.spring5webapp.repositories.AuthorRepository;
import sharma.springframework.spring5webapp.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
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
}
