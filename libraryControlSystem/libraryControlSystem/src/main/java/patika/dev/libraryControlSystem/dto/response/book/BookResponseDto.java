package patika.dev.libraryControlSystem.dto.response.book;

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
public class BookResponseDto {
    private int id;
    private String name;
    private LocalDate publicationYear;
    int stock;
    private int authorId;
    private int publisherId;
}
