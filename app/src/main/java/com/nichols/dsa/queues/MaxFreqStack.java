//package com.nichols.dsa.queues;
//
//import android.os.Build;
//
//import androidx.annotation.RequiresApi;
//
//import com.nichols.dsa.LinkedList;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Queue;
//import java.util.Stack;
//
//public class MaxFreqStack {
////    public String solve(String A) {
////        Queue< Character > q = new LinkedList< Character >();
////        // mp stores the frequency of each character
////        HashMap< Character, Integer > mp = new HashMap < Character, Integer > ();
////        StringBuilder sb = new StringBuilder();
////        for (int i = 0; i < A.length(); i++) {
////            Character c = A.charAt(i);
////            if (mp.get(c) != null) {
////                mp.put(c, 2);
////            } else {
////                q.add(c);
////                mp.put(c, 1);
////            }
////            // remove from queue if the character repeats
////            while (q.size() > 0 && mp.get(q.peek()) > 1) {
////                q.remove();
////            }
////            if (q.size() > 0)
////                sb.append(q.peek());
////            else
////                sb.append('#');
////        }
////        return sb.toString();
////    }
////    HashMap<Integer, Integer> fmap;
////    List<Stack<Integer>> stack;
////
////    public MaxFreqStack() {
////        fmap = new HashMap();
////        stack = new ArrayList();
////        stack.add(new Stack());
////    }
//
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
//        ArrayList<Integer> ans = new ArrayList<>();
//
//        for(int i =0; i<A.size(); i++){
//            ArrayList<Integer> B = A.get(i);
//            if(B.get(0) == 1){
//                //push into stack
//                push(B.get(1));
//                ans.add(-1);
//            } else {
//                int freq = pop();
//                ans.add(freq);
//            }
//        }
//        return  ans;
//    }
//
//
//
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public void push(int x) {
//        int freq = fmap.getOrDefault(x, 0) + 1;
//        fmap.put(x, freq);
//        if (freq == stack.size()) stack.add(new Stack());
//        stack.get(freq).add(x);
//    }
//
//    public int pop() {
//        Stack<Integer> top = stack.get(stack.size()-1);
//        int x = top.pop();
//        if (top.size() == 0) stack.remove(stack.size()-1);
//        fmap.put(x, fmap.get(x) - 1);
//        return x;
//    }
//
//}
