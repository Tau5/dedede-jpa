package uno.tau0.dedede.services;

import org.springframework.beans.factory.annotation.Autowired;
import uno.tau0.dedede.repository.*;
import uno.tau0.dedede.domain.*;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private CommodateService commodateService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CommodateRepository commodateRepository;

    public boolean isBookBorrowed(Book book) {
        return !commodateRepository.findByBookIdWhereReturnedIsFalse(book.getId()).isEmpty();
    }

    public Commodate borrowBook(Book book, User user) throws BookAlreadyBorrowedException {
        if (isBookBorrowed(book)) {
            throw new BookAlreadyBorrowedException("Esta copia ya está prestada");
        } else if (userHasAlreadyBorrowedACopy(book, user)) {
            throw new BookAlreadyBorrowedException("Ya se ha prestado una copia de este libro al usuario");
        } else {
            return commodateService.registerCommodate(book, user);
        }
    }

    public boolean userHasAlreadyBorrowedACopy(Book book, User user) {
        return !commodateRepository.findByUserIdAndIsbnWhereReturnedIsFalse(user.getId(), book.getCatalogBook().getIsbn()).isEmpty();
    }

    public class BookAlreadyBorrowedException extends RuntimeException {
        public BookAlreadyBorrowedException(String message) {
            super(message);
        }
    }
}
