
public class BlackJack {

    public static void main(String[] args) {
        try {
            //�v���C���[�̐���
            User user = new User("���c",100000);
            //�i�s���̐���
            Dealer dealer = new Dealer("�Q�[���}�X�^�[");
            FakeDealer fakeDealer =new FakeDealer("�C�J�T�}�f�B�[���[");
            //�R�D�̐���
            TrumpDeck trumpDeck = new TrumpDeck();
            //�i�s���ɏ�A�v���C���[�A�R�D��n���Q�[���̏���������
            fakeDealer.prepareGame(user, trumpDeck);
            System.out.println(user.bet());
            System.out.println(user.getChip());
            //�Q�[���̊J�n
            fakeDealer.startGame();
            //�Q�[������
            fakeDealer.result();
        } catch (Exception e) {
            //��O����
            System.out.println("�G���[���������܂����B");
            e.printStackTrace();
        }
    }
}
