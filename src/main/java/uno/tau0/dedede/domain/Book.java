package uno.tau0.dedede.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @ManyToOne @Getter @Setter
    @JoinColumn(name = "book_isbn")
    private CatalogBook catalogBook;
}
