package com.sparta.carrotmarket.dto;

import lombok.Getter;

@Getter
public class ItemRequestDto {
    private String title;
    private String content;
    private Integer price;
    private String username;
}
