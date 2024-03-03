package ru.yalrb.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactDTO {
    private String phoneNumber;
    private String email;
    private String address;
}
