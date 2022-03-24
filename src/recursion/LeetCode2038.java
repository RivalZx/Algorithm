package recursion;

public class LeetCode2038 {
    public boolean winnerOfGame(String colors) {
        int countA = 0, countB = 0;
        int count = 1;
        if (colors.length() < 3)
            return false;

        for (int i = 0; i < colors.length() - 1; i++) {
            if (count > 2) {
                if (colors.charAt(i) == 'A')
                    countA ++;
                else
                    countB ++;
            }
            if (colors.charAt(i) == colors.charAt(i + 1)) {
                count ++;
                continue;
            }
            count = 1;
        }

        return countA > countB;
    }

    public static void main(String[] args) {
        LeetCode2038 leetCode2038 = new LeetCode2038();
        boolean b = leetCode2038.winnerOfGame("AAABABB");
        System.out.println(b);
    }
}
