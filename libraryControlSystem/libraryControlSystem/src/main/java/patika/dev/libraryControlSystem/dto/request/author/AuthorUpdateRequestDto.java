package patika.dev.libraryControlSystem.dto.request.author;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorUpdateRequestDto {

    @NotNull
    int id;

    @NotNull
    String name;

    @NotNull
    LocalDate birthDate;

    @NotNull
    String country;
}
