package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import view.Message;

public class User {

    private static final Logger logger = LoggerFactory.getLogger(User.class);

    private final Card[] list = new Card[5];

    private boolean isAce = false;


    public void add(int idx, Card card) {

        if (this.list[idx - 1] != null) {
            logger.warn("값이 이미 존재합니다");
            throw new IllegalArgumentException();
        }
        this.list[idx - 1] = card;
    }

    public Card remove(int idx) {

        if (this.list[idx - 1] == null) {
            logger.warn("{}번째 값은 null 입니다.", idx);
            throw new IllegalArgumentException();
        }
        Card card = this.list[idx - 1];
        this.list[idx - 1] = null;
        return card;
    }

    public void printCardSet() {
        logger.info("현제 가지고 있는 카드");
        for (int i = 0; i < this.list.length; i++) {
            Message.printCard(i + 1, this.list[i]);
        }
    }

    private void sort() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (list[i].getNumber() == list[j].getNumber()) { // 오름차
                    if (list[i].getSuit() < list[j].getSuit()) {
                        Card temp = list[i];
                        list[i] = list[j];
                        list[j] = temp;
                    }
                } else if (list[i].getNumber() < list[j].getNumber()) { // 오름차
                    Card temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }

    public Result checkRank(int idx) {

        sort();
        if (list[0].getNumber() == 1) {
            isAce = true;
        }

        Result[] result = new Result[12];

        result[0] = royalStraightFlush();
        result[1] = backStraightFlush();
        result[2] = straightFlush();
        result[3] = fourCard();
        result[4] = fullHouse();
        result[5] = flush();
        result[6] = mountain();
        result[7] = straight();
        result[8] = triple();
        result[9] = twoPair();
        result[10] = onePair();
        result[11] = noPair();

        for (int i = 0; i <= 10; i++) {
            if (result[i] != null) {
                Message.printRank(idx, result[i]);
                return result[i];
            }
        }
        Message.printRank(idx, result[11]);
        return result[11];
    }

    private Result royalStraightFlush() {
        // 카드 5장이 모두 무늬 같고 , 10 J Q K  ACE

        if (flush() != null && mountain() != null) {
            return new Result(31, 14, list[0].getSuit());
        }
        return null;
    }

    private Result backStraightFlush() {
        // 카드 5장이 모두 무늬 같고 , ACE , 2 3 4 5

        if (flush() != null && backStraight() != null) {
            return new Result(32, 14, list[0].getSuit());
        }
        return null;
    }

    private Result straightFlush() { //카드 5장 같은 무늬 , 숫자 연달아있음

        if (flush() != null && straight() != null) {
            if (isAce) {
                return new Result(33, 14, list[0].getSuit());
            }
            return new Result(33, list[4].getNumber(), list[4].getSuit());
        }
        return null;
    }

    private Result fourCard() { // 같은 숫자가 4장

        int num = list[0].getNumber();
        int num2 = list[1].getNumber();


        if (list[1].getNumber() == num && list[2].getNumber() == num && list[3].getNumber() == num) {
            if (isAce) {
                return new Result(34, 14, list[0].getSuit());
            } else {
                return new Result(34, list[3].getNumber(), list[3].getSuit());
            }
        }
        if (list[2].getNumber() == num2 && list[3].getNumber() == num2 && list[4].getNumber() == num2) {
            return new Result(34, list[4].getNumber(), list[4].getSuit());
        }
        return null;
    }

    private Result fullHouse() { // 같은 숫자 3개 , 같은 숫자 2개

        if (list[0].getNumber() == list[1].getNumber() && list[1].getNumber() == list[2].getNumber() &&
                list[3].getNumber() == list[4].getNumber()) {
            if (isAce) {
                return new Result(35, 14, list[0].getSuit());
            }
            return new Result(35, list[4].getNumber(), list[4].getSuit());
        }
        if ((list[0].getNumber() == list[1].getNumber()) && (list[2].getNumber() == list[3].getNumber()) &&
                (list[3].getNumber() == list[4].getNumber())) {
            if (isAce) {
                return new Result(35, 14, list[0].getSuit());
            }
            return new Result(35, list[4].getNumber(), list[4].getSuit());
        }
        return null;
    }

    private Result flush() { // 모두 같은 무늬 , Ace생각
        int suit = list[0].getSuit();

        for (int i = 1; i <= 4; i++) {
            if (list[i].getSuit() != suit) {
                return null;
            }
        }
        if (isAce) {
            return new Result(36, 14, list[0].getSuit());
        }
        return new Result(36, list[4].getNumber(), list[4].getSuit());
    }

    private Result mountain() {// 10 J Q K ACE
        if (list[0].getNumber() == 1 && list[1].getNumber() == 10 && list[2].getNumber() == 11 &&
                list[3].getNumber() == 12 && list[4].getNumber() == 13) {
            return new Result(37, 14, list[0].getSuit());
        }
        return null;
    }

    private Result backStraight() { // A 2 3 4 5
        if (list[0].getNumber() == 1 && list[1].getNumber() == 2 && list[2].getNumber() == 3 &&
                list[3].getNumber() == 4 && list[4].getNumber() == 5) {
            return new Result(38, 14, list[0].getSuit());
        }
        return null;
    }

    private Result straight() { // 숫자가 연달아 있는 패 , Ace생각
        int number = list[0].getNumber();

        if (isAce) {
            if (list[1].getNumber() == 10 && list[2].getNumber() == 11 && list[3].getNumber() == 12 &&
                    list[4].getNumber() == 13) {
                return new Result(39, 14, list[0].getSuit());
            }
            if (list[1].getNumber() == 2 && list[2].getNumber() == 3 && list[3].getNumber() == 4 &&
                    list[4].getNumber() == 5) {
                return new Result(39, 14, list[0].getSuit());
            }
            return null;
        }

        for (int i = 0; i < 5; i++) {
            if (number != list[i].getNumber()) {
                return null;
            }
            number++;
        }
        return new Result(39, list[4].getNumber(), list[4].getSuit());

    }

    private Result triple() { // 3장의 숫자가 같음


        if (list[0].getNumber() == list[1].getNumber() && list[1].getNumber() == list[2].getNumber()) {
            if (isAce) // Ace체크
            {
                return new Result(40, 14, list[4].getSuit());
            }
            return new Result(40, list[2].getNumber(), list[2].getSuit());
        } else if (list[1].getNumber() == list[2].getNumber() && list[2].getNumber() == list[3].getNumber()) {
            return new Result(40, list[3].getNumber(), list[3].getSuit());
        } else if (list[2].getNumber() == list[3].getNumber() && list[3].getNumber() == list[4].getNumber()) {
            return new Result(40, list[4].getNumber(), list[4].getSuit());
        }
        return null;
    }

    private Result twoPair() { // 페어가 2개
        int check = 0;
        for (int i = 0; i < 4; i++) {
            if (list[i].getNumber() == list[i + 1].getNumber()) {
                check++;
            }
            if (check == 2) {
                return new Result(41, list[i + 1].getNumber(), list[i + 1].getSuit());
            }
        }

        return null;
    }

    private Result onePair() { // 페어가 한개
        for (int i = 4; i >= 1; i--) {
            if (list[i].getNumber() == list[i - 1].getNumber()) {
                return new Result(42, list[i].getNumber(), list[i].getSuit());
            }
        }
        return null;
    }

    private Result noPair() {
        if (isAce) // Ace 존재함
        {
            return new Result(43, 14, list[0].getSuit());
        }
        return new Result(43, list[4].getNumber(), list[4].getSuit());
    }


}
