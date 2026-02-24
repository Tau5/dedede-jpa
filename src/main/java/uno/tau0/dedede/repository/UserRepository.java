package uno.tau0.dedede.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import uno.tau0.dedede.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
