package uno.tau0.dedede.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import uno.tau0.dedede.repository.*;
import uno.tau0.dedede.repository.BookRepository;
import uno.tau0.dedede.repository.CatalogBookRepository;
import uno.tau0.dedede.repository.CommodateRepository;
import uno.tau0.dedede.repository.UserRepository;

@Component
final public class Model {
    @Autowired
    public BookRepository books;
    @Autowired
    public CatalogBookRepository catalog;
    @Autowired
    public CommodateRepository commodates;
    @Autowired
    public UserRepository users;
}
