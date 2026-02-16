package uno.tau0.dedede.view.usuario;

import uno.tau0.dedede.domain.User;
import uno.tau0.dedede.view.MenuHelper;
import uno.tau0.dedede.view.Model;
import uno.tau0.dedede.view.View;
import uno.tau0.dedede.view.ViewManager;

import java.sql.SQLException;

public class ViewRegistrarse implements View {
    @Override
    public void run(Model model, ViewManager viewManager) {
        MenuHelper.sc.reset();
        System.out.print("nombre: ");
        String nombre = MenuHelper.sc.nextLine();
        System.out.print("apellidos: ");
        String apellidos = MenuHelper.sc.nextLine();


        User user = new User();
        user.setName(nombre);
        user.setSurname(apellidos);

        user = model.users.save(user);

        System.out.println(user.getId());

        viewManager.switchView(
            new UserHomeView(user)
        );
    }
}
