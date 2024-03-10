package patika.dev.libraryControlSystem.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import patika.dev.libraryControlSystem.business.concretes.BookBorrowingManager;
import patika.dev.libraryControlSystem.business.concretes.BookManager;
import patika.dev.libraryControlSystem.core.config.modelMapper.ModelMapperManager;
import patika.dev.libraryControlSystem.dto.request.author.AuthorUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.request.book.BookSaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.bookBorrowing.BookBorrowingSaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.bookBorrowing.BookBorrowingUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.response.author.AuthorResponseDto;
import patika.dev.libraryControlSystem.dto.response.book.BookResponseDto;
import patika.dev.libraryControlSystem.dto.response.bookBorrowing.BookBorrowingResponseDto;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/bookBorrowings")
public class BookBorrowingController {
    private final BookBorrowingManager bookBorrowingManager;
    private final ModelMapperManager modelMapper;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@Valid @RequestBody BookBorrowingSaveRequestDto bookBorrowingSaveRequestDto){
        return this.bookBorrowingManager.save(bookBorrowingSaveRequestDto);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookBorrowingResponseDto get(@PathVariable("id") int id){
        return this.bookBorrowingManager.getAsBookBorrowingResponseDto(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("id") int id){
        this.bookBorrowingManager.delete(id);
        return "Silindi.";
    }
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public BookBorrowingResponseDto update(@Valid @RequestBody BookBorrowingUpdateRequestDto bookBorrowingUpdateRequestDto){
        return  this.bookBorrowingManager.update(bookBorrowingUpdateRequestDto);
    }
}
