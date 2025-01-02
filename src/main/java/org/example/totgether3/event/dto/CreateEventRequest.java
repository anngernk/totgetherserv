package org.example.totgether3.event.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CreateEventRequest {

    private String patientName;
    private String date;
    private Integer room;
    private String reason;
}
