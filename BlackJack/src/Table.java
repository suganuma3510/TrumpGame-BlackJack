
import java.util.ArrayList;

//捨て札や上がったプレイヤーを管理するテーブルクラス
public class Table {

    //プレイヤーの手札
    private ArrayList<Card> playerHand;
    //ディーラーの手札
    private ArrayList<Card> dealerHand;

    Table() {
        playerHand = new ArrayList<Card>();
        dealerHand = new ArrayList<Card>();
    }

    public ArrayList<Card> getPlayerHand() {
        return this.playerHand;
    }

    public void setPlayerHand(Card card) {
        this.playerHand.add(card);
    }

    public ArrayList<Card> getDealerHand() {
        return this.dealerHand;
    }

    public void setDealerHand(Card card) {
        this.dealerHand.add(card);
    }
}
