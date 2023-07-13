package com.sparta.carrotmarket.controller;

import com.sparta.carrotmarket.dto.ItemRequestDto;
import com.sparta.carrotmarket.dto.ItemResponseDto;
import com.sparta.carrotmarket.dto.MessageResponseDto;
import com.sparta.carrotmarket.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ItemController {

    private final ItemService itemService;

    //게시글 등록
    @PostMapping("/post")
    public ItemResponseDto createItem(@RequestBody ItemRequestDto itemRequestDto) {
        return itemService.createItem(itemRequestDto);
    }

    //게시글 전체조회
    @GetMapping("/post")
    public List<ItemResponseDto> getItems() {
        return itemService.getItems();
    }

    //게시글 선택조회
    @GetMapping("/post/{id}")
    public ItemResponseDto getItem(@PathVariable Long id) {
        return itemService.getItem(id);
    }

    //선택 게시글 수정
    @PutMapping("/post/{id}")
    public ItemResponseDto updateItem(@PathVariable Long id, @RequestBody ItemRequestDto itemRequestDto) {
        return itemService.updateItem(id, itemRequestDto);
    }
    //선택 게시글 삭제
    @DeleteMapping("/post/{id}")
    public MessageResponseDto deleteItem(@PathVariable Long id, @RequestBody ItemRequestDto itemRequestDto){
        return itemService.deleteItem(id,itemRequestDto);
    }
}

