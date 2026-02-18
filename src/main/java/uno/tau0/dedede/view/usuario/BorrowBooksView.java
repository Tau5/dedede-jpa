package uno.tau0.dedede.view.usuario;

import uno.tau0.dedede.domain.Book;
import uno.tau0.dedede.domain.CatalogBook;
import uno.tau0.dedede.domain.User;
import uno.tau0.dedede.services.BookService;
import uno.tau0.dedede.services.CatalogService;
import uno.tau0.dedede.view.MenuHelper;
import uno.tau0.dedede.view.Model;
import uno.tau0.dedede.view.View;
import uno.tau0.dedede.view.ViewManager;

import java.sql.SQLException;
import java.util.List;

public class BorrowBooksView implements View {
    private User user;
    public BorrowBooksView(User user) {
        this.user = user;
    }

    @Override
    public void run(Model model, ViewManager viewManager) {
        var catalog = model.catalog;
        var catalogService = viewManager.getBean(CatalogService.class);
        var bookService = viewManager.getBean(BookService.class);
        List<CatalogBook> listBook;
        List<Book> listBookAvaible;
        System.out.println("Lista de libros que no estan prestados");

        listBook = catalog.findWhereAnyBookFree();

        if (listBook.isEmpty()) {
            System.out.println("Error: No hay libros disponibles para prestar");
            viewManager.switchView(new UserHomeView(user));
            return;
        }

        listBook.forEach(b -> System.out.println(b));
        System.out.print("Elige el ISBN del libro que prestar:");
        var id = MenuHelper.sc.nextLine();
        catalog.findById(id).ifPresent(cb -> {
                var libros = catalogService.getAvailableBooksForCatalogBook(cb);

                if (libros.size() < 1) {
                    System.out.println("No hay libros disponibles para ese libro");
                } else {
                    var libro = libros.getFirst();
                    try {
                        bookService.borrowBook(libro, user);
                    } catch (BookService.BookAlreadyBorrowedException e) {
                        System.out.println("No se ha podido prestar: " + e.getMessage());
                    }
                }
        });
        viewManager.switchView(new UserHomeView(user));
    }
}
