package org.example.totgether3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralErrorResponse {

    private String reason;
    private LocalDateTime timestamp;
}
