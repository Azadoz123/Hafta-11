package patika.dev.libraryControlSystem.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import patika.dev.libraryControlSystem.business.concretes.AuthorManager;
import patika.dev.libraryControlSystem.core.config.modelMapper.ModelMapperManager;
import patika.dev.libraryControlSystem.dto.request.author.AuthorSaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.author.AuthorUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.response.author.AuthorResponseDto;
import patika.dev.libraryControlSystem.entitties.Author;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/authors")
public class AuthorController {

    private final AuthorManager authorManager;
    private final ModelMapperManager modelMapper;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorResponseDto save(@Valid @RequestBody AuthorSaveRequestDto authorSaveRequestDto){
        return this.authorManager.save(authorSaveRequestDto);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorResponseDto get(@PathVariable("id") int id){
        return this.authorManager.getAsAuthorResponseDto(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("id") int id){
        this.authorManager.delete(id);
        return "Silindi.";
    }
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public AuthorResponseDto update(@Valid @RequestBody AuthorUpdateRequestDto authorUpdateRequestDto){
        return  this.authorManager.update(authorUpdateRequestDto);
    }
}
