
//トランプの柄
enum Mark {
    spade, heart, club, diamond, Joker;

    //カードの柄を文字列で返す
    public String toString() {
        switch (this) {
            case spade:
                return "スペード";
            case heart:
                return "ハート";
            case club:
                return "クラブ";
            case diamond:
                return "ダイヤ";
            case Joker:
                return "ジョーカー";
            default:
                return "ジョーカー";
        }
    }
}
