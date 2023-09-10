# 🎮 NHN 과제 Poker



# 고려 사항

- MVC 패턴을 기반으로한 패키지 구조 설정
- 기능들에 대해 Junit5을 사용한 Test Code 작성
- Check Style, Code Style 적용
- Logging 설정

---


# 게임 설명

0. 포커 게임을 시작한다 .


1. 무작위로 52장의 포커 카드 셋을 만든다.


2. 사용자에게 Player의 수를 입력 받는다.


3. 각 사용자는 무작위로 순서를 배정받는다.


4. 카드 5장을 받고 확인한다.


5. 버릴 카드를 선택한 후 버린다. (사용자만)


6. 버린 카드 수 만큼 카드를 다시 뽑는다. (사용자만)


7. 전체 Player가 가진 카드를 비교해 승자를 출력한다. 

---

## 🎯 NHN 포커 룰 

- 포커의 족보는 다음을 따른다 [포커족보](https://lunavenia.tistory.com/171)
- 하지만 이 게임에서는 백스트레이트의 경우에도 기존의 무늬 순서를 따른다.
- ### 숫자 우선순위 2 - 10 < J < Q < K < A
- ### 무늬 우선순위  ♣ < ♥  < ♦ < ♠

- ### 승자 판별 방법은 다음과 같다 .
  - 1 . 족보 우선순위가 높은 경우 
  - 2 . 숫자 우선순위가 높은 경우 
  - 3 . 무늬 우선순위가 높은 경우 
  - 4 . 만약 우선순위가 완벽히 동일하다면 먼저 카드를 받은 사람이 이긴다.

---

# 입력

### Player 수 입력

```
Player의 수를 입력해 주세요 | 2~10 명 
5
```

### 교환할 카드 개수 입력

```
교환할 카드 개수를 입력해 주세요
3
```

### 카드 교환 입력

```
교환할 카드가 몇 번째 카드인지 입력해 주세요
교환할 카드 : 3개 남았습니다
1
교환할 카드 : 2개 남았습니다
2
교환할 카드 : 1개 남았습니다
3
```

---

# 출력

### 게임 시작 문구

```
NHN - Poker 게임을 시작합니다
```

### 사용자의 카드 

```
현제 가지고 있는 카드
1 번째 카드 TEN CLOVERR 
2 번째 카드 THREE CLOVERR 
3 번째 카드 THREE DIA 
4 번째 카드 EIGHT CLOVERR 
5 번째 카드 FIVE DIA 
```

### Player 결과 출력  (우선순위 높은 순으로 족보,숫자,무늬)

```
1 번째 Player ONE_PAIR ACE_14 DIA 
2 번째 Player NO_PAIR ACE_14 SPADE 
3 번째 Player ONE_PAIR TEN SPADE 
4 번째 Player NO_PAIR ACE_14 CLOVERR 
5 번째 Player TWO_PAIR SIX DIA 
```


# 실행 결과 예시

### 정상 작동 결과

```
NHN - Poker 게임을 시작합니다

Player의 수를 입력해 주세요 | 2~10 명 
5
Player는 총 5명 입니다.
User는 5번쨰 Player 입니다.

현제 가지고 있는 카드
1 번째 카드 TEN CLOVERR 
2 번째 카드 THREE CLOVERR 
3 번째 카드 THREE DIA 
4 번째 카드 EIGHT CLOVERR 
5 번째 카드 FIVE DIA 


교환할 카드 개수를 입력해 주세요
5
교환할 카드가 몇 번째 카드인지 입력해 주세요
교환할 카드 : 5개 남았습니다
1
교환할 카드 : 4개 남았습니다
2
교환할 카드 : 3개 남았습니다
3
교환할 카드 : 2개 남았습니다
4
교환할 카드 : 1개 남았습니다
5
현제 가지고 있는 카드
1 번째 카드 SIX HEART 
2 번째 카드 SIX DIA 
3 번째 카드 THREE HEART 
4 번째 카드 THREE DIA 
5 번째 카드 FOUR SPADE 

1 번째 Player ONE_PAIR ACE_14 DIA 
2 번째 Player NO_PAIR ACE_14 SPADE 
3 번째 Player ONE_PAIR TEN SPADE 
4 번째 Player NO_PAIR ACE_14 CLOVERR 
5 번째 Player TWO_PAIR SIX DIA 

5번쨰 Player가 이겼습니다 !
```


## 🔍 유효성 검사 목록


### - Player수가 [2-10] 이 아닌 경우  

### - 교환할 카드의 순서가 [1-5] 가 아닌 경우

### - 교환할 카드의 개수가 [0-5] 가 아닌 경우 

### - Player 카드 추가

### - Player 카드 삭제

---

## 🧪 테스트 목록 

### - Player 카드 추가 

### - Player 카드 삭제 

### - 족보 판별 

### - 승리여부 판별

---

## 다른 부분들도 어려움을 느끼지만 
## 테스트 코드 작성하는 게 가장 어려운 것 같습니다.
## 설계 자체를 잘못해서 그런 것 같은데
## 혹시 관련해서 자료나 알려주실 것 이 있다면 알려주시면 정말 감사할 것 같습니다.
## 감사합니다.

