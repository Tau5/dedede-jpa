package uno.tau0.dedede.view.usuario;

import uno.tau0.dedede.view.MenuHelper;
import uno.tau0.dedede.view.Model;
import uno.tau0.dedede.view.View;
import uno.tau0.dedede.view.ViewManager;

public class UserView implements View {
    @Override
    public void run(Model model, ViewManager viewManager) {
        MenuHelper menu = new MenuHelper();

        menu.registerOption(1, "Iniciar sesión", ViewIniciarSesion::new);
        menu.registerOption(2, "Registrarse", ViewRegistrarse::new);

        View view = menu.chooseAndExecute("opción:");

        viewManager.switchView(view);
    }
}
