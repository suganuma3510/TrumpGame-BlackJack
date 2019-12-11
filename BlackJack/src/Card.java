
//１枚のカードクラス
public class Card {

    private Mark mark;
    private int number;
    private int point;

    Card(Mark mark, int number) {
        setMark(mark);
        setNumber(number);
        cardPoints();
    }

    public Mark getMark() {
        return this.mark;
    }

    private void setMark(Mark mark) {
        this.mark = mark;
    }

    public int getNumber() {
        return this.number;
    }

    private void setNumber(int number) {
        this.number = number;
    }

    public int getPoint() {
        return this.point;
    }

    private void setPoint(int point) {
        this.point = point;
    }

    //カードの名前を文字列で返す
    @Override
    public String toString() {
        switch (getNumber()) {
            case 1:
                return getMark() + "のA";
            case 11:
                return getMark() + "のJ";
            case 12:
                return getMark() + "のQ";
            case 13:
                return getMark() + "のK";
            default:
                return getMark() + "の" + getNumber();
        }
    }

    public void cardPoints() {
        switch (getNumber()) {
            case 1:
                setPoint(11);
                break;
            case 11:
                setPoint(10);
                break;
            case 12:
                setPoint(10);
                break;
            case 13:
                setPoint(10);
                break;
            default:
                setPoint(getNumber());
        }
    }
}