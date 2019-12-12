
import java.util.ArrayList;
import java.util.Scanner;

//ゲームをするプレイヤークラス
public abstract class Player {

    private String name;
    private Table field;
    private ArrayList<Card> hand;
    private int totalPoint;
    private boolean blackJack = false;

    Player(String name) {
        this.hand = new ArrayList<Card>();
        if (name == null || name == "null") {
            throw new NullPointerException("名前がnullになっています。");
        }
        if (name.isEmpty()) {
            throw new RuntimeException("名前が空白になっています。");
        }
        if (name.length() >= 10) {
            throw new RuntimeException("名前が長すぎます");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Table getField() {
        return this.field;
    }

    public void setField(Table field) {
        this.field = field;
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public void setHand(Card card) {
        this.hand.add(card);
    }

    public int getTotalPoint() {
        return this.totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    public boolean getBlackJack() {
        return this.blackJack;
    }

    public void setBlackJack(boolean blackJack) {
        this.blackJack = blackJack;
    }

    public void blackJackCheck() {

    }

    //プレイヤーの現在の手札を表示するメソッド
    public void showHand() {
        System.out.println(getName() + "さんの現在の手札");
        for (Card c : hand) {
            System.out.print("【" + c.toString() + "】 ");
        }
        System.out.println("： " + getTotalPoint() + "点");
    }

   
}
