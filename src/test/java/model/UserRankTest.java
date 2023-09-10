package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.ResultService;

class UserRankTest {

    User user;
    User user2;

    @BeforeEach
    void setUser() {
        user = new User();
        user2 = new User();
    }

    @Test
    @DisplayName("Royal Straight Flush Test 정상 작동")
    void royalStraightFlushTest() {

        user.add(1, new Card(10, 21));
        user.add(2, new Card(11, 21));
        user.add(3, new Card(12, 21));
        user.add(4, new Card(13, 21));
        user.add(5, new Card(1, 21));

        Assertions.assertEquals(user.checkRank(0).getRank(), 31);
        Assertions.assertEquals(user.checkRank(0).getSuit(), 21);
        Assertions.assertEquals(user.checkRank(0).getNumber(), 14);
    }

    @Test
    @DisplayName("Back Straight Flush Test 정상 작동")
    void backStraightFlushTest() {

        user.add(1, new Card(2, 22));
        user.add(2, new Card(5, 22));
        user.add(3, new Card(1, 22));
        user.add(4, new Card(4, 22));
        user.add(5, new Card(3, 22));

        Assertions.assertEquals(user.checkRank(0).getRank(), 32);
        Assertions.assertEquals(user.checkRank(0).getSuit(), 22);
        Assertions.assertEquals(user.checkRank(0).getNumber(), 14);
    }

    @Test
    @DisplayName("Straight Flush Test 정상 작동")
    void straightFlushTest() {

        user.add(1, new Card(2, 22));
        user.add(2, new Card(3, 22));
        user.add(3, new Card(4, 22));
        user.add(4, new Card(5, 22));
        user.add(5, new Card(6, 22));

        Assertions.assertEquals(user.checkRank(0).getRank(), 33);
        Assertions.assertEquals(user.checkRank(0).getSuit(), 22);
        Assertions.assertEquals(user.checkRank(0).getNumber(), 6);
    }

    @Test
    @DisplayName("Four Card Test 정상 작동")
    void fourCardTest() {

        user.add(1, new Card(4, 21));
        user.add(2, new Card(5, 22));
        user.add(3, new Card(4, 23));
        user.add(4, new Card(4, 24));
        user.add(5, new Card(4, 21));

        Assertions.assertEquals(user.checkRank(0).getRank(), 34);
        Assertions.assertEquals(user.checkRank(0).getSuit(), 24);
        Assertions.assertEquals(user.checkRank(0).getNumber(), 4);
    }

    @Test
    @DisplayName("Full House Test 정상 작동")
    void fullHouseTest() {

        user.add(1, new Card(11, 21));
        user.add(2, new Card(5, 22));
        user.add(3, new Card(11, 23));
        user.add(4, new Card(5, 24));
        user.add(5, new Card(11, 21));

        Assertions.assertEquals(user.checkRank(0).getRank(), 35);
        Assertions.assertEquals(user.checkRank(0).getSuit(), 23);
        Assertions.assertEquals(user.checkRank(0).getNumber(), 11);
    }

    @Test
    @DisplayName("Flush Test 정상 작동 Ace 없는 경우")
    void flushTest() {

        user.add(1, new Card(2, 24));
        user.add(2, new Card(5, 24));
        user.add(3, new Card(6, 24));
        user.add(4, new Card(5, 24));
        user.add(5, new Card(13, 24));

        Assertions.assertEquals(user.checkRank(0).getRank(), 36);
        Assertions.assertEquals(user.checkRank(0).getSuit(), 24);
        Assertions.assertEquals(user.checkRank(0).getNumber(), 13);
    }

    @Test
    @DisplayName("Flush Test 정상 작동 Ace 있는 경우")
    void flushTest2() {

        user.add(1, new Card(1, 24));
        user.add(2, new Card(5, 24));
        user.add(3, new Card(6, 24));
        user.add(4, new Card(5, 24));
        user.add(5, new Card(13, 24));

        Assertions.assertEquals(user.checkRank(0).getRank(), 36);
        Assertions.assertEquals(user.checkRank(0).getSuit(), 24);
        Assertions.assertEquals(user.checkRank(0).getNumber(), 14);
    }


    @Test
    @DisplayName("Mountain Test 정상 작동 경우")
    void mountainTest() {

        user.add(1, new Card(10, 23));
        user.add(2, new Card(11, 21));
        user.add(3, new Card(12, 22));
        user.add(4, new Card(1, 21));
        user.add(5, new Card(13, 22));

        Assertions.assertEquals(user.checkRank(0).getRank(), 37);
        Assertions.assertEquals(user.checkRank(0).getSuit(), 21);
        Assertions.assertEquals(user.checkRank(0).getNumber(), 14);
    }


    @Test
    @DisplayName("Back Straight Test 정상 작동")
    void backStraightTest() {

        user.add(1, new Card(1, 23));
        user.add(2, new Card(5, 21));
        user.add(3, new Card(4, 22));
        user.add(4, new Card(3, 21));
        user.add(5, new Card(2, 22));

        Assertions.assertEquals(user.checkRank(0).getRank(), 38);
        Assertions.assertEquals(user.checkRank(0).getSuit(), 23);
        Assertions.assertEquals(user.checkRank(0).getNumber(), 14);
    }

    @Test
    @DisplayName("Straight Test 정상 작동")
    void straightTest() {

        user.add(1, new Card(5, 21));
        user.add(2, new Card(6, 22));
        user.add(3, new Card(8, 23));
        user.add(4, new Card(7, 21));
        user.add(5, new Card(9, 23));

        Assertions.assertEquals(user.checkRank(0).getRank(), 39);
        Assertions.assertEquals(user.checkRank(0).getSuit(), 23);
        Assertions.assertEquals(user.checkRank(0).getNumber(), 9);
    }

    @Test
    @DisplayName("Triple Test 정상 작동 Ace 있는 경우")
    void tripleTest() {

        user.add(1, new Card(1, 21));
        user.add(2, new Card(1, 22));
        user.add(3, new Card(1, 23));
        user.add(4, new Card(12, 21));
        user.add(5, new Card(13, 23));

        Assertions.assertEquals(user.checkRank(0).getRank(), 40);
        Assertions.assertEquals(user.checkRank(0).getSuit(), 23);
        Assertions.assertEquals(user.checkRank(0).getNumber(), 14);
    }

    @Test
    @DisplayName("Triple Test 정상 작동 Ace 없는 경우")
    void tripleTest2() {

        user.add(1, new Card(5, 21));
        user.add(2, new Card(5, 21));
        user.add(3, new Card(5, 22));
        user.add(4, new Card(12, 21));
        user.add(5, new Card(13, 23));

        Assertions.assertEquals(user.checkRank(0).getRank(), 40);
        Assertions.assertEquals(user.checkRank(0).getSuit(), 22);
        Assertions.assertEquals(user.checkRank(0).getNumber(), 5);
    }

    @Test
    @DisplayName("TwoPair Test 정상 작동 Ace Piar 있는 경우")
    void twoPairTest() {

        user.add(1, new Card(1, 21));
        user.add(2, new Card(1, 21));
        user.add(3, new Card(10, 22));
        user.add(4, new Card(10, 23));
        user.add(5, new Card(13, 23));

        Assertions.assertEquals(user.checkRank(0).getRank(), 41);
        Assertions.assertEquals(user.checkRank(0).getSuit(), 21);
        Assertions.assertEquals(user.checkRank(0).getNumber(), 14);
    }

    @Test
    @DisplayName("TwoPair Test 정상 작동 Ace Piar 없는 경우")
    void twoPairTest2() {

        user.add(1, new Card(8, 21));
        user.add(2, new Card(4, 21));
        user.add(3, new Card(8, 22));
        user.add(4, new Card(2, 23));
        user.add(5, new Card(2, 22));

        Assertions.assertEquals(user.checkRank(0).getRank(), 41);
        Assertions.assertEquals(user.checkRank(0).getSuit(), 22);
        Assertions.assertEquals(user.checkRank(0).getNumber(), 8);
    }

    @Test
    @DisplayName("OnePair Test 정상 작동 Ace Piar 없는 경우")
    void onePairTest() {

        user.add(1, new Card(10, 23));
        user.add(2, new Card(10, 22));
        user.add(3, new Card(11, 21));
        user.add(4, new Card(4, 21));
        user.add(5, new Card(5, 24));

        Assertions.assertEquals(user.checkRank(0).getRank(), 42);
        Assertions.assertEquals(user.checkRank(0).getSuit(), 23);
        Assertions.assertEquals(user.checkRank(0).getNumber(), 10);
    }

    @Test
    @DisplayName("OnePair Test 정상 작동 Ace Piar 있는 경우")
    void onePairTest2() {

        user.add(1, new Card(10, 23));
        user.add(2, new Card(1, 22));
        user.add(3, new Card(1, 21));
        user.add(4, new Card(4, 21));
        user.add(5, new Card(5, 24));

        Assertions.assertEquals(user.checkRank(0).getRank(), 42);
        Assertions.assertEquals(user.checkRank(0).getSuit(), 22);
        Assertions.assertEquals(user.checkRank(0).getNumber(), 14);
    }

    @Test
    @DisplayName("No Pair Test 정상 작동 Ace 있는 경우")
    void noPairTest() {

        user.add(1, new Card(1, 23));
        user.add(2, new Card(5, 22));
        user.add(3, new Card(11, 21));
        user.add(4, new Card(7, 21));
        user.add(5, new Card(3, 24));

        Assertions.assertEquals(user.checkRank(0).getRank(), 43);
        Assertions.assertEquals(user.checkRank(0).getSuit(), 23);
        Assertions.assertEquals(user.checkRank(0).getNumber(), 14);
    }

    @Test
    @DisplayName("No Pair Test 정상 작동 Ace 없는 경우")
    void noPairTest2() {

        user.add(1, new Card(6, 23));
        user.add(2, new Card(5, 22));
        user.add(3, new Card(13, 21));
        user.add(4, new Card(7, 21));
        user.add(5, new Card(3, 24));

        Assertions.assertEquals(user.checkRank(0).getRank(), 43);
        Assertions.assertEquals(user.checkRank(0).getSuit(), 21);
        Assertions.assertEquals(user.checkRank(0).getNumber(), 13);
    }

    @Test
    @DisplayName("GetWinner Test 정상 작동 족보 다른 경우")
    void getWinnerTest() {

        User[] users= new User[2];

        user.add(1, new Card(10, 21));
        user.add(2, new Card(11, 21));
        user.add(3, new Card(12, 21));
        user.add(4, new Card(13, 21));
        user.add(5, new Card(1, 21));

        users[0]=user;
        User user2 = new User();
        user2.add(1, new Card(6, 23));
        user2.add(2, new Card(5, 22));
        user2.add(3, new Card(13, 21));
        user2.add(4, new Card(7, 21));
        user2.add(5, new Card(3, 24));
        users[1]=user2;

        Assertions.assertEquals(ResultService.getWinner(users),1);

    }

    @Test
    @DisplayName("GetWinner Test 정상 작동 족보 같은 경우")
    void getWinnerTest2() {

        User[] users= new User[2];

        user.add(1, new Card(10, 23));
        user.add(2, new Card(10, 22));
        user.add(3, new Card(11, 21));
        user.add(4, new Card(4, 21));
        user.add(5, new Card(5, 24));

        users[0]=user;

        user2.add(1, new Card(12, 21));
        user2.add(2, new Card(12, 22));
        user2.add(3, new Card(11, 21));
        user2.add(4, new Card(4, 21));
        user2.add(5, new Card(5, 24));
        users[1]=user2;

        Assertions.assertEquals(ResultService.getWinner(users),2);
    }

    @Test
    @DisplayName("GetWinner Test 정상 작동 족보,숫자 같은 경우")
    void getWinnerTest3() {

        User[] users= new User[2];

        user.add(1, new Card(10, 23));
        user.add(2, new Card(10, 22));
        user.add(3, new Card(11, 21));
        user.add(4, new Card(4, 21));
        user.add(5, new Card(5, 24));

        users[0]=user;
        user2.add(1, new Card(10, 24));
        user2.add(2, new Card(10, 22));
        user2.add(3, new Card(11, 21));
        user2.add(4, new Card(4, 21));
        user2.add(5, new Card(5, 24));
        users[1]=user2;

        Assertions.assertEquals(ResultService.getWinner(users),2);
    }

    @Test
    @DisplayName("GetWinner Test 정상 작동 족보,숫자,무늬 같은 경우")
    void getWinnerTest4() {

        User[] users= new User[2];

        user.add(1, new Card(10, 23));
        user.add(2, new Card(10, 22));
        user.add(3, new Card(11, 21));
        user.add(4, new Card(4, 21));
        user.add(5, new Card(5, 24));

        users[0]=user;
        user2.add(1, new Card(10, 23));
        user2.add(2, new Card(10, 22));
        user2.add(3, new Card(11, 21));
        user2.add(4, new Card(4, 21));
        user2.add(5, new Card(5, 24));
        users[1]=user2;

        Assertions.assertEquals(ResultService.getWinner(users),1);
    }



}
