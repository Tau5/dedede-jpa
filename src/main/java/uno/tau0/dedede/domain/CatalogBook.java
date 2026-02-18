package uno.tau0.dedede.domain;

import jakarta.persistence.*;
import lombok.*;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogBook", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Book> books;

    @Override
    public String toString() {
        return "[" + isbn + "] " + title + " por " + "author";
    }
}
