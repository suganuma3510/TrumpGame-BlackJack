
public class BlackJack {

    public static void main(String[] args) {
        try {
            //�R�D�̐���
            TrumpDeck trumpDeck = new TrumpDeck();

            //�v���C���[�̐����Ɠ����ɏ���������
            User user = new User("���c", 100000);

            //�i�s���̐���
//            Dealer dealer = new Dealer("�f�B�[���[");
//            //�K���u���b�N�W���b�N���o��
//            Dealer dealer = new FakeDealer("�C�J�T�}�f�B�[���[");
//            //��΂Ƀo�[�X�g���Ȃ�
//            Dealer dealer = new VeteranDealer("�x�e�����f�B�[���[");
            //�o�[�X�g���₷��
            Dealer dealer = new BeginnerDealer("�V�ăf�B�[���[");

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
