package uno.tau0.dedede;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.Optional;

interface CatalogBookRepository extends ListCrudRepository<CatalogBook, String> {
}
