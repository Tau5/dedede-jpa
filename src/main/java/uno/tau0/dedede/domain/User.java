package uno.tau0.dedede.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "libraryUser")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @Getter @Setter
    public String name;

    @Getter @Setter
    public String surname;
}
