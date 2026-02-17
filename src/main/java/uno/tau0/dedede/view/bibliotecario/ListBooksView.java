package uno.tau0.dedede.view.bibliotecario;

import uno.tau0.dedede.view.Model;
import uno.tau0.dedede.view.View;
import uno.tau0.dedede.view.ViewManager;

import java.sql.SQLException;

public class ListBooksView implements View {

    @Override
    public void run(Model model, ViewManager viewManager) {

        var books = model.catalog;
        books.findAll().forEach(System.out::println);
        viewManager.switchView(new ViewBibliotecario());
    }
}
