package patika.dev.libraryControlSystem.entitties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", columnDefinition = "serial")
    private int id;

    @NotNull
    @Column(name = "category_name")
    private String name;

    @NotNull
    @Column(name = "category_description")
    private String description;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,  mappedBy = "categoryList", cascade = CascadeType.REMOVE)
    private List<Book> bookList ;
}
