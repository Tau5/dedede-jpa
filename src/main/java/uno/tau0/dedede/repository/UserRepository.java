package uno.tau0.dedede.repository;

import org.springframework.data.repository.ListCrudRepository;
import uno.tau0.dedede.domain.User;

public interface UserRepository extends ListCrudRepository<User, Long> {
}
