package patika.dev.libraryControlSystem.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import patika.dev.libraryControlSystem.business.concretes.AuthorManager;
import patika.dev.libraryControlSystem.business.concretes.PublisherManager;
import patika.dev.libraryControlSystem.core.config.modelMapper.ModelMapperManager;
import patika.dev.libraryControlSystem.dto.request.author.AuthorSaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.author.AuthorUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.request.publisher.PublisherSaveRequestDto;
import patika.dev.libraryControlSystem.dto.request.publisher.PublisherUpdateRequestDto;
import patika.dev.libraryControlSystem.dto.response.author.AuthorResponseDto;
import patika.dev.libraryControlSystem.dto.response.publisher.PublisherResponseDto;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/publishers")
public class PublisherController {
    private final PublisherManager publisherManager;
    private final ModelMapperManager modelMapper;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PublisherResponseDto save(@Valid @RequestBody PublisherSaveRequestDto publisherSaveRequestDto){
        return this.publisherManager.save(publisherSaveRequestDto);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PublisherResponseDto get(@PathVariable("id") int id){
        return this.publisherManager.getAsPublisherResponseDto(id);
    }
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public PublisherResponseDto update(@Valid @RequestBody PublisherUpdateRequestDto publisherUpdateRequestDto){
        return  this.publisherManager.update(publisherUpdateRequestDto);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("id") int id){
        this.publisherManager.delete(id);
        return "Silindi.";
    }
}
