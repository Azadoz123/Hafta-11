package patika.dev.libraryControlSystem.entitties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id", columnDefinition = "serial")
    private int id;

    @NotNull
    @Column(name = "publisher_name")
    private String name;

    @NotNull
    @Column(name = "publisher_establishment_year")
    private LocalDate establishmentYear;

    @NotNull
    @Column(name = "publisher_address")
    private String address;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.REMOVE)
    private List<Book> bookList;
}
