import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class mazeGenFile {

    static Random rand = new Random();
    static HashSet<Integer> emptyBoxes = new HashSet<>();

    public static HashMap<Integer, ArrayList<Integer>> genMaze(int l, int b, int currentIndex, int endIndex) {
        emptyBoxes.remove(Integer.valueOf(currentIndex));
        var maze = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> possibleIndexes = getPossibleIndexes(currentIndex, l, b);

        // when there is no next index or it is the end index
        if (possibleIndexes.isEmpty() || currentIndex == endIndex) {
            return maze;
        }
        Collections.shuffle(possibleIndexes);
        for (int nextIndex : possibleIndexes) {
            // var maze1 = new HashMap<Integer, ArrayList<Integer>>();
            if (emptyBoxes.contains(nextIndex)) {
                maze.putAll(genMaze(l, b, nextIndex, endIndex));

                if (maze.containsKey(currentIndex)) {
                    maze.get(currentIndex).add(nextIndex);
                } else {
                    maze.put(currentIndex, new ArrayList<Integer>(Arrays.asList(nextIndex)));
                }
            }
        }
        return maze;
    }

    // 0 -> up
    // 1 -> right
    // 2 -> down
    // 3 -> left
    public static ArrayList<Integer> getPossibleIndexes(int index, int l, int b) {
        int x = 0; // l
        int y = 0; // b
        int nextNode = 0;
        // Boolean foundNext = false;
        var possibleIndexes = new ArrayList<Integer>();

        // var next_direction_arr = Arrays.asList(0, 1, 2, 3);
        // Collections.shuffle(next_direction_arr);
        for (int nd : Arrays.asList(0, 1, 2, 3)) {
            x = index % l;
            y = index / l;
            // System.out.println("x->" + x + " y->" + y);
            // System.out.println("nd->" + nd);
            switch (nd) {
                case 0:
                    y--;
                    // System.out.println("at 0");
                    break;
                case 1:
                    x++;
                    // System.out.println("at 1");
                    break;
                case 2:
                    y++;
                    // System.out.println("at 2");
                    break;
                case 3:
                    x--;
                    // System.out.println("at 3->" + x);
                    break;
                default:
                    System.out.println("something is wrong");
                    break;
            }
            // System.out.println("x->" + x + " y->" + y);
            nextNode = l * y + x;
            if (x >= 0 && x < l && y >= 0 && y < b
                    && emptyBoxes.contains(nextNode)) {
                // emptyBoxes.remove(nextNode);
                possibleIndexes.add(l * y + x);
                // foundNext = true;
                // break outerLoop;
            }
        }

        return possibleIndexes;
    }

    public static void displayMaze(HashMap<Integer, ArrayList<Integer>> maze, int l, int b) {
        var displayString = new StringBuffer();

        var mazeStore = new ArrayList<StringBuffer>();
        for (int i = 0; i < b; i++) {
            displayString.append(" __");
        }
        mazeStore.add(displayString);
        displayString = new StringBuffer("|");

        for (int i = 0; i < l*b; i++) {
            int x = i % l;
            int y = i / l;

            int downIndex = (y + 1) * l + x;

            if (maze.containsKey(i) && maze.get(i).contains(downIndex)
                    || maze.containsKey(downIndex) && maze.get(downIndex).contains(i)) {
                displayString.append("  ");
            } else {
                displayString.append("__");
            }
            // for right;
            int rightIndex = y * l + x + 1;
            if (maze.containsKey(i) && maze.get(i).contains(rightIndex)
                    || maze.containsKey(rightIndex) && maze.get(rightIndex).contains(i)) {
                displayString.append(" ");
            } else {
                displayString.append("|");
            }

            if (i % b == b - 1) {
                mazeStore.add(displayString);
                displayString = new StringBuffer("|");
            }
        }

        for (StringBuffer sb : mazeStore) {
            System.out.println(sb);
        }
    }



    public static void main(String[] args) {

        int length = 10;
        int breadth = 10;
        int totalNum = length * breadth;
        var boxes = new ArrayList<Integer>();
        for (int i = 0; i < totalNum; i++) {
            boxes.add(i);
        }
        emptyBoxes.addAll(boxes);

        HashMap<Integer, ArrayList<Integer>> maze = genMaze(length, breadth, 0, totalNum-1);
        System.out.println("maze->" + maze);
        displayMaze(maze, length, breadth);
    }
}
