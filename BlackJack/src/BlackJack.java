
import java.util.ArrayList;

public class BlackJack {

    public static void main(String[] args) {

        try {
            //�v���C���[�̐���
            Player player = new Player("���c");
            //�i�s���̐���
            Dealer dealer = new BeginnerDealer();
            //�R�D�̐���
            TrumpDeck trumpDeck = new TrumpDeck();
            //��̐���
            Table field = new Table();
            //�i�s���ɏ�A�v���C���[�A�R�D��n���Q�[���̏���������
            dealer.prepareGame(player, trumpDeck, field);
            //�Q�[���̊J�n
            dealer.startGame();

            player.showHand();
            //�Q�[������
            dealer.result();
        } catch (Exception e) {
            //��O����
            System.out.println("�G���[���������܂����B");
            e.printStackTrace();
        }
    }
}
