package uno.tau0.dedede;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "catalogbook")
public class CatalogBook {
    @Id @Getter @Setter
    @NonNull private String isbn;
    @NonNull private String title;
    @NonNull private String author;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "catalogBook")
    public Set<Book> books;
}
