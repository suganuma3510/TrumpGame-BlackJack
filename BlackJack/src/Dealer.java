
import java.util.ArrayList;
import java.util.Collections;

//Dealer�C���^�[�t�F�[�X���p�������V�ăf�B�[���[�N���X
public class Dealer extends Player {

    private User user;
    private TrumpDeck trumpDeck;

    Dealer(String name) {
        super(name);
    }

    public User gatUser() {
        return this.user;
    }

    private void setuser(User user) {
        this.user = user;
    }

    public TrumpDeck getTrumpDeck() {
        return this.trumpDeck;
    }

    private void setTrumpDeck(TrumpDeck trumpDeck) {
        this.trumpDeck = trumpDeck;
    }

    //�Q�[���̏��������郁�\�b�h
    public void prepareGame(User user, TrumpDeck trumpDeck, Table field) {
        setField(field);
        setuser(user);
        user.setField(field);
        setTrumpDeck(trumpDeck);
    }

    //�Q�[�����n�߂郁�\�b�h
    public void startGame() {
        System.out.println("�y�u���b�N�W���b�N���J�n���܂��z");
        System.out.println("�y�v���C���[�ɃJ�[�h��z��܂��B�z");
        for (int i = 0; i < 2; i++) {
            gatUser().setHand(handOutCards());

        }
        this.setHand(handOutCards());
        pointCount(gatUser());
        pointCount(this);
        gatUser().showHand();
        this.showHand();
        while(user.hitCheck()){
             gatUser().setHand(handOutCards());
        }
        userTurn();
    }

    //��D��z�郁�\�b�h
    public Card handOutCards() {
        //�R�D���V���b�t������
        Collections.shuffle(getTrumpDeck().getDeck());
        //�P���J�[�h�������_���ɔz��   
        return getTrumpDeck().getDeck().remove(0);

    }

    //�������v���C���[���`�F�b�N����
    public void winuser(User user) {

    }

    public void pointCount(Player player) {
        boolean aceCheck = false;
        int point = 0;
        for (Card c : player.getHand()) {
            if (c.getNumber() == 1) {
                aceCheck = true;
            }
            point += c.getPoint();
        }
        player.setTotalPoint(point);
        if (player.getHand().size() == 2 && player.getTotalPoint() == 21) {
            player.setBlackJack(true);
        }
        if (aceCheck && player.getTotalPoint() > 21) {
            player.setTotalPoint(player.getTotalPoint() - 10);
        }
    }

    //�Q�[�����ʂ�\����
    public void result() {
        System.out.println("�y�Q�[���I���z");

    }

    public void userTurn() {

    }

    public void dealerTurn() {

    }

   
}
