
import java.util.Collections;

//Dealer�C���^�[�t�F�[�X���p�������V�ăf�B�[���[�N���X
public class BeginnerDealer implements Dealer {

    private Player player;
    private TrumpDeck trumpDeck;
    private Table field;

    public Player getPlayer() {
        return this.player;
    }

    private void setPlayer(Player player) {
        this.player = player;
    }

    public TrumpDeck getTrumpDeck() {
        return this.trumpDeck;
    }

    private void setTrumpDeck(TrumpDeck trumpDeck) {
        this.trumpDeck = trumpDeck;
    }

    public Table getField() {
        return this.field;
    }

    private void setField(Table field) {
        this.field = field;
    }

    //�Q�[���̏��������郁�\�b�h
    @Override
    public void prepareGame(Player player, TrumpDeck trumpDeck, Table field) {
        setField(field);
        setPlayer(player);
        setTrumpDeck(trumpDeck);
    }

    //�Q�[�����n�߂郁�\�b�h
    @Override
    public void startGame() {
        System.out.println("�y�u���b�N�W���b�N���J�n���܂��z");
        handOutCards();
    }

    //��D��z�郁�\�b�h
    @Override
    public void handOutCards() {
        System.out.println("�y�v���C���[�ɃJ�[�h��z��܂��z");
        //�R�D���V���b�t������
        Collections.shuffle(getTrumpDeck().getDeck());
        //�P���J�[�h��z��
        player.setHand(getTrumpDeck().getDeck().get(0));
        getTrumpDeck().getDeck().remove(0);

    }

    //�������v���C���[���`�F�b�N����
    @Override
    public void winPlayer() {

    }

    //�Q�[�����ʂ�\������
    @Override
    public void result() {
        System.out.println("�y�Q�[���I���z");

    }
}
