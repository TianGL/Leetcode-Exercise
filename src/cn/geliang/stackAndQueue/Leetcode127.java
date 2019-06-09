package cn.geliang.stackAndQueue;

import java.util.*;

public class Leetcode127 {
    // 20190605
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 0;
        }
        Set<String> visitedWord = new HashSet<>();
        Queue<String> wordQueue = new ArrayDeque<>();
        wordQueue.add(beginWord);
        visitedWord.add(beginWord);
        int step = 1;
        while (wordQueue.size() != 0) {
            int size = wordQueue.size();
            for (int i = 0; i < size; ++i) {
                String curWord = wordQueue.poll();
                for (String word : wordList) {
                    if (!visitedWord.contains(word) && isTransformed(curWord, word)) {
                        if (word.equals(endWord)) {
                            return step + 1;
                        }
                        visitedWord.add(word);
                        wordQueue.add(word);
                    }
                }
            }
            step++;
        }
        return 0;
    }

    private boolean isTransformed(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int diffNum = 0;
        for (int i = 0; i < str1.length(); ++i) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diffNum++;
                if (diffNum > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
