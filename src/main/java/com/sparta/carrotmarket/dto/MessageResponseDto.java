package com.sparta.carrotmarket.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponseDto {
   private String message;

    public MessageResponseDto(String msg) {
        this.message = msg;
    }
}
