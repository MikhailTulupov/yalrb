package ru.yaltrip.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yaltrip.dto.AddObjectDTO;
import ru.yaltrip.dto.ObjectDTO;
import ru.yaltrip.mapper.ObjectMapper;
import ru.yaltrip.model.Object;
import ru.yaltrip.service.ObjectService;
import ru.yaltrip.utils.FileUtils;

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
