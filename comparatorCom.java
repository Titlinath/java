import java.util.*;

// Write your Checker class here
// Implementing the Comparator for Player class
class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        // First, compare the scores in decreasing order
        if (a.score != b.score) {
            return b.score - a.score; // return negative if b.score > a.score for decreasing order
        }
        // If scores are the same, compare the names alphabetically
        return a.name.compareTo(b.name);
    }
}
class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();
     
        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}