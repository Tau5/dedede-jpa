package uno.tau0.dedede.view.usuario;

import uno.tau0.dedede.domain.User;
import uno.tau0.dedede.view.MenuHelper;
import uno.tau0.dedede.view.Model;
import uno.tau0.dedede.view.View;
import uno.tau0.dedede.view.ViewManager;

import java.sql.SQLException;

public class ViewIniciarSesion implements View {
    @Override
    public void run(Model model, ViewManager viewManager) {
        model.users.findAll().forEach(user -> {
            System.out.println(
                    user.getId() + ": " + user.getName() + " " + user.getSurname()
            );
        });

        int chosen = -1;
        while (true) {
            if (model.users.existsById((long) chosen)) break;
            chosen = MenuHelper.getNumber("id:");
        }

        model.users.findById((long) chosen).ifPresentOrElse(usuario -> {
            System.out.println(usuario.getName());

            viewManager.switchView(
                new UserHomeView(usuario)
            );
        },
        () -> {
            System.out.println("Error: No se ha encontrado un usuario con ese id");
            viewManager.switchView(
                new UserView()
            );
        });

    }
}
