package org.example.totgether3.event.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventDto {

    private String patientName;
    private String date;
    private Integer room;
    private String reason;
}
