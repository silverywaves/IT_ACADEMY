package com.example.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateService {

    private final ItemRepository itemRepository;

    public void updateItem(Long id, String title, Integer price){
        Item item = new Item();
//        item.setId(유저가 수정하고싶은 글번호);
        item.setId(id);
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
    }
}
