package ru.yalrb.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;
import ru.yalrb.dto.ContactDTO;
import ru.yalrb.dto.LocationDTO;
import ru.yalrb.dto.ObjectDTO;
import ru.yalrb.dto.PhotoDTO;
import ru.yalrb.model.*;
import ru.yalrb.model.Object;

import java.io.*;
import java.util.Objects;
import java.util.UUID;

@Mapper
public interface ObjectMapper {

    ObjectMapper INSTANCE = Mappers.getMapper(ObjectMapper.class);

    @Mappings({
//            @Mapping(target = "contacts",
//                    source = "object.contact",
//                    qualifiedByName = "mapContactToDTO"),
//            @Mapping(target = "location",
//                    source = "object.location",
//                    qualifiedByName = "mapLocationToDTO"),
            @Mapping(target = "photos",
            source = "object.photos",
            qualifiedByName = "mapPhotoToDTO"),
//            @Mapping(target = "type",
//            source = "object.type",
//            qualifiedByName = "mapTypeToDTO")
    })
    ObjectDTO convertToDTO(Object object);

    @Mappings({
//            @Mapping(target = "contact",
//                    source = "objectDTO.contacts",
//                    qualifiedByName = "mapContact"),
//            @Mapping(target = "location",
//                    source = "objectDTO.location",
//                    qualifiedByName = "mapLocation"),
            @Mapping(target = "photos",
            source = "objectDTO.photos",
            qualifiedByName = "mapPhoto"),
//            @Mapping(target = "id", source = "objectDTO.id", qualifiedByName = "mapId")
//            @Mapping(target = "type",
//            source = "objectDTO.type",
//            qualifiedByName = "mapType")
    })
    Object convertToEntity(ObjectDTO objectDTO);

//    @Named("mapId")
//    default UUID mapId(String id) {
//        return id.isEmpty() ? UUID.randomUUID() : UUID.fromString(id);
//    }

//    @Named("mapContact")
//    default Contact mapContact(ContactDTO contactDTO) {
//        return Contact.builder()
//                .email(contactDTO.getEmail())
//                .address(contactDTO.getAddress())
//                .phoneNumber(contactDTO.getPhoneNumber())
//                .build();
//    }
//
//    @Named("mapContactToDTO")
//    default ContactDTO mapContactToDTO(Contact contact) {
//        return ContactDTO.builder()
//                .email(contact.getEmail())
//                .phoneNumber(contact.getPhoneNumber())
//                .address(contact.getAddress())
//                .build();
//    }
//
//    @Named("mapLocation")
//    default Location mapLocation(LocationDTO locationDTO) {
//        return Location.builder().latitude(Float.parseFloat(locationDTO.getLatitude()))
//                .longitude(Float.parseFloat(locationDTO.getLongitude())).build();
//    }
//
//    @Named("mapLocationToDTO")
//    default LocationDTO mapLocationToDTO(Location location) {
//        return LocationDTO.builder().latitude(Float.toString(location.getLatitude()))
//                .longitude(Float.toString(location.getLongitude())).build();
//    }

    @Named("mapPhoto")
    default Photo mapPhoto(MultipartFile file) throws IOException {
        return Photo.builder().image(file.getBytes()).build();
    }

    @Named("mapPhotoToDTO")
    default MultipartFile mapPhotoToDTO(Photo photo) {
        return new MultipartFile() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public String getOriginalFilename() {
                return null;
            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public long getSize() {
                return 0;
            }

            @Override
            public byte[] getBytes() throws IOException {
                return photo.getImage();
            }

            @Override
            public InputStream getInputStream() throws IOException {
                return new ByteArrayInputStream(photo.getImage());
            }

            @Override
            public void transferTo(File dest) throws IOException, IllegalStateException {
                new FileOutputStream(dest).write(photo.getImage());
            }
        };
    }

//    @Named("mapType")
//    default Type mapType(String type) {
//        return Type.builder().name(type).build();
//    }
//
//    @Named("mapTypeToDTO")
//    default String mapTypeToDTO(Type type) {
//        return type.getName();
//    }
}
