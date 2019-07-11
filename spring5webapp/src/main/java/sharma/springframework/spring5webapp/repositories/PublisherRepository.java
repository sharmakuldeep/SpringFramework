package sharma.springframework.spring5webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sharma.springframework.spring5webapp.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
