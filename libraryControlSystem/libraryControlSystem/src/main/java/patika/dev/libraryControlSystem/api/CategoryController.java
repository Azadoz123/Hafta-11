package patika.dev.libraryControlSystem.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import patika.dev.libraryControlSystem.business.concretes.BookManager;
import patika.dev.libraryControlSystem.business.concretes.CategoryManager;
import patika.dev.libraryControlSystem.core.config.modelMapper.ModelMapperManager;
import patika.dev.libraryControlSystem.dto.request.book.BookSaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.book.BookUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.request.category.CategorySaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.category.CategoryUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.response.book.BookResponseDto;
import patika.dev.libraryControlSystem.dto.response.category.CategoryResponseDto;
import patika.dev.libraryControlSystem.dto.response.publisher.PublisherResponseDto;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
    private final CategoryManager categoryManager;
    private final ModelMapperManager modelMapper;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponseDto save(@Valid @RequestBody CategorySaveRequestDto categorySaveRequestDto){
        return this.categoryManager.save(categorySaveRequestDto);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponseDto get(@PathVariable("id") int id){
        return this.categoryManager.getAsCategoryResponseDto(id);
    }
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponseDto update(@Valid @RequestBody CategoryUpdateRequestDto categoryUpdateRequestDto){
        return  this.categoryManager.update(categoryUpdateRequestDto);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("id") int id){
        return this.categoryManager.delete(id);
    }
}
