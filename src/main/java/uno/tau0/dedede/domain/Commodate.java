package uno.tau0.dedede.domain;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Entity;

import java.time.Duration;
import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Commodate {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @OneToOne
    @JoinColumn(name = "book")
    @Getter @Setter
    private Book book;

    @ManyToOne @Getter @Setter
    @JoinColumn(name = "libraryUser")
    private User user;

    @Getter @Setter
    private Instant issueDate;
    @Getter @Setter
    private Instant periodEnd;
    @Getter @Setter
    private Boolean returned;

    public boolean isActive() {
        return !returned;
    }

    public boolean isDue() {
        return Instant.now().isAfter(periodEnd) && !isActive();
    }

    public Duration timeLeft() {
        return Instant.now().until(periodEnd);
    }
}
