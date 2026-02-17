package uno.tau0.dedede.view.bibliotecario;

import uno.tau0.dedede.view.MenuHelper;
import uno.tau0.dedede.view.Model;
import uno.tau0.dedede.view.View;
import uno.tau0.dedede.view.ViewManager;

import java.sql.SQLException;

public class DeleteLibroView implements View {
    @Override
    public void run(Model model, ViewManager viewManager) {
        model.catalog.findAll().forEach(book -> {
            System.out.println(book);
        });

        System.out.print("ISBN a eliminar: ");
        String id = MenuHelper.sc.nextLine();

        model.catalog.deleteById(id);

        viewManager.switchView(new ViewBibliotecario());
    }
}
