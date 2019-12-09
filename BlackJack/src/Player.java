
import java.util.ArrayList;
import java.util.Scanner;

//�o�o����������v���C���[�N���X
public class Player {

    private String name;
    private ArrayList<Card> hand;
    private Table field;

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

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public void setHand(Card card) {
        this.hand.add(card);
    }

    public Table getField() {
        return this.field;
    }

    public void setField(Table field) {
        this.field = field;
    }

    //�v���C���[�̌��݂̎�D��\�����郁�\�b�h
    public void showHand() {
        System.out.println(getName() + "����̌��݂̎�D");
        for (Card c : hand) {
            System.out.print(c.toString() + " ");
        }
        System.out.println("");
    }

    //���肩������J�[�h��W�����͂Ŏ󂯕t���郁�\�b�h
    public int choiceCard(Player player) throws UnsupportedSannerException {
//        if (player.getHand().size() != 1) {
//            System.out.println("����̎�D��" + player.getHand().size() + "������܂��B");
//            System.out.println("���Ԗڂ̃J�[�h�������܂����H");
//            for (int i = 1; i <= player.getHand().size(); i++) {
//                System.out.print("�y" + i + "�z ");
//            }
//            System.out.println("");
//            Scanner scanner = new Scanner(System.in);
//            //���͂����l���`�F�b�N
//            while (true) {
//                if (scanner.hasNextInt()) {
//                    int choiceNum = scanner.nextInt();
//                    if (choiceNum > player.getHand().size() || choiceNum < 1) {
//                        //�w��O�̐��������͂��ꂽ�ꍇ�̗�O����
//                        System.out.println("�w�肳�ꂽ��������͂��Ă��������B");
//                    } else {
//                        return choiceNum - 1;
//                    }
//                } else {
//                    //���������͂��ꂽ�ꍇ�̗�O����
//                    System.out.println("���������͂���Ă��܂��B�w�肳�ꂽ�����œ��͂��Ă��������B");
//                    scanner.next();
//                }
//            }
//        }
        return 0;
    }
}
