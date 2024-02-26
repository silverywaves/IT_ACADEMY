package ch7;

public class _03_DeckTest {
    public static void main(String[] args){
        Deck d = new Deck();    // 카드 한 벌(Deck)을 만듦
        Card c = d.pick(0);     // pick(int index) 호출 : 섞기 전에 제일 위의 카드를 뽑음
            // = Card pick(int index){
            //      return cardArr[index];
            //   }
        System.out.println(c);        
            // = System.out.println(c.toString());
            // = System.out.println("Card:" + c.toString());
            // = System.out.println("Card:" + c)

        d.shuffle();        // 캬드를 섞음
        c = d.pick();       // 섞은 후 제일 위의 카드를 뽑음
        System.out.println(c);
    }   
}

class Deck{
    final int CARD_NUM = 52;    // 카드의 개수
    Card cardArr[] = new Card[CARD_NUM];    // Card 객체 뱅열 포함

    Deck(){     // Deck 카드 초기화
        int i = 0;

        for(int k=Card.KIND_MAX; k>0; k--)
            for(int n=0; n<Card.NUM_MAX; n++)
            cardArr[i++] = new Card(k, n+1);
        
    }

    Card pick(int index){       // 지정된 위치(index)에 있는  카드 하나를 꺼내서 반환
        return cardArr[index];
    }
    
    Card pick(){                // Deck 에서 카드 하나를 선택
        int index = (int)(Math.random()*CARD_NUM);
        return pick(index);
    }
    void shuffle(){             // 카드 순서 섞음
        for(int i=0; i<cardArr.length; i++){
            int r = (int)(Math.random()*CARD_NUM);

            Card temp = cardArr[i];
            cardArr[i] = cardArr[r];
            cardArr[r] = temp;
        }
    }
}   // end of Deck

class Card{
    static final int KIND_MAX = 4;  // 카드 무늬 수
    static final int NUM_MAX = 13;  // 무늬별 카드 수

    static final int SPADE = 4;
    static final int DIAMOND = 3;
    static final int HEART = 2;
    static final int CLOVER = 1;
    int kind;
    int number;

    Card(){
        this(SPADE, 1);
    }

    Card(int kind, int number){
        this.kind = kind;
        this.number = number;
    }

    public String toString(){
        String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
        String numbers = "0123456789XJQK";  // 숫자 10 = X
        return "kind : " + kinds[this.kind] + ", nuber : " + numbers.charAt(this.number);
    }
}   // end of Card
