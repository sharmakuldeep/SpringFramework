package sharma.springframework.spring5webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sharma.springframework.spring5webapp.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
