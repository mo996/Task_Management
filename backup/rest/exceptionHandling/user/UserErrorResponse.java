package com.daaeboul.taskmanagementsystem.rest.exceptionHandling.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserErrorResponse {
    private int stauts;
    private String message;
    private long timeStamp;


}
