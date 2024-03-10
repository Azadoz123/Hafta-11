package patika.dev.libraryControlSystem.dto.request.bookBorrowing;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import patika.dev.libraryControlSystem.entitties.Book;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingSaveRequestDto {

    @NotNull
    private String borrowerName;

    @NotNull
    @Email
    private String borrowerEmail;

    @NotNull
    private LocalDate borrowingDate;

    @NotNull
    private LocalDate returnDate;

    @NotNull
    private int bookId;
}
