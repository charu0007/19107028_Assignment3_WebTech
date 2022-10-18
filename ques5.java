import java.util.*;

public class ques5 {

static int ans[][];
static ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();

static void printAllChanges(String s1, String s2, ArrayList<String> changes) {

    int i = s1.length();
    int j = s2.length();

    while (true) {

        if (i == 0 || j == 0) {
            arr.add(changes);
            break;
        }
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            i--;
            j--;
        }
        else {
            boolean b1 = false, b2 = false;

            // Replace
            if (ans[i][j] == ans[i - 1][j - 1] + 1) {
                changes.add("Change " + s1.charAt(i - 1)
                        + " to " + s2.charAt(j - 1));
                i--;
                j--;
                b1 = true;
            }
            if (ans[i][j] == ans[i - 1][j] + 1) {
                if (b1 == false) {
                    changes.add("Delete " + s1.charAt(i - 1));
                    i--;
                } else {
                    ArrayList<String> changes2 = new ArrayList<String>();
                    changes2.addAll(changes);
                    changes2.remove(changes.size() - 1);
                    changes2.add("Delete " + s1.charAt(i));
                    printAllChanges(s1.substring(0, i),
                            s2.substring(0, j + 1), changes2);
                }

                b2 = true;
            }
            if (ans[i][j] == ans[i][j - 1] + 1) {
                if (b1 == false && b2 == false) {
                    changes.add("Add " + s2.charAt(j - 1));
                    j--;
                } else {
                    ArrayList<String> changes2 = new ArrayList<String>();
                    changes2.addAll(changes);
                    changes2.remove(changes.size() - 1);
                    changes2.add("Add " + s2.charAt(j));
                    printAllChanges(s1.substring(0, i + 1),
                            s2.substring(0, j), changes2);
                }
            }
        }
    }
}

    static void printWays(String s1, String s2, ArrayList<String> changes) {
        printAllChanges(s1, s2, new ArrayList<String>());

        int i = 1;

        for (ArrayList<String> ar : arr) {
            System.out.println("\nMethod " + i++ + " : \n");
            for (String s : ar) {
                System.out.println(s);
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First String: ");
        String s1 = sc.nextLine();
        System.out.println("Enter Second String: ");
        String s2 = sc.nextLine();

        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = i;
        for (int j = 0; j <= m; j++)
            dp[0][j] = j;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1],Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }

        ans = dp;

        printWays(s1, s2, new ArrayList<String>());
    }

}
