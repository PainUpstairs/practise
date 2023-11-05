package MinCostClimbingStairs;

public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {

        int prev1Cost = cost[1];
        int prev2Cost = cost[0];

        for (int i = 2; i < cost.length; i++) {
            // // prev1 => min(prev2,prev1) + cost[of the min position]
            // // prev2 => prev1
            // System.out.println("cost[i]->"+cost[i]);
            int temp = prev1Cost;

            if (prev1Cost < prev2Cost) {
                prev1Cost = prev1Cost + cost[i];
            } else {
                prev1Cost = prev2Cost + cost[i];
            }
            prev2Cost = temp;

            // System.out.println("prev1Cost-> " + prev1Cost);
            // System.out.println("prev2Cost-> " + prev2Cost);
            // System.out.println();
        }


        // check for the exit of the array too
        return prev1Cost < prev2Cost ? prev1Cost : prev2Cost;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        System.out.println("ans->" + minCostClimbingStairs(arr));
    }
}
