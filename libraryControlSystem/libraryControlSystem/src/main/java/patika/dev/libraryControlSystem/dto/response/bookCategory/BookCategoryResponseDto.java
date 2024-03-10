package patika.dev.libraryControlSystem.dto.response.bookCategory;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCategoryResponseDto {

    private int bookId;
    private int categoryId;
}
