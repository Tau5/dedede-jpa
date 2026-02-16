package uno.tau0.dedede.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import uno.tau0.dedede.domain.Book;
import uno.tau0.dedede.domain.Commodate;

import java.util.List;

public interface CommodateRepository extends ListCrudRepository<Commodate, Long> {
    List<Commodate> findByUserId(Long id);
    List<Commodate> findByBookId(Long id);
    List<Commodate> findByBookIdWhereReturnedIsFalse(Long id);
    List<Commodate> findByUserIdAndBookId(Long userId, Long bookId);
    List<Commodate> findByUserIdWhereReturnedIsFalse(Long userId);
    @Query("select c from Commodate c join c.book b where c.id = ?1 and c.returned = false and b.isbn = ?2")
    List<Commodate> findByUserIdAndIsbnWhereReturnedIsFalse(Long userId, String isbn);
}
