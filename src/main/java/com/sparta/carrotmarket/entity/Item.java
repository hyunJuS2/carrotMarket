package com.sparta.carrotmarket.entity;

import com.sparta.carrotmarket.dto.ItemRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "price", nullable = false)
    private Integer price;
    @Column(name = "username", nullable = false)
    private String username;

    public Item(ItemRequestDto itemRequestDto) { // 게시글 DB에 등록시
        this.title = itemRequestDto.getTitle();
        this.content = itemRequestDto.getContent();
        this.price = itemRequestDto.getPrice();
        this.username = itemRequestDto.getUsername();
    }

    public void update(ItemRequestDto itemRequestDto) {
        this.title = itemRequestDto.getTitle();
        this.content = itemRequestDto.getContent();
        this.username = itemRequestDto.getUsername();
        this.price = itemRequestDto.getPrice();
    }
}
