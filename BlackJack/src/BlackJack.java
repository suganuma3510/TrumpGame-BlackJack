
public class BlackJack {

    public static void main(String[] args) {
        try {
            //�R�D�̐���
            TrumpDeck trumpDeck = new TrumpDeck();

            //�v���C���[�̐���
            User user = new User("���c", 100000);

            //�i�s���̐���
            Dealer dealer = new Dealer("�f�B�[���[");
//            Dealer dealer = new FakeDealer("�C�J�T�}�f�B�[���[");
//            Dealer dealer = new VeteranDealer("�x�e�����f�B�[���[");

            //�i�s���ɏ�A�v���C���[�A�R�D��n���Q�[���̏���������
            dealer.prepareGame(user, trumpDeck);
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
