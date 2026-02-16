package uno.tau0.dedede.services;

import org.springframework.beans.factory.annotation.Autowired;
import uno.tau0.dedede.repository.*;
import uno.tau0.dedede.domain.*;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private CommodateService commodateService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CommodateRepository commodateRepository;

    public boolean isBookBorrowed(Book book) {
        return !commodateRepository.findByBookIdWhereReturnedIsFalse(book.getID()).isEmpty();
    }

    public Commodate borrowBook(Book book, User user) throws SQLException, BookAlreadyBorrowedException {
        if (isBookBorrowed(book)) {
            throw new BookAlreadyBorrowedException("Esta copia ya está prestada");
        } else if (userHasAlreadyBorrowedACopy(book, user)) {
            throw new BookAlreadyBorrowedException("Ya se ha prestado una copia de este libro al usuario");
        } else {
            return commodateService.registerCommodate(book, user);
        }
    }

    public List<Book> getBooksForCatalogBook(CatalogBook catalogBook) throws SQLException {
        return bookRepository.findAllList().stream().filter(b -> b.getBookISBN().equals(catalogBook.getISBN())).toList();
    }

    public boolean userHasAlreadyBorrowedACopy(Book book, User user) throws SQLException {
        return !commodateRepository.findByUserIdAndIsbnWhereReturnedIsFalse(user.getId(), book.getCatalogBook().getIsbn()).isEmpty();
    }

    public class BookAlreadyBorrowedException extends RuntimeException {
        public BookAlreadyBorrowedException(String message) {
            super(message);
        }
    }
}
