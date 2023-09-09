import controller.Input;
import model.CardSet;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.CardSetService;
import service.UserService;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        CardSet cardSet = new CardSet();

        int num = Input.playerNumber();
        logger.info("Player는 총 {}명 입니다.", num);

        int order = (int) (Math.random() * (num) + 1); // 최대 num 최소 1

        logger.info("User는 {}번쨰 차례 입니다.", order);

        User[] users = new User[num];

        for (int i = 1; i <= num; i++) {
            CardSetService.giveCard(cardSet, users[i - 1]); // 전체 플레이어한테 5장씩 줌
        }

        users[order - 1].printCardSet(); // 유저가 가진 것 출력

        // 컴퓨터들 숫자 버림 , 이거 알고리즘 구현  페어 구현 되는지 -> 구현됐됐다면 높은 숫자 -> 높은 무늬

        int[] swapList = Input.swapCard(); // 카드 바꿀 꺼임

        CardSetService.userThrowCard(cardSet, users[order], swapList); // 여기다가 버려
        UserService.userReceiveCard(cardSet, users[order], swapList); // 새로 받아

        // 족보 구현해서 누가 이겼는지 체크



    }


}
