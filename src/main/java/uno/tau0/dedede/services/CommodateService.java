package uno.tau0.dedede.services;

import uno.tau0.dedede.domain.Book;
import uno.tau0.dedede.domain.CatalogBook;
import uno.tau0.dedede.domain.Commodate;
import uno.tau0.dedede.domain.User;
import uno.tau0.dedede.repository.BookRepository;
import uno.tau0.dedede.repository.CatalogBookRepository;
import uno.tau0.dedede.repository.CommodateRepository;
import uno.tau0.dedede.view.Model;

import java.sql.SQLException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class CommodateService {
    CommodateRepository commodateRepository;
    CatalogBookRepository catalogBookRepository;
    BookRepository bookRepository;

    public CommodateService(Model model) {
        this.commodateRepository = model.commodates;
        this.catalogBookRepository = model.catalog;
        this.bookRepository = model.books;
    }

    public List<Commodate> getCommodatesForBook(Book book) {
        try {
            return commodateRepository
                    .findAllList()
                    .stream()
                    .filter(c -> c.getBookID() == book.getID())
                    .toList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Commodate registerCommodate(Book book, User user) {
        var commodate = new Commodate();
        commodate.setBook(book);
        commodate.setUser(user);
        commodate.setIssueDate(Instant.now());
        commodate.setPeriodEnd(Instant.now().plus(15, ChronoUnit.DAYS));
        commodate.setReturned(false);
        return commodateRepository.save(commodate);
    }

    public List<Commodate> getCommodatesForUser(User user) throws SQLException {
        return commodateRepository.findByUserId(user.getId());
    }

    public Book getBookForCommodate(Commodate commodate) throws SQLException {
        return bookRepository.findById(commodate.getBookID());
    }

    public CatalogBook getCatalogBookForCommodate(Commodate commodate) throws SQLException {
        return commodate.getBook().getCatalogBook();
    }

}
