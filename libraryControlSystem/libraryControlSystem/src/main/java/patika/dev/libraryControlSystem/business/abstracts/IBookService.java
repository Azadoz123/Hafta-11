package patika.dev.libraryControlSystem.business.abstracts;

import patika.dev.libraryControlSystem.dto.request.author.AuthorSaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.book.BookSaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.book.BookUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.response.author.AuthorResponseDto;
import patika.dev.libraryControlSystem.dto.response.book.BookResponseDto;
import patika.dev.libraryControlSystem.entitties.Author;
import patika.dev.libraryControlSystem.entitties.Book;

public interface IBookService {
    Book save(Book book);
    BookResponseDto save(BookSaveRequestDto bookSaveRequestDto);
    Book get(int id);
    BookResponseDto convertBookToBookDto(Book book);
    BookResponseDto getAsBookResponseDto(int id);
    Book update(Book book);
    BookResponseDto update(BookUpdateRequestDto bookUpdateRequestDto);
    boolean delete(int id);
}
