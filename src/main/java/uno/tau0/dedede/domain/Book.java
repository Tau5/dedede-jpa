package uno.tau0.dedede.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long ID;
    @ManyToOne @Getter
    @JoinColumn(name = "book_isbn")
    private CatalogBook catalogBook;
}
