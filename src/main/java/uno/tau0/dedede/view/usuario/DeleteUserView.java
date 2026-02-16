package uno.tau0.dedede.view.usuario;

import uno.tau0.dedede.domain.User;
import uno.tau0.dedede.view.*;

import java.sql.SQLException;

public class DeleteUserView implements View {

    private User user;

    public DeleteUserView(User user) {
        this.user = user;
    }
    @Override
    public void run(Model model, ViewManager viewManager) {
        System.out.print("¿Estás segure (y/N)? ");
        MenuHelper.sc.nextLine();
        String response = MenuHelper.sc.nextLine();
        if (response.equals("y")) {
            model.users.deleteById(user.getId());
            viewManager.switchView(new ViewModo());
        } else {
            viewManager.switchView(new UserHomeView(user));
        }
    }

}
