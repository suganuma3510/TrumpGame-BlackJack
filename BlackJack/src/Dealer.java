
import java.util.ArrayList;

//�Q�[���̐i�s������f�B�[���[�N���X
public interface Dealer {

    //�Q�[���̏��������郁�\�b�h
    public void prepareGame( Player player, TrumpDeck trumpDeck, Table field);

    //�Q�[�����n�߂郁�\�b�h
    public void startGame();

    //��D��z�郁�\�b�h
    public Card handOutCards();

    //�������v���C���[���`�F�b�N����
    public void winPlayer();

    //�Q�[�����ʂ�\������
    public void result();
}
