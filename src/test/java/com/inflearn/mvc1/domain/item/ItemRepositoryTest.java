package com.inflearn.mvc1.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Item item = new Item("test", 2000, 2);

        // when
        Item saved = itemRepository.save(item);

        // then
        Item found = itemRepository.findById(saved.getId());
        assertThat(saved.getId()).isEqualTo(found.getId());
    }

    @Test
    void findAll() {
        // given
        Item item1 = itemRepository.save(new Item("test1", 2000, 2));
        Item item2 = itemRepository.save(new Item("test2", 2000, 2));

        // when
        List<Item> all = itemRepository.findAll();

        // then
        assertThat(all).size().isEqualTo(2);
        assertThat(all).contains(item1, item2);
    }
}