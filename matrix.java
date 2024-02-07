public class matrix {
    public static void main(String[] args) {
        int n = 3;
        Object[][] arr = new Object[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 && j == 0) || (i == 0 && j == (n - 1)) || (i == (n - 1) && j == 0) || (i == (n - 1) && j == (n - 1)))
                {
                    arr[i][j] = " ";
                }
            }
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}