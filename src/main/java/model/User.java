package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {

    private static final Logger logger = LoggerFactory.getLogger(User.class);

    List<Card> list = new ArrayList<>();


    public void add(Card card) {
        this.list.add(card);
    }

    public void remove(int idx) {
        this.list.remove(idx);
    }

    public void printCardSet() {
        Iterator<Card> iterator = list.iterator();

        for (int i = 0; i < list.size(); i++) {
            logger.info("{} 번째 카드 " + list.get(i), i + 1);
        }
    }

    public List<Card> getList() {
        return list;
    }

}
