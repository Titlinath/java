//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            int[] brr = IntArray.input(br, n);

            Solution obj = new Solution();
            long res = obj.maxTip(n, x, y, arr, brr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Solution {
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        // code here
         // Create a list to store the orders along with their tip differences
        List<int[]> orders = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            orders.add(new int[] { arr[i], brr[i], Math.abs(arr[i] - brr[i]) });
        }
        
        // Sort the orders based on the absolute difference in descending order
        Collections.sort(orders, (a, b) -> b[2] - a[2]);
        
        long totalTip = 0;
        int countA = 0, countB = 0;
        
        // Iterate through the sorted orders
        for (int[] order : orders) {
            if (order[0] >= order[1]) {
                // Prefer A if the tip is higher and A has capacity
                if (countA < x) {
                    totalTip += order[0];
                    countA++;
                } else {
                    totalTip += order[1];
                    countB++;
                }
            } else {
                // Prefer B if the tip is higher and B has capacity
                if (countB < y) {
                    totalTip += order[1];
                    countB++;
                } else {
                    totalTip += order[0];
                    countA++;
                }
            }
        }
        
        return totalTip;
    }
}
