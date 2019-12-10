
import java.util.ArrayList;
import java.util.Collections;

//Dealer�C���^�[�t�F�[�X���p�������V�ăf�B�[���[�N���X
public class BeginnerDealer implements Dealer {

    private Player player;
    private TrumpDeck trumpDeck;
    private Table field;
    private int totalPoint;

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

    public int getTotalPoint() {
        return this.totalPoint;
    }

    private void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    //�Q�[���̏��������郁�\�b�h
    @Override
    public void prepareGame(Player player, TrumpDeck trumpDeck, Table field) {
        setField(field);
        setPlayer(player);
        player.setField(field);
        setTrumpDeck(trumpDeck);
    }

    //�Q�[�����n�߂郁�\�b�h
    @Override
    public void startGame() {
        System.out.println("�y�u���b�N�W���b�N���J�n���܂��z");
        getField().setPlayerHand(handOutCards());
        getField().setPlayerHand(handOutCards());
        getField().setPlayerHand(handOutCards());
        player.pointCount();
    }

    //��D��z�郁�\�b�h
    @Override
    public Card handOutCards() {
        System.out.println("�y�v���C���[�ɃJ�[�h��z��܂��z");
        //�R�D���V���b�t������
        Collections.shuffle(getTrumpDeck().getDeck());
        //�P���J�[�h�������_���ɔz��   
        return getTrumpDeck().getDeck().remove(0);

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

    public void pointCount() {
        boolean aceCheck = false;
        for (Card c : getField().getDealerHand()) {
            aceCheck = c.getNumber() == 11;
            setTotalPoint(getTotalPoint() + c.getPoint());
        }
        if (aceCheck) {
            if (getTotalPoint() < 11) {
                setTotalPoint(getTotalPoint() + 10);
            } else {
                setTotalPoint(getTotalPoint() - 10);
            }
        }
    }

    public void playerTurn() {
        pointCount();
    }
}
