
import java.util.ArrayList;
import java.util.Scanner;

//�Q�[��������v���C���[�N���X
public abstract class Player {

    private String name;
    private Table field;
    private ArrayList<Card> hand;
    private int totalPoint;
    private boolean blackJack = false;

    Player(String name) {
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

    public Table getField() {
        return this.field;
    }

    public void setField(Table field) {
        this.field = field;
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public void setHand(Card card) {
        this.hand.add(card);
    }

    public int getTotalPoint() {
        return this.totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    public boolean getBlackJack() {
        return this.blackJack;
    }

    public void setBlackJack(boolean blackJack) {
        this.blackJack = blackJack;
    }

    public void blackJackCheck() {

    }

    //�v���C���[�̌��݂̎�D��\�����郁�\�b�h
    public void showHand() {
        System.out.println(getName() + "����̌��݂̎�D");
        for (Card c : hand) {
            System.out.print("�y" + c.toString() + "�z ");
        }
        System.out.println("�F " + getTotalPoint() + "�_");
    }

   
}
