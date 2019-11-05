package Card;

        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.List;
        import java.util.Random;

public class CardDemo {
    public static final String[] SUIT = {"♥", "♦", "♠", "♣"};
    public static final String[] suit = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private static List<Card> CreateCard() {
        List<Card> ret = new ArrayList<Card>();
        for (int i = 0; i < 4; i++) {
            Card card1 = new Card(SUIT[i], "A");
            ret.add(card1);
            for (int j = 2; j <= 10; j++) {
                Card card = new Card(SUIT[i], j + "");
                ret.add(card);
            }
            card1 = new Card(SUIT[i], "J");
            ret.add(card1);
            card1 = new Card(SUIT[i], "Q");
            ret.add(card1);
            card1 = new Card(SUIT[i], "K");
            ret.add(card1);
        }
        return ret;
    }

    private static void Shuffle(List<Card> deck) {
        Random rd = new Random();
        Collections.shuffle(deck, rd);
    }

    private static void dealCard(List<Card> deck) {
        List<List<Card>> player = new ArrayList<>();
        player.add(new ArrayList<Card>());
        player.add(new ArrayList<Card>());
        player.add(new ArrayList<Card>());
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                player.get(j).add(deck.remove(0));
            }
        }
        System.out.println("A手中的牌");
        System.out.println(player.get(0));
        System.out.println("B手中的牌");
        System.out.println(player.get(1));
        System.out.println("C手中的牌");
        System.out.println(player.get(2));
    }

    private static List<Boolean> isUniform(List<List<Card>> player) {
        List<Boolean> is = new ArrayList<>();
        for (int i = 0; i < player.size(); i++) {
            int j = 0;
            for (; j < player.get(0).size() - 1; j++) {
                if (player.get(i).get(j).suit != player.get(i).get(j + 1).suit) {
                    break;
                }
            }
            if (j == player.get(0).size() - 1) {
                is.add(true);
            } else {
                is.add(false);
            }
        }
        return is;
    }

    private static List<Integer> compare(List<List<Card>> deck) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < deck.size(); i++) {
            int sum = 0;
            for (int j = 0; j < deck.get(0).size(); j++) {
                for (int k = 0; k < suit.length; k++) {
                    if (deck.get(i).get(j).suit == suit[k]) {
                        sum = sum + k;
                    }
                }
            }
            ret.add(sum);
        }
        return ret;
    }


    public static void main(String[] args) {
        List<Card> deck = CreateCard();
        System.out.println(deck);
        Shuffle(deck);
        System.out.println(deck);
        dealCard(deck);
    }
}
