package uno.tau0.dedede.view.bibliotecario;

import uno.tau0.dedede.view.Model;
import uno.tau0.dedede.view.View;
import uno.tau0.dedede.view.ViewManager;

import java.sql.SQLException;

public class ListBooksView implements View {

    @Override
    public void run(Model model, ViewManager viewManager) {

        var books = model.catalog;
        try {
            books.findAllList().forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("No se han podido encontrar los libros (" + e.getLocalizedMessage() +")");
        }
        viewManager.switchView(new ViewBibliotecario());
    }
}
