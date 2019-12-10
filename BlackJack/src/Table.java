
import java.util.ArrayList;

//�̂ĎD��オ�����v���C���[���Ǘ�����e�[�u���N���X
public class Table {

    //�v���C���[�̎�D
    private ArrayList<Card> playerHand;
    //�f�B�[���[�̎�D
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
