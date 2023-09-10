package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {


    User user;
    Card card;

    @BeforeEach
    void setUser() {
        user = new User();
        card = new Card(1, 1);
    }

    @Test
    @DisplayName("User Add Exception Test 같은 index 중복 추가")
    void addTest() {
        user.add(1, new Card(1, 1));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                user.add(1, new Card(2, 2)));
    }

    @Test
    @DisplayName("User Remove Exception est 같은 index 중복 제거")
    void removeTest() {

        user.add(1, card);

        user.remove(1);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                user.remove(1));
    }

    @Test
    @DisplayName("User Remove Exception Test 값이 존재하지 않는 index  제거")
    void removeTest2() {

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                user.remove(1));
    }

}