
import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> deck;

    Deck() {
        //�R�D�쐬
        this.deck = new ArrayList<Card>();
        for (int i = 1; i <= 13; i++) {
            this.deck.add(new Card("S", i));
            this.deck.add(new Card("H", i));
            this.deck.add(new Card("K", i));
            this.deck.add(new Card("D", i));
        }
    }

    public ArrayList<Card> getDeck() {
        return this.deck;
    }
}
