
import java.util.ArrayList;

//�Q�[��������v���C���[�̒��ۃN���X
public abstract class PlayerBase {

    private String name;
    private ArrayList<Card> hand;
    private int totalScore;
    //��D���u���b�N�W���b�N�Ȃ�true
    private boolean blackJack = false;

    PlayerBase(String name) {
        this.hand = new ArrayList<Card>();
        if (name == null || name == "null") {
            throw new NullPointerException("���O��null�ɂȂ��Ă��܂��B");
        }
        if (name.isEmpty()) {
            throw new RuntimeException("���O���󔒂ɂȂ��Ă��܂��B");
        }
        if (name.length() >= 10) {
            throw new RuntimeException("���O���������܂�");
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

    //�v���C���[�̌��݂̎�D��\�����郁�\�b�h
    public void showHand() {
        System.out.println(getName() + "����̌��݂̎�D");
        for (Card c : hand) {
            System.out.print("�y" + c.toString() + "�z ");
        }
        System.out.println("�F " + getTotalScore() + "�_");
        if (getBlackJack()) {
            System.out.println("�u���b�N�W���b�N�I");
        }
    }
}
