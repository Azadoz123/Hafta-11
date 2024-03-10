package patika.dev.libraryControlSystem.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import patika.dev.libraryControlSystem.business.concretes.AuthorManager;
import patika.dev.libraryControlSystem.business.concretes.BookCategoryManager;
import patika.dev.libraryControlSystem.core.config.modelMapper.ModelMapperManager;
import patika.dev.libraryControlSystem.dto.request.author.AuthorSaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.bookCategory.BookCategoryDeleteRequestDto;
import patika.dev.libraryControlSystem.dto.request.bookCategory.BookCategorySaveRequestDto;
import patika.dev.libraryControlSystem.dto.response.author.AuthorResponseDto;
import patika.dev.libraryControlSystem.dto.response.bookCategory.BookCategoryResponseDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/bookCategories")
public class BookCategoryController {
    private final BookCategoryManager bookCategoryManager;
    private final ModelMapperManager modelMapper;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public BookCategoryResponseDto save(@Valid @RequestBody BookCategorySaveRequestDto bookCategorySaveRequestDto){
        return this.bookCategoryManager.save(bookCategorySaveRequestDto);
    }
    @GetMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public List<BookCategoryResponseDto> get(@PathVariable("bookId") int bookId){
        return this.bookCategoryManager.get(bookId);
    }
    @DeleteMapping()
    @ResponseStatus(HttpStatus.OK)
    public String delete(@Valid @RequestBody BookCategoryDeleteRequestDto bookCategoryDeleteRequestDto){
        this.bookCategoryManager.delete(bookCategoryDeleteRequestDto);
        return "silindi";
    }
}
