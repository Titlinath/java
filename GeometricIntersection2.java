import java.util.Scanner;

class Solution {
    // Determine the orientation of triplet (p, q, r)
    int orientation(int[] p, int[] q, int[] r) {
        long val = (long)(q[1] - p[1]) * (r[0] - q[0]) - (long)(q[0] - p[0]) * (r[1] - q[1]);
        if (val == 0) return 0; // collinear
        return (val > 0) ? 1 : 2; // clockwise or counterclockwise
    }

    // Check if q lies on segment pr
    boolean onSegment(int[] p, int[] q, int[] r) {
        if (q[0] <= Math.max(p[0], r[0]) && q[0] >= Math.min(p[0], r[0]) &&
            q[1] <= Math.max(p[1], r[1]) && q[1] >= Math.min(p[1], r[1]))
            return true;
        return false;
    }

    // Determine if segments p1q1 and p2q2 intersect
    String doIntersect(int[] p1, int[] q1, int[] p2, int[] q2) {
        int o1 = orientation(p1, q1, p2); // Orientation of (p1, q1, p2)
        int o2 = orientation(p1, q1, q2); // Orientation of (p1, q1, q2)
        int o3 = orientation(p2, q2, p1); // Orientation of (p2, q2, p1)
        int o4 = orientation(p2, q2, q1); // Orientation of (p2, q2, q1)

        // General case: different orientations
        if (o1 != o2 && o3 != o4) return "true";

        // Special cases: collinear and overlapping
        if (o1 == 0 && onSegment(p1, p2, q1)) return "true";
        if (o2 == 0 && onSegment(p1, q2, q1)) return "true";
        if (o3 == 0 && onSegment(p2, p1, q2)) return "true";
        if (o4 == 0 && onSegment(p2, q1, q2)) return "true";

        // No intersection
        return "false";
    }
}

public class GeometricIntersection2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for the first line segment
        System.out.println("Enter coordinates for the first line segment:");
        int[] p1 = new int[2];
        int[] q1 = new int[2];
        System.out.print("p1 (x1 y1): ");
        p1[0] = sc.nextInt();
        p1[1] = sc.nextInt();
        System.out.print("q1 (x2 y2): ");
        q1[0] = sc.nextInt();
        q1[1] = sc.nextInt();

        // Input for the second line segment
        System.out.println("Enter coordinates for the second line segment:");
        int[] p2 = new int[2];
        int[] q2 = new int[2];
        System.out.print("p2 (x3 y3): ");
        p2[0] = sc.nextInt();
        p2[1] = sc.nextInt();
        System.out.print("q2 (x4 y4): ");
        q2[0] = sc.nextInt();
        q2[1] = sc.nextInt();

        // Check if the line segments intersect
        Solution solution = new Solution();
        String result = solution.doIntersect(p1, q1, p2, q2);

        // Output the result
        if (result.equals("true")) {
            System.out.println("The line segments intersect.");
        } else {
            System.out.println("The line segments do not intersect.");
        }

        sc.close();
    }
}
