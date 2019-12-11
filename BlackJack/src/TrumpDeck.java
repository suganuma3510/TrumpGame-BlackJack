
import java.util.ArrayList;

//カードの山札クラス
public class TrumpDeck {

    private ArrayList<Card> deck;

    TrumpDeck() {
        //山札作成
        this.deck = new ArrayList<Card>();
        for (int i = 1; i <= 13; i++) {
            this.deck.add(new Card(Suit.spade, i));
            this.deck.add(new Card(Suit.heart, i));
            this.deck.add(new Card(Suit.club, i));
            this.deck.add(new Card(Suit.diamond, i));
        }
    }

    public ArrayList<Card> getDeck() {
        return this.deck;
    }

    public void setDeck(Card card) {
        this.deck.add(card);
    }
}
