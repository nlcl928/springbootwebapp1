package shufan.springframework.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import shufan.springframework.springwebapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
