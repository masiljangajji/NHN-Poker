package controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 게임진행에 필요한 사용자 입력을 받는 클래스.
 */
public class Input {

    /**
     * 사용자의 입력과 입력의 유효성을 검사하는 연산들의 집합.
     */
    private static final Logger logger = LoggerFactory.getLogger(Input.class);
    private static final Scanner sc = new Scanner(System.in);

    /**
     * 게임을 진행할 Player의 수를 입력 받음.
     *
     * @return 게임 진행할 Player 수 .
     */
    public static int playerNumber() {
        int num;
        while (true) {
            try {
                logger.info("Player의 수를 입력해 주세요 | 2~10 명 ");
                num = sc.nextInt();
                if (num < 2 || num > 10) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException | InputMismatchException e) {
                logger.warn("2명에서 10명까지 입력 가능합니다");
                sc.nextLine();
                continue;
            }
            logger.info("Player는 총 {}명 입니다.", num);
            return num;
        }
    }

    /**
     * 버릴 카드를 선택한 후 CardSet 으로 부터 다시 카드를 받음.
     *
     * @return 교환할 카드들의 index를 반환.
     */
    public static int[] swapCard() {
        int number = throwCardAmount();
        return getCard(number);
    }

    /**
     * 교환할 카드의 개수를 입력 받는다.
     *
     * @return 교환할 카드의 개수.
     */
    public static int throwCardAmount() {

        int number;
        while (true) {
            logger.info("\n교환할 카드 개수를 입력해 주세요");
            try {
                number = sc.nextInt();
                if (!(number >= 0 & number <= 5)) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException | InputMismatchException e) {
                logger.warn("개수 입력은 0~5 사이의 숫자만 가능합니다 !!");
                sc.nextLine();
                continue;
            }
            return number;
        }
    }

    /**
     * 교환할 카드의 index를 입력받음.
     *
     * @param number 교환할 카드의 개수.
     * @return 교환할 카드의 index.
     */
    public static int[] getCard(int number) {

        if (number == 0) {
            return new int[0];
        }
        logger.info("교환할 카드가 몇 번째 카드인지 입력해 주세요");
        int[] swapList = new int[number];

        for (int i = 0; i < number; i++) {
            logger.info("교환할 카드 : {}개 남았습니다", number - i);
            int swapIdx;
            while (true) {
                try {
                    swapIdx = sc.nextInt();
                    if (!(swapIdx >= 1 && swapIdx <= 5)) {
                        throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException | InputMismatchException e) {
                    logger.warn("입력은 1~5사이만 가능합니다!!\n다시 입력해 주세요");
                    sc.nextLine();
                    continue;
                }
                break;
            }
            swapList[i] = swapIdx;
        }
        return swapList;
    }


}
