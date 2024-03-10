package patika.dev.libraryControlSystem.dto.request.bookCategory;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCategorySaveRequestDto {

    @NotNull
    private int bookId;

    @NotNull
    private int categoryId;
}
