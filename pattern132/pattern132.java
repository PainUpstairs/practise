package pattern132;
import java.util.Arrays;
import java.util.HashMap;

public class pattern132 {

    public static boolean find132pattern(int[] nums) {

        int iNum = Integer.MAX_VALUE;
        for (int j = 1; j < nums.length - 1; j++) {
            int jNum = nums[j];
            if (iNum > nums[j - 1]) {
                iNum = nums[j - 1];
            }

            if (iNum >= jNum) {
                continue;
            }

            for (int k = j + 1; k < nums.length; k++) {
                if (iNum < nums[k] && nums[k] < jNum) {
                    System.out.println(iNum + "->" + jNum + "->" + nums[k]);
                    return true;
                }
            }
        }
        return false;
    }

    public static class TwoNode {
        Object left = null;
        Object right = null;
        int activeNo = 1;

        public TwoNode() {
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public Object getLeft() {
            return left;
        }

        public void setLeft(Object left) {
            this.left = left;
        }

        public Object getRight() {
            return right;
        }

        public void setRight(Object right) {
            this.right = right;
        }

        public int getActiveNo() {
            return activeNo;
        }

        public void setActivePlus() {
            this.activeNo = this.activeNo + 1;
        }

        public void setActiveMinus() {
            this.activeNo = this.activeNo - 1;
        }

        @Override
        public String toString() {
            return "TwoNode [left=" + left + ", right=" + right + ", activeNo=" + this.activeNo + "]";
        }
    }

    public static void main(String[] args) {
        // i<j<k
        // nums[i]<nums[k]<nums[j]
        int[] nums = new int[199];

        for(int i =0; i<199;i++){
            nums[i] = (i%2== 0) ? i:-i; 
        }
        System.out.println(Arrays.toString(nums));
        // System.out.println(find132pattern(nums));
        HashMap<Integer, TwoNode> heap = new HashMap<>();

        heap.put(nums[1], new TwoNode());
        // heap.get(nums[1]).setActivePlus();
        // heap.get(nums[1]).setActivePlus();


        // startnode => numJ
        // current=> numK
        int numI = nums[0];
        for (int i = 2; i < nums.length; i++) {
            // System.out.println(i);
            int startNode = nums[1];
            int current = nums[i];
            if (numI<current && current < startNode){
                System.out.printf("numI->%d numJ-> %d numK->%d",numI,startNode,current);

                break;
            }
            while (true) {
                if (current == startNode) {
                    // System.out.println("fghcgh"+current);
                    heap.get(startNode).setActivePlus();
                    break;
                }
                // System.out.println(i);
                if (startNode < current) {
                    Object rightVal = heap.get(startNode).getRight();
                    if (rightVal == null) {
                        heap.get(startNode).setRight(current);
                        heap.put(current, new TwoNode());
                        break;
                    } else {
                        startNode = (Integer) rightVal;
                    }
                }

                if (current < startNode) {
                    Object leftVal = heap.get(startNode).getLeft();
                    if (leftVal == null) {
                        heap.get(startNode).setLeft(current);
                        heap.put(current, new TwoNode());
                        break;
                    } else {
                        startNode = (Integer) leftVal;
                    }
                }
            }
        }
        System.out.println(heap);

    }
}