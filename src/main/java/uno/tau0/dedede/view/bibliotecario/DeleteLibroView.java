package uno.tau0.dedede.view.bibliotecario;

import uno.tau0.dedede.view.MenuHelper;
import uno.tau0.dedede.view.Model;
import uno.tau0.dedede.view.View;
import uno.tau0.dedede.view.ViewManager;

import java.sql.SQLException;

public class DeleteLibroView implements View {
    @Override
    public void run(Model model, ViewManager viewManager) {
        try {
            model.catalog.findAll().forEach(book -> {
                System.out.println(book);
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.print("ISBN a eliminar: ");
        String id = MenuHelper.sc.nextLine();

        try {
            model.catalog.deleteById(id);
        } catch (SQLException e) {
            System.out.println("Error: No existe un libro con ese ID (" + e.getLocalizedMessage() + ")");
        }

        viewManager.switchView(new ViewBibliotecario());
    }
}
