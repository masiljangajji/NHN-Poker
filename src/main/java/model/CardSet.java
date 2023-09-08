package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Card;

public class CardSet {


    private final List<Card> list= new ArrayList<>();

    // 52장의 카드 셋을 가지고 있는 list


    void giveCard(List<Card>list){ // 여기에 타입을 줄까
        Set<Integer>set = selectCard();

        for(Integer idx:set){
            list.add(this.list.get(idx)); // 플레이어 카드 셋에 추가
            this.list.remove(idx); // 카드 셋에서 삭제
        }

    } // 카드 뽑아서 플레이어들 한테 줄꺼임 , 이건 random하게 뽑을꺼고 , 뽑힌 idx는 remove해주면 됨

    private Set<Integer> selectCard(){

        Set<Integer> set = new HashSet<>();

        while(set.size()<5){
            int idx= (int) (Math.random() * (list.size()));
            set.add(idx);
        }

        return set;
    }






}
