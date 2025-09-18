package ru.practicum.shareit.item.repository.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.user.model.User;
import ru.practicum.shareit.user.repository.api.UserRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .name("Test User")
                .email("test@example.com")
                .build();
        user = userRepository.save(user);

        Item item1 = Item.builder()
                .name("Drill")
                .description("Description of the drill")
                .available(true)
                .owner(user)
                .build();
        Item item2 = Item.builder()
                .name("Hammer")
                .description("Description of the hammer")
                .available(true)
                .owner(user)
                .build();

        itemRepository.save(item1);
        itemRepository.save(item2);
    }

    @AfterEach
    void shutDownClean() {
        itemRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    void findByOwnerId_returnsItems() {
        List<Item> foundItems = itemRepository.getItemsByOwnerId(user.getId());

        assertThat(foundItems).hasSize(2);
        assertThat(foundItems.get(0).getOwner()).isEqualTo(user);
        assertThat(foundItems.get(1).getOwner()).isEqualTo(user);
    }

    @Test
    void searchByKeyword_returnsMatchingItems() {
        List<Item> foundItems = itemRepository.search("Drill");

        assertThat(foundItems).hasSize(1);
        assertThat(foundItems.get(0).getName()).containsIgnoringCase("Drill");
    }
}