package com.example.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisRepositoryTests {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void createTest() {
        // 객체를 만들고
        Item item = Item.builder()
                .name("keyboard")
                .description("Very Expensive Keyboard")
                .price(100000)
                .build();

        // save를 호출
        itemRepository.save(item);
    }

//    @Test
//    public void readoneTest() {
//        Item item = itemRepository.findById(1L)
//                .orElseThrow();
//        System.out.println(item.getDescription());
//    }
//
//    @Test
//    public void updateTest() {
//        Item item  = itemRepository.findById(1L)
//                .orElseThrow();
//        item.setDescription("On Sale!!!");
//        item = itemRepository.save(item);
//        System.out.println(item.getDescription());
//    }
//
//    @Test
//    public void deleteTest() {
//        itemRepository.deleteById(1L);
//    }
}
