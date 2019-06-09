package cn.geliang.stackAndQueue;

import java.util.*;

public class Leetcode126 {
    // 20190605
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (beginWord.equals(endWord)) {
            return res;
        }

        // 将beginWord放到最后
        wordList.add(beginWord);
        Queue<Integer> wordQueue = new ArrayDeque<>();
        wordQueue.add(wordList.size() - 1);

        // 已访问过的word（可在同一距离下访问）
        Set<String> visitedWord = new HashSet<>();
        visitedWord.add(beginWord);

        // word索引和其广度优先的父节点索引数组
        HashMap<Integer, List<Integer>> wordIdxAndPreList = new HashMap<>();

        int step = 1;
        boolean unFinish = true;
        int endWordIdx = -1;
        while (wordQueue.size() != 0 && unFinish == true) {
            int size = wordQueue.size();

            // 存放当前层访问过的word,在该层访问完后以后将不在访问
            List<Integer> curLevelWordVisited = new ArrayList<>();

            for (int i = 0; i < size; ++i) {
                int curWordIdx = wordQueue.poll();
                for (int j = 0; j < wordList.size() - 1; j++) {
                    String word = wordList.get(j);
                    if (!visitedWord.contains(word) && isTransformed(wordList.get(curWordIdx), word)) {
                        if (wordIdxAndPreList.containsKey(j)) {
                            // 如果在本层已经被访问过，则增加一个父节点索引
                            wordIdxAndPreList.get(j).add(curWordIdx);
                        } else {
                            // 否则添加元素
                            wordQueue.offer(j);
                            List<Integer> wordPreList = new ArrayList<>();
                            wordPreList.add(curWordIdx);
                            wordIdxAndPreList.put(j, wordPreList);

                            curLevelWordVisited.add(j); // 待标记为以访问
                        }
                        if (word.equals(endWord) && endWordIdx == -1) {
                            unFinish = false;
                            endWordIdx = j;
                        }
                    }
                }
            }
            // 标记本层访问过的节点
            for (Integer visitedIdx : curLevelWordVisited) {
                visitedWord.add(wordList.get(visitedIdx));
            }
            step++;
        }
        if (endWordIdx != -1) {
            // 存在可达路径
            addLadders(endWordIdx, wordList, wordIdxAndPreList, wordList.size() - 1, res);
        }
        return res;
    }

    // 添加结果
    private void addLadders(int key, List<String> wordList, HashMap<Integer, List<Integer>> wordIdxAndPreList, int end, List<List<String>> res) {
        List<String> ladder = new ArrayList<>();
        ladder.add(wordList.get(key));
        getOneLadder(key, ladder, wordList, wordIdxAndPreList, end, res);
    }

    // 递归添加
    private void getOneLadder(int key, List<String> ladder, List<String> wordList, HashMap<Integer, List<Integer>> wordIdxAndPreList, int end, List<List<String>> res) {

        List<Integer> preList = wordIdxAndPreList.get(key);
        for (Integer idx : preList) {
            // 依次添加父节点
            ladder.add(wordList.get(idx));
            if (idx == end) {
                // 如果父节点为startWord
                res.add(reverseList(ladder));
            } else {
                getOneLadder(idx, ladder, wordList, wordIdxAndPreList, end, res);
            }
            ladder.remove(ladder.size() - 1);
        }
    }

    // 反转链表
    private List<String> reverseList(List<String> list) {
        List<String> reverseList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; --i) {
            reverseList.add(list.get(i));
        }
        return reverseList;
    }

    // 判断两个字符串是否可以转化
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


    public static void main(String[] args) {
        String beginWord = "red";
        String endWord = "tax";
        String[] words = {"ted","tex","red","tax","tad","den","rex","pee"};
        List<String> wordList = new ArrayList<>();
        for (String string : words) {
            wordList.add(string);
        }
        Leetcode126 sol = new Leetcode126();
        System.out.println(sol.findLadders(beginWord, endWord, wordList));
    }


}
