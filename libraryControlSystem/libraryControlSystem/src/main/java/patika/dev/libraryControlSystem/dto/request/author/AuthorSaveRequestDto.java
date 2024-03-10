package patika.dev.libraryControlSystem.dto.request.author;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import patika.dev.libraryControlSystem.entitties.Book;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorSaveRequestDto {
    @NotNull
    String name;

    @NotNull
    LocalDate birthDate;

    @NotNull
    String country;

}
