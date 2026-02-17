package uno.tau0.dedede.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import uno.tau0.dedede.domain.CatalogBook;

import java.util.List;

public interface CatalogBookRepository extends ListCrudRepository<CatalogBook, String> {
    @NativeQuery("select distinct cb.* from CatalogBook as cb " +
            "join book on book.book_isbn = cb.isbn where book.id not in (select book from commodate c where c.book = book.id and returned = false);")
    List<CatalogBook> findWhereAnyBookFree();
}
