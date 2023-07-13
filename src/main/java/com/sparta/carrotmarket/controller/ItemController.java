package com.sparta.carrotmarket.controller;

import com.sparta.carrotmarket.dto.ItemRequestDto;
import com.sparta.carrotmarket.dto.ItemResponseDto;
import com.sparta.carrotmarket.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ItemController {

    private final ItemService itemService;
    @PostMapping("/item")
    public ItemResponseDto createItem(@RequestBody ItemRequestDto itemRequestDto){
        return itemService.createItem(itemRequestDto);
    }
}
