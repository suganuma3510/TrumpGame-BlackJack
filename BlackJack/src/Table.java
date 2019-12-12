
import java.util.ArrayList;

//捨て札や上がったプレイヤーを管理するテーブルクラス
public class Table {

    //捨て札
    private ArrayList<Card> discards;

    Table() {
        discards = new ArrayList<Card>();
    }

    public ArrayList<Card> getDiscards() {
        return this.discards;
    }

    public void setDiscards(Card discard) {
        this.discards.add(discard);
    }

}
