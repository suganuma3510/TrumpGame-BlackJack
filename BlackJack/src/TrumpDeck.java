
import java.util.ArrayList;

//�J�[�h�̎R�D�N���X
public class TrumpDeck {

    private ArrayList<Card> deck;

    TrumpDeck() {
        //�R�D�쐬
        this.deck = new ArrayList<Card>();
        for (int i = 1; i <= 13; i++) {
            this.deck.add(new Card(Mark.spade, i));
            this.deck.add(new Card(Mark.heart, i));
            this.deck.add(new Card(Mark.club, i));
            this.deck.add(new Card(Mark.diamond, i));
        }
    }

    public ArrayList<Card> getDeck() {
        return this.deck;
    }
}