package uno.tau0.dedede.repository;

import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.ListCrudRepository;
import uno.tau0.dedede.domain.Book;

import java.util.List;

public interface BookRepository extends ListCrudRepository<Book, Long> {
    List<Book> findByCatalogBookIsbn(String isbn);

    @NativeQuery("select * from book where book.book_isbn = ?1 and book.id not in (select book_id from commodate c where c.book_id = book.id and returned = false);")
    List<Book> findByIsbnWhereBookIsFree(String isbn);
}
