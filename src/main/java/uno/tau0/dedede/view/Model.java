package uno.tau0.dedede.view;

import uno.tau0.dedede.repository.*;
import uno.tau0.dedede.repository.BookRepository;
import uno.tau0.dedede.repository.CatalogBookRepository;
import uno.tau0.dedede.repository.CommodateRepository;
import uno.tau0.dedede.repository.UserRepository;

final public class Model {
    public BookRepository books;
    public CatalogBookRepository catalog;
    public CommodateRepository commodates;
    public UserRepository users;

    Model(BookRepository bookRepository, CatalogBookRepository catalogBookRepository,
          CommodateRepository commodateRepository, UserRepository userRepository) {
        this.books = bookRepository;
        this.catalog = catalogBookRepository;
        this.commodates = commodateRepository;
        this.users = userRepository;
    }
}
