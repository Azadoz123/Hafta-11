package patika.dev.libraryControlSystem.dto.request.publisher;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherUpdateRequestDto {

    @NotNull
    private int id;

    @NotNull
    private String name;

    @NotNull
    private LocalDate establishmentYear;

    @NotNull
    private String address;
}
