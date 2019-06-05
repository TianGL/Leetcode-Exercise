package cn.geliang.stackAndQueue;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;

public class Leetcode150 {

    public static void main(String[] args) {
        String str = "[\"10\",\"6\",\"9\",\"3\",\"+\",\"-11\",\"*\",\"/\",\"*\",\"17\",\"+\",\"5\",\"+\"]";
        String resStr = str.replaceAll("[\\[|\"|\\]]", "");
        String[] tokens = resStr.split("\\,");
        System.out.println(Arrays.asList(tokens));
        System.out.println(new Leetcode150().evalRPN(tokens));
    }

    // 20190603
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        String numRegex = "-?\\d+";
        for(String token : tokens) {
            if (token.matches(numRegex)) {
                // 是数字
                numStack.push(Integer.valueOf(token));
            } else {
                if("+".equals(token)) {
                    Integer right = numStack.pop();
                    Integer left = numStack.pop();
                    numStack.push(left+right);
                } else if ("-".equals(token)) {
                    Integer right = numStack.pop();
                    Integer left = numStack.pop();
                    numStack.push(left-right);
                } else if ("*".equals(token)) {
                    Integer right = numStack.pop();
                    Integer left = numStack.pop();
                    numStack.push(left*right);
                }  else if ("/".equals(token)) {
                    Integer right = numStack.pop();
                    Integer left = numStack.pop();
                    numStack.push(left/right);
                }
            }
//            System.out.println(numStack.peek());
        }
        return numStack.pop();
    }

}
