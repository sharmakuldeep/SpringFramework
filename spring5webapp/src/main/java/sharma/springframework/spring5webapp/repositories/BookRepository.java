package sharma.springframework.spring5webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sharma.springframework.spring5webapp.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
