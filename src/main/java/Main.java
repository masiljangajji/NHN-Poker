import java.util.InputMismatchException;
import java.util.Scanner;
import model.CardSet;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {


        CardSet cardSet = new CardSet();

        User user1 = new User(); //
        User user2 = new User(); //

        cardSet.giveCard(user1); // 5개 받음
        cardSet.giveCard(user2); // 5개 받음

        logger.info(String.valueOf(user1.getList().size())); //5
        logger.info(String.valueOf(user2.getList().size())); //5


        user1.printCardSet();

        getInput();


        // 인당 5장씩 받아 -> 사용자에게 뭐 뽑혔는지 알려줘 -> 그 후에 맘에 안드는거 버려
    }

    public static void getInput() {

        Scanner sc = new Scanner(System.in);


        logger.info("교환할 카드 개수를 입력해 주세요");

        int number;

        while (true) {
            try {
                number = sc.nextInt();
                if (!(number >= 0 & number <= 5)) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException | InputMismatchException e) {
                logger.warn("개수 입력은 0~5 사이의 숫자만 가능합니다 !!\n다시 입력해 주세요");
                sc.nextLine();
                continue;
            }
            break;
        }

        logger.info("교환할 카드가 몇 번째 카드인지 입력해 주세요");

        int []changeIdx = new int[number];

        for (int i = 0; i < number; i++) {
            logger.info("교환할 카드 : {}개 남았습니다",number-i);

            while (true) {
                try {
                    changeIdx[i] = sc.nextInt();
                    if (!(changeIdx[i] >= 1 && changeIdx[i] <= 5)) {
                        throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException | InputMismatchException e) {
                    logger.warn("입력은 1~5사이만 가능합니다!!\n다시 입력해 주세요");
                    sc.nextLine();
                    continue;
                }
                break;
            }
        }


    }

}
