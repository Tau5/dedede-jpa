package uno.tau0.dedede.domain;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Entity;

import java.time.Duration;
import java.time.Instant;

@Entity
@AllArgsConstructor
public class Commodate {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @OneToOne
    @JoinColumn(name = "book")
    @Getter
    private Book book;

    @ManyToOne @Getter
    @JoinColumn(name = "libraryUser")
    private User user;

    @Getter
    private Instant issueDate;
    @Getter
    private Instant periodEnd;
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
