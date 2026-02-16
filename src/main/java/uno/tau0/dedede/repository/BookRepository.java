package uno.tau0.dedede.repository;

import org.springframework.data.repository.ListCrudRepository;
import uno.tau0.dedede.domain.Book;

import java.util.List;

public interface BookRepository extends ListCrudRepository<Book, Long> {
    List<Book> findByCatalgoBookIsbn(String isbn);
}
