package patika.dev.libraryControlSystem.dto.request.category;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryUpdateRequestDto {

    @NotNull
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String description;
}
