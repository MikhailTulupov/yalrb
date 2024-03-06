package ru.yltrip.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yltrip.dto.AddObjectDTO;
import ru.yltrip.dto.ObjectDTO;
import ru.yltrip.mapper.ObjectMapper;
import ru.yltrip.model.Object;
import ru.yltrip.service.ObjectService;
import ru.yltrip.utils.FileUtils;

/**
 * This class present's controller.
 */
@RestController
@RequestMapping("/object")
public class ObjectController {
    final ObjectService objectService;

    public ObjectController(ObjectService objectService) {
        this.objectService = objectService;
    }

    @PostMapping(value = "/add",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectDTO> addObject(@ModelAttribute AddObjectDTO addObjectDTO) {

        ObjectMapper mapper = Mappers.getMapper(ObjectMapper.class);

        Object object = mapper.convertToEntity(addObjectDTO);

        object.getPhotos().addAll(FileUtils.storedImages(addObjectDTO.getPhotos()));

        object = objectService.save(object);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/object/" + object.getId());

        ObjectDTO objectDTO = Mappers.getMapper(ObjectMapper.class).convertToDTO(object);

        return ResponseEntity.ok().headers(headers)
                .contentType(MediaType.APPLICATION_JSON)
                .body(objectDTO);
    }
}
