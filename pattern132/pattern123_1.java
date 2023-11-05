package pattern132;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class pattern123_1 {

    public static Boolean find132pattern(int[] nums) {
        Queue<Integer[]> queue = new LinkedList<Integer[]>();

        // queue.add(new Integer[] { nums[0], null });
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            System.out.println(nums[i]);
            for (Integer[] integers : queue) {
                if (integers[1] < nums[i] && nums[i] < integers[0]) {
                    return true;
                } else if (nums[i] >= integers[0]) {
                    queue.remove(integers);
                }
            }

            // if (nums[i] > queue.peek()[0]) {
            // queue.clear();
            // }
            queue.add(new Integer[] { nums[i], min });
            if (nums[i] < min) {
                min = nums[i];
            }
            System.out.println("fsdfs");
            for (Integer[] integers : queue) {
                System.out.println(Arrays.toString(integers));
            }
        }

        for (Integer[] integers : queue) {
            System.out.println(Arrays.toString(integers));
        }
        // queue.add(new Integer[]{ 1, 2 });
        // queue.add(new Integer[]{ 2, 3 });
        // // queue.
        // // queue.add({1,2});
        // // queue.add(2);
        // System.out.println(Arrays.toString(queue.peek()));

        // queue.pop();
        // System.out.println(Arrays.toString(queue.peek()));

        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 0, 3, 4 };
        int[] nums = new int[199999];

        // for (int i = 0; i < 199999; i++) {
        // nums[i] = (i % 2 == 0) ? i : -i;
        // }
        // System.out.println(Arrays.toString(nums));
        // var Node = new Node(1, false);
        // Node.setLeft(new Node(-1, null));
        // Node.setRight(new Node(2, null));

        // PrintNode(Node);
        // System.out.println("ans-> " + find132pattern(arr));
        System.out.println("ans->"+find132pattern(arr));

    //     var i1 = new Integer[] { 1, 2 };
    //     var i2 = new Integer[] { 1, 3 };
    //     // System.out.println(Arrays.equals(i1, i2));
    //     Queue<Integer[]> q = new LinkedList<Integer[]>();
    //     q.add(i1);
    //     q.add(i2);

    //     // for (Integer[] integers : q) {
    //     //     System.out.println(Arrays.toString(integers));
    //     // }

    //     q.remove();

    //   q.forEach();
        // for (Integer[] integers : q) {
        //     System.out.println(Arrays.toString(integers));
        // }

        // q.add(new Integer[] { 1, 2 });
        // q.add(new Integer[] { 3, 4 });

        // for (Integer[] integers : q) {
        // System.out.println(Arrays.toString(integers));
        // }
        // System.out.println(Arrays.toString(q.peek()));
        // Stack<Integer[]> s = new Stack<Integer[]>();
        // s.add(new Integer[] { 1, 2 });
        // s.add(new Integer[] { 3, 4 });

        // System.out.println();
        // for (Integer[] integers : s) {
        // System.out.println(Arrays.toString(integers));
        // }

        // System.out.println(Arrays.toString(s.peek()));


    }

}
