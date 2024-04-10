package com.example.shop;

import org.springframework.data.jpa.repository.JpaRepository;

// JapRepository<Entity명, id컬럼타입>
public interface ItemRepository extends JpaRepository<Item, Long> {

}
