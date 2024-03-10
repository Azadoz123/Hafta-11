package patika.dev.libraryControlSystem.business.abstracts;

import org.springframework.data.domain.Page;
import patika.dev.libraryControlSystem.dto.request.author.AuthorSaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.author.AuthorUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.response.author.AuthorResponseDto;
import patika.dev.libraryControlSystem.entitties.Author;

import java.util.List;

public interface IAuthorService {
    Author save(Author author);
    AuthorResponseDto save(AuthorSaveRequestDto authorSaveRequestDto);
    Author get(int id);
    AuthorResponseDto convertAuthorToAuthorDto(Author author);
    AuthorResponseDto getAsAuthorResponseDto(int id);
    Author update(Author author);
    AuthorResponseDto update(AuthorUpdateRequestDto authorUpdateRequestDto);
    boolean delete(int id);
}
