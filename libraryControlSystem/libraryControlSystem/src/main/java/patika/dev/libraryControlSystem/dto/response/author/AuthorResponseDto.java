package patika.dev.libraryControlSystem.dto.response.author;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponseDto {
    private Integer Id;
    private String name;
    private LocalDate birthDate;
    private String country;
}
