package com.nichols.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RemoveInvalidPraentheses {
    Set< String > result = new HashSet< String >();
    public ArrayList< String > solve(String A) {
        int left = 0;
        int right = 0;
        // First, we find out the number of misplaced left and right parentheses.
        for (int i = 0; i < A.length(); i++) {
            // Simply record the left one.
            if (A.charAt(i) == '(') {
                left += 1;
            } else if (A.charAt(i) == ')') {
                // If we don't have a matching left, then this is a misplaced right, record it.
                if (left == 0) right += 1;
                // Decrement count of left parentheses because we have found a right
                // which CAN be a matching one for a left.
                if (left > 0) left -= 1;
            }
        }
        List < Character > expr = new ArrayList < > ();
        // Now, the left and right variables tell us the number of misplaced left and
        // right parentheses and that greatly helps pruning the recursion.
        recurse(A, 0, 0, 0, left, right, expr);
        ArrayList < String > ans = new ArrayList < String > ();
        for (String x: result) {
            ans.add(x);
        }
        return ans;
    }
    public void recurse(String s, int index, int left_count, int right_count, int left_rem, int right_rem, List < Character > expr) {
        // If we reached the end of the string, just check if the resulting expression is
        // valid or not and also if we have removed the total number of left and right
        // parentheses that we should have removed.
        if (index == s.length()) {
            if (left_rem == 0 && right_rem == 0) {
                String tmp = new String();
                for (Character x: expr) tmp += x;
                result.add(tmp);
            }
        } else {
            // The discard case. Note that here we have our pruning condition.
            // We don't recurse if the remaining count for that parenthesis is == 0.
            int f1 = 0, f2 = 0;
            if ((s.charAt(index) == '('))
                f1 = 1;
            if ((s.charAt(index) == ')'))
                f2 = 1;
            if ((s.charAt(index) == '(' && left_rem > 0) || (s.charAt(index) == ')' && right_rem > 0)) {
                recurse(s, index + 1, left_count, right_count, left_rem - f1, right_rem - f2, expr);
            }
            expr.add(s.charAt(index));
            // Simply recurse one step further if the current character is not a parenthesis.
            if (s.charAt(index) != '(' && s.charAt(index) != ')') {
                recurse(s, index + 1, left_count, right_count, left_rem, right_rem, expr);
            } else if (s.charAt(index) == '(') {
                // Consider an opening bracket.
                recurse(s, index + 1, left_count + 1, right_count, left_rem, right_rem, expr);
            } else if (s.charAt(index) == ')' && left_count > right_count) {
                // Consider a closing bracket.
                recurse(s, index + 1, left_count, right_count + 1, left_rem, right_rem, expr);
            }
            // Pop for backtracking.
            expr.remove(expr.size() - 1);
        }
    }
}