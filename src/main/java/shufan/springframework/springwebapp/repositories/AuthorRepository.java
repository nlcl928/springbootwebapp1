package shufan.springframework.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import shufan.springframework.springwebapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
