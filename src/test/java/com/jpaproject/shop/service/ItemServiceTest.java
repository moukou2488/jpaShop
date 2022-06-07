package com.jpaproject.shop.service;

import com.jpaproject.shop.domain.item.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Test
    public void 상품저장() throws Exception {
        //given
        Movie newMovie = Movie.builder()
                .actor("고마츠 나나")
                .director("이와이 슌지")
                .price(2000)
                .name("오늘")
                .stockQuantity(10)
                .build();


        //when
        Long saveItem = itemService.saveItem(newMovie);

        //then
        assertEquals(newMovie,itemService.findOne(saveItem));

    }

}