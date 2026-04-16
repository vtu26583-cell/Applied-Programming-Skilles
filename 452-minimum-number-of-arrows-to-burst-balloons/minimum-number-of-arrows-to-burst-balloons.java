import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int firstEnd = points[0][1];

        for (int[] balloon : points) {
            int xStart = balloon[0];
            int xEnd = balloon[1];

            if (xStart > firstEnd) {
                arrows++;
                firstEnd = xEnd; 
            }
        }

        return arrows;
    }
}