package patika.dev.libraryControlSystem.entitties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book_borrowings")
public class BookBorrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_borrowing_id", columnDefinition = "serial")
    private int id;

    @NotNull
    @Column(name = "book_borrowing_name")
    private String borrowerName;

    @NotNull
    @Column(name = "book_borrowing_mail")
    private String borrowerEmail;

    @NotNull
    @Column(name = "book_borrowing_date")
    private LocalDate borrowingDate;

    @NotNull
    @Column(name = "book_borrowing_return_date")
    private LocalDate returnDate;

    @ManyToOne()
    @JoinColumn(name = "book_borrowing_book_id", referencedColumnName = "book_id")
    private Book book;
}
