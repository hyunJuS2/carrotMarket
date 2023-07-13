package com.sparta.carrotmarket.repository;

import com.sparta.carrotmarket.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

//    List<Item> findAllByOrderByIdDesc();
}
