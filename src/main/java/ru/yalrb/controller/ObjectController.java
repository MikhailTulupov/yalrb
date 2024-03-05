package ru.yalrb.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.yalrb.dto.AddObjectDTO;
import ru.yalrb.dto.ObjectDTO;
import ru.yalrb.mapper.ObjectMapper;
import ru.yalrb.model.Object;
import ru.yalrb.model.Photo;
import ru.yalrb.service.ObjectService;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/object")
public class ObjectController {
    @Autowired
    ObjectService objectService;
    private final String PATH = "/home/mikhail/IdeaProjects/yalrb/images";

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ObjectDTO> addObject(@ModelAttribute AddObjectDTO addObjectDTO,
                                               HttpServletResponse response) throws IOException {

        Object object = Mappers.getMapper(ObjectMapper.class).convertToEntity(addObjectDTO);
        List<MultipartFile> files = addObjectDTO.getPhotos();

        for (MultipartFile file : files) {
            Photo photo = Photo.builder()
                    .name(file.getOriginalFilename())
                    .type(file.getContentType())
                    .path(PATH + "/" + file.getOriginalFilename())
                    .build();

            object.getPhotos().add(photo);

            file.transferTo(new File(photo.getPath()));
        }

        object = objectService.save(object);

        response.setHeader("Location", "/object/" + object.getId());

        ObjectDTO objectDTO = Mappers.getMapper(ObjectMapper.class).convertToDTO(object);

        return ResponseEntity.created(URI.create("/object/" + object.getId()))
                .contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE)).body(objectDTO);
    }
}
