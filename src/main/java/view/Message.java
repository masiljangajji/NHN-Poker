package view;


import java.util.Arrays;
import model.Card;
import model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Message {

    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    J(11),
    Q(12),
    K(13),
    ACE_14(14),

    CLOVERR(21),
    HEART(22),
    DIA(23),
    SPADE(24),
    ROYAL_STRAIGHT_FLUSH(31),
    BACK_STRAIGHT_FLUSH(32),
    STRAIGHT_FLUSH(33),
    FOUR_CARD(34),
    FULL_HOUSE(35),
    FLUSH(36),
    MOUNTAIN(37),
    BACK_STRAIGHT(38),
    STRAIGHT(39),
    TRIPLE(40),
    TWO_PAIR(41),
    ONE_PAIR(42),
    NO_PAIR(43);

    Message(int value) {
        this.value = value;
    }

    private final int value;

    @Override
    public String toString() {
        return this.name() + " ";
    }


    public static void printRank(int idx, Result result) {
        final Logger logger = LoggerFactory.getLogger(Message.class);

        logger.info("{} 번째 Player " + Arrays.stream(values())
                .filter(value -> value.value == result.getRank())
                .findAny().get()
                + Arrays.stream(values())
                .filter(value -> value.value == result.getNumber())
                .findAny().get()
                + Arrays.stream(values())
                .filter(value -> value.value == result.getSuit())
                .findAny().get(), idx + 1);
    }

    public static void printCard(int idx, Card card) {
        final Logger logger = LoggerFactory.getLogger(Message.class);


        logger.info("{} 번째 카드 " + Arrays.stream(values())
                .filter(value -> value.value == card.getNumber())
                .findAny().get()
                +Arrays.stream(values())
                .filter(value -> value.value == card.getSuit())
                .findAny().get(), idx);

    }


}
