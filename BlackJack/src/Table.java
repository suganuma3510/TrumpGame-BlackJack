
import java.util.ArrayList;

//�̂ĎD��オ�����v���C���[���Ǘ�����e�[�u���N���X
public class Table {

    //�̂ĎD
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
