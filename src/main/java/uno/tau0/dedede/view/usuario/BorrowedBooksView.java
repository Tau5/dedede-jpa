package uno.tau0.dedede.view.usuario;

import uno.tau0.dedede.domain.CatalogBook;
import uno.tau0.dedede.domain.User;
import uno.tau0.dedede.services.CommodateService;
import uno.tau0.dedede.view.Model;
import uno.tau0.dedede.view.View;
import uno.tau0.dedede.view.ViewManager;

import java.sql.SQLException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class BorrowedBooksView implements View {
    private User user;
    public BorrowedBooksView(User user) {
        this.user = user;
    }

    @Override
    public void run(Model model, ViewManager viewManager) {
        model.commodates.findByUserIdWhereReturnedIsFalse(user.getId()).forEach((commodate) -> {
            CatalogBook cb = commodate.getBook().getCatalogBook();
            System.out.println(cb + ", Caduca en: " + commodate.timeLeft().toDays() + " días");
        });

        viewManager.switchView(new UserHomeView(user));
    }
}
