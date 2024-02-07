public class matrix1 {
    public static void main(String[] args) {
        int n = 3;
        int[][] arr = {
                {12, 13, 11},
                {10, 9, 9},
                {8, 7, 15}
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }
}