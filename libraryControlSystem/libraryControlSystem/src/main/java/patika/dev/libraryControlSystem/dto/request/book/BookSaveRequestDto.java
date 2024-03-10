package patika.dev.libraryControlSystem.dto.request.book;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import patika.dev.libraryControlSystem.entitties.Author;
import patika.dev.libraryControlSystem.entitties.Publisher;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveRequestDto {

    @NotNull
    String name;

    @NotNull
    LocalDate publicationYear;

    @NotNull
    int stock;

    @NotNull
    private int authorId;

    @NotNull
    private int publisherId;
}
