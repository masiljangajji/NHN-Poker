package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {


    User user;
    Card card;

    @BeforeEach
    void setUser(){
        user = new User();
        card = new Card("1","1");
    }

    @Test
    @DisplayName("User Add preCondition Test 배열 범위 초과")
    void addTest1(){
        Assertions.assertThrows(IllegalArgumentException.class,()->
                user.add(0,card));

        Assertions.assertThrows(IllegalArgumentException.class,()->
                user.add(6,card));
    }

    @Test
    @DisplayName("User Add Exception Test 값은 index 중복 추가")
    void addTest2() {
        user.add(1,new Card("1","1"));
        Assertions.assertThrows(IllegalArgumentException.class,()->
                user.add(1,new Card("2","2")));
    }

//    @Test
//    @DisplayName("User Add PostCondition Test")
//    void addTest3(){
//        user.add(1,card);
//        user.add(2,card);
//        user.add(3,card);
//    }


    @Test
    @DisplayName("User Remove PreCondition Test 배열 범위 초과")
    void removeTest() {
        Assertions.assertThrows(IllegalArgumentException.class,()->
                user.add(0,card));

        Assertions.assertThrows(IllegalArgumentException.class,()->
                user.add(6,card));
    }

    @Test
    @DisplayName("User Remove PreCondition Test 같은 index 중복 제거")
    void removeTest2() {

        user.add(1,card);

        Assertions.assertThrows(IllegalArgumentException.class,()->
                user.add(1,card));

        Assertions.assertThrows(IllegalArgumentException.class,()->
                user.add(1,card));
    }

}