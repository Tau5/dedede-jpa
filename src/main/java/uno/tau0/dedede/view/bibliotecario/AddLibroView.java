package uno.tau0.dedede.view.bibliotecario;

import uno.tau0.dedede.domain.CatalogBook;
import uno.tau0.dedede.services.CatalogService;
import uno.tau0.dedede.view.MenuHelper;
import uno.tau0.dedede.view.Model;
import uno.tau0.dedede.view.View;
import uno.tau0.dedede.view.ViewManager;

import java.sql.SQLException;

public class AddLibroView implements View {
    @Override
    public void run(Model model, ViewManager viewManager) {
        CatalogService service = new CatalogService();
        System.out.print("Título: ");
        String title = MenuHelper.sc.nextLine();

        System.out.print("Autor: ");
        String author = MenuHelper.sc.nextLine();

        System.out.print("ISBN: ");
        String isbn = MenuHelper.sc.nextLine().strip();
        int stock = MenuHelper.getNumber("Cantidad: ");

        try {
            service.createCatalogBookWithStock(new CatalogBook(isbn, author, title), stock);
            System.out.println("Libro creado satisfactoriamente!");
        } catch (SQLException e) {
            System.out.println("Error: Error al insertar en la base de datos (" + e.getLocalizedMessage() + ")");
        } catch (CatalogBook.InvalidISBNException e) {
            System.out.println("Error: ISBN inválido");
        }


        viewManager.switchView(new ViewBibliotecario());
    }
}
