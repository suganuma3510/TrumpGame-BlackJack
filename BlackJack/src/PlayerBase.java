
import java.util.ArrayList;

//ゲームをするプレイヤーの抽象クラス
public abstract class PlayerBase {

    private String name;
    private ArrayList<Card> hand;
    private int totalScore;
    //手札がブラックジャックならtrue
    private boolean blackJack = false;

    PlayerBase(String name) {
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

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public void setHand(Card card) {
        this.hand.add(card);
    }

    public int getTotalScore() {
        return this.totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public boolean getBlackJack() {
        return this.blackJack;
    }

    public void setBlackJack(boolean blackJack) {
        this.blackJack = blackJack;
    }

    //プレイヤーの現在の手札を表示するメソッド
    public void showHand() {
        System.out.println(getName() + "さんの現在の手札");
        for (Card c : hand) {
            System.out.print("【" + c.toString() + "】 ");
        }
        System.out.println("： " + getTotalScore() + "点");
        if (getBlackJack()) {
            System.out.println("ブラックジャック！");
        }
    }
}
