import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        return canWinHelper(leap, game, 0);
    }

    private static boolean canWinHelper(int leap, int[] game, int i) {
        if (i < 0 || game[i] == 1) {
            return false;
        } else if (i >= game.length - 1 || i + leap >= game.length) {
            return true;
        }

        game[i] = 1; // Mark the current index as visited

        return canWinHelper(leap, game, i + 1) || canWinHelper(leap, game, i - 1) || canWinHelper(leap, game, i + leap);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
