import java.util.Random;
public class p84 {
    public static final int
        DICE = 4,
        SQUARES = 40,
        CARDS = 16,
        GO = 0,
        CC1 = 2,
        R1 = 5,
        CH1 = 7,
        JAIL = 10,
        C1 = 11,
        U1 = 12,
        R2 = 15,
        CC2 = 17,
        CH2 = 22,
        E3 = 24,
        R3 = 25,
        U2 = 28,
        G2J = 30,
        CC3 = 33,
        R4 = 35,
        CH3 = 36,
        H2 = 39;
    public static final int RANDOMTIMES = 2000000;
    public static int cntDoubles = 0;
    public static Random Randomizer = new Random(System.currentTimeMillis());
    public static int[] freq = new int[SQUARES];
    public static int getScore() {
        return 2 + Randomizer.nextInt(DICE) + Randomizer.nextInt(DICE);
    }
    public static int getCard() {
        return Randomizer.nextInt(CARDS) + 1;
    }
    public static boolean isCommunityChest (int current) {
        return current == CC1 || current == CC2 || current == CC3;
    }
    public static boolean isChance (int current) {
        return current == CH1 || current == CH2 || current == CH3;
    }
    public static int nextR (int current) {
        if (current < R1 || current >= R4) {
            return R1;
        } else if (R1 <= current && current < R2) {
            return R2;
        } else if (R2 <= current && current < R3) {
            return R3;
        } else {
            return R4;
        }
    }
    public static int nextU (int current) {
        if (current < U1 || current >= U2) {
            return U1;
        } else {
            return U2;
        }
    }
    public static int getNext (int current) {
        int score = getScore();
        if (score == 2) {
            ++cntDoubles;
        } else {
            cntDoubles = 0;
        }
        if (cntDoubles == 3) {
            cntDoubles = 0;
            return JAIL;
        }
        int next = (current + score) % SQUARES;
        if (next == G2J) {
            return JAIL;
        }
        if (isCommunityChest(next)) {
            int card = getCard();
            if (card > 2) {
                return next;
            } else {
                if (card == 1) {
                    return GO;
                } else if (card == 2) {
                    return JAIL;
                }
            }
        } else if (isChance(next)) {
            int card = getCard();
            if (card > 10) {
                return next;
            } else {
                switch (card) {
                    case 1:
                        return GO;
                    case 2:
                        return JAIL;
                    case 3:
                        return C1;
                    case 4:
                        return E3;
                    case 5:
                        return H2;
                    case 6:
                        return R1;
                    case 7:
                        return nextR(next);
                    case 8:
                        return nextR(next);
                    case 9:
                        return nextU(next);
                    case 10:
                        return (next + SQUARES - 3) % SQUARES;
                }
            }
        } else {
            return next;
        }
        return 0;
    }
    public static void main(String[] args) {
        int now = 0;
        for (int i = 0; i < RANDOMTIMES; ++i) {
            now = getNext(now);
            ++freq[now];
        }
        int[] firstthree = new int[3];
        boolean[] selected = new boolean[SQUARES];
        for (int i = 0; i < 3; ++i) {
            int maxFreq = 0;
            for (int j = 0; j < SQUARES; ++j) {
                if (!selected[j] && freq[j] > maxFreq) {
                    maxFreq = freq[j];
                    firstthree[i] = j;
                }
            }
            selected[firstthree[i]] = true;
            if (firstthree[i] < 10) {
                System.out.print(0);
            }
            System.out.print(firstthree[i]);
        }
        System.out.print("\n");
    }
}
