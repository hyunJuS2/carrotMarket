package com.sparta.carrotmarket.service;

import com.sparta.carrotmarket.dto.ItemRequestDto;
import com.sparta.carrotmarket.dto.ItemResponseDto;
import com.sparta.carrotmarket.dto.MessageResponseDto;
import com.sparta.carrotmarket.entity.Item;
import com.sparta.carrotmarket.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    //게시글 등록
    public ItemResponseDto createItem(ItemRequestDto itemRequestDto) {
        //RequestDto -> Item Entity
        Item item = new Item(itemRequestDto);
        //DB 저장
        Item saveItem = itemRepository.save(item);
        //Entity -> ResponseDto
        ItemResponseDto itemResponseDto = new ItemResponseDto(saveItem);
        return itemResponseDto;
    }

    //게시글 전체조회
    public List<ItemResponseDto> getItems() {
        return itemRepository.findAll().stream().map(ItemResponseDto::new).toList();
    }


    public ItemResponseDto getItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시글은 존재하지 않습니다"));
        ItemResponseDto itemResponseDto = new ItemResponseDto(item);
        return itemResponseDto;
    }

    @Transactional
    public ItemResponseDto updateItem(Long id, ItemRequestDto itemRequestDto) {
        // ID와 일치하는 게시글 조회
        Item item = findItem(id);
        // 게시글의 작성자와 현재 사용자가 동일한지
        if(item.getUsername().equals(itemRequestDto.getUsername())){
            // 게시글 수정
            item.update(itemRequestDto);
            ItemResponseDto itemResponseDto = new ItemResponseDto(item);
            return itemResponseDto;

        } else {throw new IllegalArgumentException("접근이 거부되었습니다.");}
    }

    public MessageResponseDto deleteItem(Long id, ItemRequestDto itemRequestDto) {
        Item item = findItem(id);
        // 게시글의 작성자와 현재 사용자가 동일한지
        if(item.getUsername().equals(itemRequestDto.getUsername())){
            // 게시글 수정
        itemRepository.delete(item);
        return new MessageResponseDto("삭제가 완료되었습니다.");
        } else {throw new IllegalArgumentException("접근이 거부되었습니다.");}
    }

    private Item findItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        return item;
    }
}
