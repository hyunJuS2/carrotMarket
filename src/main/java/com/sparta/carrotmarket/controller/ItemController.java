package com.sparta.carrotmarket.controller;

import com.sparta.carrotmarket.dto.ItemRequestDto;
import com.sparta.carrotmarket.dto.ItemResponseDto;
import com.sparta.carrotmarket.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ItemController {

    private final ItemService itemService;
    @PostMapping("/post")
    public ItemResponseDto createItem(@RequestBody ItemRequestDto itemRequestDto){
        return itemService.createItem(itemRequestDto);
    }
    @GetMapping("/post")
    public List<ItemResponseDto> getItems(){return itemService.getItems();}
}
