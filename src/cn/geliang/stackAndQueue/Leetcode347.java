package cn.geliang.stackAndQueue;

import java.util.*;

public class Leetcode347 {
    // 20190610
    // 维护k长度的优先级队列
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            int numFreq = freq.getOrDefault(num, 0);
            freq.put(num, numFreq + 1);
        }

        Iterator<Integer> iter = freq.keySet().iterator();
        PriorityQueue<NumAndFreq> pq = new PriorityQueue<>();
        while (iter.hasNext()) {
            Integer num = iter.next();
            Integer numFreq = freq.get(num);
            if (pq.size() == k) {
                if (pq.peek().freq < numFreq) {
                    pq.poll();
                    pq.offer(new NumAndFreq(num, numFreq));
                }
            } else {
                pq.offer(new NumAndFreq(num, numFreq));
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().num);
        }
        return res;
    }

    private class NumAndFreq implements Comparable<NumAndFreq> {
        int num;
        int freq;

        public NumAndFreq(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        @Override
        public int compareTo(NumAndFreq o) {
            return this.freq - o.freq;
        }
    }

    // 20190610
    // 维护n-k长度的优先级队列
    public List<Integer> topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            int numFreq = freq.getOrDefault(num, 0);
            freq.put(num, numFreq + 1);
        }
        Iterator<Integer> iter = freq.keySet().iterator();
        PriorityQueue<NumAndFreq2> pq = new PriorityQueue<>();
        List<Integer> res = new ArrayList<>();
        while (iter.hasNext()) {
            Integer num = iter.next();
            Integer numFreq = freq.get(num);
            if (pq.size() == freq.size() - k) {
                if (freq.size() - k == 0) {
                    res.add(num);
                } else if (pq.peek().freq > numFreq) {
                    res.add(pq.poll().num);
                    pq.offer(new NumAndFreq2(num, numFreq));
                } else {
                    res.add(num);
                }
            } else {
                pq.offer(new NumAndFreq2(num, numFreq));
            }
        }
        return res;
    }

    private class NumAndFreq2 implements Comparable<NumAndFreq2> {
        int num;
        int freq;

        public NumAndFreq2(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        @Override
        public int compareTo(NumAndFreq2 o) {
            return o.freq - this.freq;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int k = 2;
        Leetcode347 sol = new Leetcode347();
        System.out.println(sol.topKFrequent2(nums, k));
    }
}
