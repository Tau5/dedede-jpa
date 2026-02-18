package uno.tau0.dedede.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import uno.tau0.dedede.domain.Book;
import uno.tau0.dedede.domain.CatalogBook;
import uno.tau0.dedede.repository.BookRepository;
import uno.tau0.dedede.repository.CatalogBookRepository;
import uno.tau0.dedede.repository.CommodateRepository;
import uno.tau0.dedede.view.Model;

import java.sql.SQLException;
import java.util.List;

@Service
public class CatalogService {
    @Autowired
    private BookService bookService;
    @Autowired
    private CatalogBookRepository catalogBookRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CommodateRepository commodateRepository;

    public CatalogService() {}

    public List<Book> getAvailableBooksForCatalogBook(CatalogBook catalogBook) {
        return bookRepository.findByIsbnWhereBookIsFree(catalogBook.getIsbn());
    }

    public void createCatalogBookWithStock(CatalogBook catalogBook, int stock) {
        catalogBookRepository.save(catalogBook);
        for (int i = 0; i < stock; i++) {
            var book = new Book();
            book.setCatalogBook(catalogBook);

            bookRepository.save(book);
        }
    }

}
