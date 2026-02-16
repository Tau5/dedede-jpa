package uno.tau0.dedede.view.usuario;

import uno.tau0.dedede.domain.Commodate;
import uno.tau0.dedede.domain.User;
import uno.tau0.dedede.services.CommodateService;
import uno.tau0.dedede.view.MenuHelper;
import uno.tau0.dedede.view.Model;
import uno.tau0.dedede.view.View;
import uno.tau0.dedede.view.ViewManager;

import java.sql.SQLException;
import java.util.List;

public class ReturnBookView implements View {
    private User user;
    public ReturnBookView(User user) {
        this.user = user;
    }

    @Override
    public void run(Model model, ViewManager viewManager) {
        var commodateM = model.commodates;
        var commodateService = new CommodateService(model);
        List<Commodate> commodatesList;

        System.out.println("Libros que puede devolver:");
        try {
            commodatesList = commodateService.getCommodatesForUser(user);
            for (Commodate commodate : commodatesList) {
                System.out.println(commodate.getId() + " " + commodateService.getCatalogBookForCommodate(commodate));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        var id = MenuHelper.getNumber("Ingresa el id del libro que quieres devolver:");

        commodatesList.forEach(commodate -> {
            if (commodate.getId() == id) {
                commodateM.deleteById((long) id);
            }
        });

        viewManager.switchView(new UserHomeView(user));
    }
}
