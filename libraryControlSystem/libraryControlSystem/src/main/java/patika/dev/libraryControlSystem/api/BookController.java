package patika.dev.libraryControlSystem.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import patika.dev.libraryControlSystem.business.concretes.AuthorManager;
import patika.dev.libraryControlSystem.business.concretes.BookManager;
import patika.dev.libraryControlSystem.core.config.modelMapper.ModelMapperManager;
import patika.dev.libraryControlSystem.dto.request.author.AuthorSaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.author.AuthorUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.request.book.BookSaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.book.BookUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.response.author.AuthorResponseDto;
import patika.dev.libraryControlSystem.dto.response.book.BookResponseDto;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/books")
public class BookController {
    private final BookManager bookManager;
    private final ModelMapperManager modelMapper;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponseDto save(@Valid @RequestBody BookSaveRequestDto bookSaveRequestDto){
        return this.bookManager.save(bookSaveRequestDto);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponseDto get(@PathVariable("id") int id){
        return this.bookManager.getAsBookResponseDto(id);
    }
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public BookResponseDto update(@Valid @RequestBody BookUpdateRequestDto bookUpdateRequestDto){
        return  this.bookManager.update(bookUpdateRequestDto);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("id") int id){
        this.bookManager.delete(id);
        return "Silindi.";
    }
}
