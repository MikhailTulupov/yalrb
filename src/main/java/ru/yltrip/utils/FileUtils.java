package ru.yltrip.utils;

import org.springframework.web.multipart.MultipartFile;
import ru.yltrip.model.Photo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileUtils {
    private static final String PATH = "/home/mikhail/IdeaProjects/yltrip/images";

    public static List<Photo> storedImages(List<MultipartFile> files) {
        List<Photo> photos = new ArrayList<>();
        try {
            for (MultipartFile file : files) {
                Photo photo = Photo.builder()
                        .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .path(PATH + "/" + file.getOriginalFilename())
                        .loadedDateTime(new Date())
                        .description("photo")
                        .build();


                photos.add(photo);

                file.transferTo(new File(photo.getPath()));
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        return photos;
    }
}
