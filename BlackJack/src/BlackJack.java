
import java.util.ArrayList;

public class BlackJack {

    public static void main(String[] args) {

        try {
            //�v���C���[�̐���
            User player = new User("���c");
            //�i�s���̐���
            Dealer dealer = new Dealer("�Q�[���}�X�^�[");
            //�R�D�̐���
            TrumpDeck trumpDeck = new TrumpDeck();
            //��̐���
            Table field = new Table();
            //�i�s���ɏ�A�v���C���[�A�R�D��n���Q�[���̏���������
            dealer.prepareGame(player, trumpDeck, field);
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
