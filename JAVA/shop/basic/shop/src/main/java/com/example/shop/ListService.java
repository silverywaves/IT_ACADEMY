package com.example.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListService {
    private final ItemRepository itemRepository;
    public void listItem(Model model){
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items", result);

        var a = new Item();
        System.out.println(a.toString());
    }
}
