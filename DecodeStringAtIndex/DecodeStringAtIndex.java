package DecodeStringAtIndex;

import java.util.ArrayList;

public class DecodeStringAtIndex {
    public static String decodeAtIndex(String s, int k) {

        StringBuffer current = new StringBuffer();
        String ans = "";
        // also for levelRepCount
        Long tapeLength = 0L;

        ArrayList<StringBuffer> currentList = new ArrayList<>();
        ArrayList<Long> countList = new ArrayList<>();

        outerloop: for (Character c : s.toCharArray()) {

            // System.out.println("c->" + c);
            if (Character.isDigit(c)) {
                currentList.add(new StringBuffer(current));
                countList.add(tapeLength);
                System.out.println("tapeLength here->"+tapeLength);
                // System.out.println("->"+(tapeLength) * (c - '0' - 1));
                System.out.println("->"+Character.getNumericValue(c));
                tapeLength = tapeLength * Character.getNumericValue(c);
                System.out.println("tapeLenght-->"+tapeLength);
                System.out.println("arey bc ->"+8*605400474);
                System.out.println();
                current = new StringBuffer("");
            } else if (Character.isAlphabetic(c)) {
                current.append(c);
                tapeLength++;
                if (tapeLength == k) {
                    // return Character.toString(c);
                    ans = Character.toString(c);
                    break outerloop;
                }
            }

            // System.out.println("tapeLength->" + tapeLength);
            // System.out.println("k->" + k);

            if (tapeLength >= k) {

                System.out.println("countList->" + countList);
                System.out.println("currentList->" + currentList);

                // handle offset
                k--;
                for (int i = countList.size() - 1; i >= 0; i--) {
                    System.out.println("i->"+i);
                    k = (int) (k % countList.get(i));
                    int preLevelTotalLength = (int) (countList.get(i) - currentList.get(i).length());

                    System.out.println("k->" + k);
                    System.out.println("preLevelTotalLength->" + preLevelTotalLength);
                    if (k >= preLevelTotalLength) {
                        // return String.valueOf(currentList.get(i).charAt(k - preLevelTotalLength));
                        ans = String.valueOf(currentList.get(i).charAt(k - preLevelTotalLength));
                        break outerloop;
                    }
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("index->" + decodeAtIndex("ajx37nyx97niysdrzice4petvcvmcgqn282zicpbx6okybw93vhk782unctdbgmcjmbqn25rorktmu5ig2qn2y4xagtru2nehmsp", 976159153));
    }

    // 2147483647
    // // ****************************************************************
    // Character s = '3';

    // var temp = new StringBuffer();
    // var temp1 = new StringBuffer(Character.toString(s));

    // temp.append(s);
    // System.out.println(s.toString());
    // var arr = new ArrayList<Character>();
    // arr.add(s);

    // arr.addAll(arr);

    // System.out.println("arr->"+arr);
    // System.out.println(Character.isAlphabetic(s));

    // for (int i = 0; i < s-'0'-1; i++) {
    // System.out.println("sfsf");
    // }

    // String ss = "fasffs";
    // for (Character character : ss.toCharArray()) {

    // }
}
