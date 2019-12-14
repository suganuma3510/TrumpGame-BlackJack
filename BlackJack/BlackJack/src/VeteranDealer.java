
//Dealer�N���X���p�������o�[�X�g�����Ȃ��f�B�[���[�N���X
public class VeteranDealer extends Dealer {

    VeteranDealer(String name) {
        super(name);
    }

    //�f�B�[���[���J�[�h�̓_�����P�V�ȏ�ɂȂ�܂ŁA�J�[�h������
    @Override
    public void dealerTurn() {
        System.out.println("\n��" + getName() + "����̃^�[����");
        System.out.println("Hole Card�����J");
        this.showHand();
        while (getTotalScore() < 21 && getTotalScore() < 17) {
            //�Q�P�ȏ�ɂȂ�Ȃ��悤�ȃJ�[�h����D�ɉ�����
            int notBurst = 21 - getTotalScore();
            for (int i = 0; i < getTrumpDeck().getDeck().size(); i++) {
                if (notBurst > getTrumpDeck().getDeck().get(i).getPoint()) {
                    this.setHand(getTrumpDeck().getDeck().remove(i));
                    break;
                }
            }
            System.out.println("\n�y" + this.getHand().get(this.getHand().size() - 1) + "�z�@�������܂���");
            pointCount(this);
            this.showHand();
        }
    }
}
