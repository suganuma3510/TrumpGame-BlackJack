
import java.util.ArrayList;

//�J�[�h�̎R�D�N���X
public class TrumpDeck {

    private ArrayList<Card> deck;

    TrumpDeck() {
        //�R�D�쐬
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
