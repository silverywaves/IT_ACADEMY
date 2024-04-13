package com.example.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    // 검사 or DB입출력 => 비즈니스로직 => 비즈니스로직을 담는 클래스 = Service

    private final ItemRepository itemRepository;

    public void saveItem(String title, Integer price){
        // DB 입출력 기능
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
        // DB 입출력시 repository interface 생성 -> 변수 등록 -> 사용
    }
}
