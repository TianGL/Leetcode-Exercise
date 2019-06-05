package cn.geliang.stackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode071 {
    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";
        String[] splitStr = path.split("/");
        System.out.println(new Leetcode071().simplifyPath(path));
    }

    // 20190603
    public String simplifyPath(String path) {
        String[] splitPath = path.split("/");
        Stack<String> fileStack = new Stack<>();
        for (String str : splitPath) {
            if (str.isEmpty() || ".".equals(str)) {
                continue;
            } else if ("..".equals(str)) {
                if (!fileStack.isEmpty()) {

                    fileStack.pop();
                }
            } else {
                fileStack.push(str);
            }
        }
        StringBuilder strBuilder = new StringBuilder();
        while (!fileStack.isEmpty()) {
            strBuilder.insert(0, fileStack.pop());
            strBuilder.insert(0, "/");
        }
        if (strBuilder.length() == 0) {
            strBuilder.append("/");
        }
        return strBuilder.toString();
    }
}
