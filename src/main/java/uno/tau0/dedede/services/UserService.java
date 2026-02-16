package uno.tau0.dedede.services;

import uno.tau0.dedede.domain.Commodate;
import uno.tau0.dedede.domain.User;
import uno.tau0.dedede.view.Model;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    CommodateService commodateService;

    public UserService(Model model) {
        this.commodateService = new CommodateService(model);
    }

    public List<Commodate> getCommodates(User user) throws SQLException {
        return commodateService.getCommodatesForUser(user);
    }
}
