package ru.yaltrip.utils;

import org.springframework.web.multipart.MultipartFile;
import ru.yaltrip.model.Photo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This utility class provides the methods for stored files.
 */
public class FileUtils {
    private static final String PATH = "/home/mikhail/IdeaProjects/yaltrip/images";

    /**
     * Stored images in file storage.
     * @param files list of files
     * @return list of {@link Photo} files
     */
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
