package com.sparta.carrotmarket.service;

import com.sparta.carrotmarket.dto.ItemRequestDto;
import com.sparta.carrotmarket.dto.ItemResponseDto;
import com.sparta.carrotmarket.entity.Item;
import com.sparta.carrotmarket.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemResponseDto createItem(ItemRequestDto itemRequestDto) {
        //RequestDto -> Item Entity
        Item item = new Item(itemRequestDto);
        //DB 저장
        Item saveItem = itemRepository.save(item);
        //Entity -> ResponseDto
        ItemResponseDto itemResponseDto = new ItemResponseDto(saveItem);
        return itemResponseDto;
    }
}
