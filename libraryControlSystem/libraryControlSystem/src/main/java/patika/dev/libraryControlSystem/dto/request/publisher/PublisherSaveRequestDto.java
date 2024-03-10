package patika.dev.libraryControlSystem.dto.request.publisher;

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
public class PublisherSaveRequestDto {

    @NotNull(message = "name boş olamaz")
    private String name;

    @NotNull(message = "establishmentYear boş olamaz")
    private LocalDate establishmentYear;

    @NotNull(message = "address boş olamaz")
    private String address;
}
