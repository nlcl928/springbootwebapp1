package shufan.springframework.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import shufan.springframework.springwebapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
