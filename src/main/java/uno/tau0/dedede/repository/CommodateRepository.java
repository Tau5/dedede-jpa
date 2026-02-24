package uno.tau0.dedede.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import uno.tau0.dedede.domain.Book;
import uno.tau0.dedede.domain.Commodate;

import java.util.List;

public interface CommodateRepository extends JpaRepository<Commodate, Long> {
    List<Commodate> findByUserId(Long id);
    List<Commodate> findByBookId(Long id);
    @Query("select c from Commodate c where c.book.id = ?1 and c.returned = false")
    List<Commodate> findByBookIdWhereReturnedIsFalse(Long id);
    List<Commodate> findByUserIdAndBookId(Long userId, Long bookId);
    @Query("select c from Commodate c where c.user.id = ?1 and c.returned = false")
    List<Commodate> findByUserIdWhereReturnedIsFalse(Long userId);
    @Query("select c from Commodate c join c.book b where c.id = ?1 and c.returned = false and b.catalogBook.isbn = ?2")
    List<Commodate> findByUserIdAndIsbnWhereReturnedIsFalse(Long userId, String isbn);
}
