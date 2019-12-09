
import java.util.ArrayList;

public class BlackJack {

    public static void main(String[] args) {

        try {
            //�v���C���[�̐���
            ArrayList<Player> player = new ArrayList<Player>();
            player.add(new Player("���c"));
            player.add(new Player("�R�c"));
            //�i�s���̐���
            Dealer dealer = new Dealer();
            //�R�D�̐���
            Deck deck = new Deck();
            //��̐���
            Table field = new Table();
            //�i�s���ɏ�A�v���C���[�A�R�D��n���Q�[���̏���������
            dealer.prepareGame(player, deck, field);
            //�Q�[���̊J�n
            dealer.startGame();
            //�Q�[������
            dealer.result();
        } catch (Exception e) {
            //��O����
            System.out.println("�G���[���������܂����B");
            e.printStackTrace();
        }
    }
}
