package org.example.totgether3.exception;

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
