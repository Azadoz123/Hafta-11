package patika.dev.libraryControlSystem.dto.request.bookBorrowing;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingUpdateRequestDto {

    @NotNull
    private int id;

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
