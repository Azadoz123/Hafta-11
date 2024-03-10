package patika.dev.libraryControlSystem.dto.request.book;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateRequestDto {

    @NotNull
    private int id;

    @NotNull
    private String name;

    @NotNull
    private LocalDate publicationYear;

    @NotNull
    private int stock;

    @NotNull
    private int authorId;

    @NotNull
    private int publisherId;
}
