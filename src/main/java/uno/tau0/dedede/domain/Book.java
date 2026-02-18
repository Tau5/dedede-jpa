package uno.tau0.dedede.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter
    @JoinColumn(name = "book_isbn")
    private CatalogBook catalogBook;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book", cascade = CascadeType.REMOVE, orphanRemoval = true)
    public Set<Commodate> commodates;
}
