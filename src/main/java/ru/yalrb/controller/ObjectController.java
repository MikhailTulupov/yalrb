package ru.yalrb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.yalrb.dto.ObjectDTO;
import ru.yalrb.service.ObjectService;

@RestController
@RequestMapping("/object")
public class ObjectController {
    @Autowired
    ObjectService objectService;

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
    produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> addObject(@ModelAttribute ObjectDTO objectDTO
    ) {
//

//        Set<PhotoDTO> photos = new HashSet<>();
//        try {
//            for(MultipartFile file: files) {
//                byte[] photo = file.getBytes();
//                photos.add(PhotoDTO.builder().image(photo).build());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        objectDTO.setPhotos(photos);
        if (objectService.save(objectDTO).getName() != null) {
            return ResponseEntity.ok("объект создан");
        }
        return ResponseEntity.ok("bad request");
    }
}
