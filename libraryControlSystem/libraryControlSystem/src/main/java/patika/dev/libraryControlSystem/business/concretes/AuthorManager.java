package patika.dev.libraryControlSystem.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import patika.dev.libraryControlSystem.business.abstracts.IAuthorService;
import patika.dev.libraryControlSystem.core.config.modelMapper.ModelMapperManager;
import patika.dev.libraryControlSystem.dao.AuthorRepo;
import patika.dev.libraryControlSystem.dto.request.author.AuthorSaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.author.AuthorUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.response.author.AuthorResponseDto;
import patika.dev.libraryControlSystem.entitties.Author;

@RequiredArgsConstructor
@Service
public class AuthorManager implements IAuthorService {

    private final AuthorRepo authorRepo;
    private final ModelMapperManager modelMapper;
    @Override
    public Author save(Author author) {
        return this.authorRepo.save(author);
    }

    @Override
    public AuthorResponseDto save(AuthorSaveRequestDto authorSaveRequestDto) {
        Author author = this.modelMapper.forRequest().map(authorSaveRequestDto, Author.class);
        Author savedAuthor = this.save(author);
        return this.convertAuthorToAuthorDto(savedAuthor);
    }

    @Override
    public Author get(int id) {
        return this.authorRepo.findById(id).orElseThrow(()->new RuntimeException("AuthorId(" +id + ") mevcut değil."));
    }

    @Override
    public AuthorResponseDto convertAuthorToAuthorDto(Author author) {
        AuthorResponseDto authorResponseDto = this.modelMapper.forResponse().map(author,AuthorResponseDto.class);;
        return authorResponseDto;
    }

    @Override
    public AuthorResponseDto getAsAuthorResponseDto(int id) {
        Author author = this.get(id);
        return convertAuthorToAuthorDto(author);
    }

    @Override
    public Author update(Author author) {
        return this.authorRepo.save(author);
    }

    @Override
    public AuthorResponseDto update(AuthorUpdateRequestDto authorUpdateRequestDto) {
        Author updateAuthor = this.modelMapper.forRequest().map(authorUpdateRequestDto, Author.class);
        this.update(updateAuthor);
        AuthorResponseDto authorResponseDto = this.modelMapper.forResponse().map(updateAuthor,AuthorResponseDto.class);
        return authorResponseDto;
    }

    @Override
    public boolean delete(int id) {
        this.authorRepo.delete(this.get(id));
        return true;
    }
}
