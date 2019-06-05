package cn.geliang.stackAndQueue;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

// origin method name NestedIterator
// leetcode 341
public class NestedIterator implements Iterator<Integer> {

    // 20190604

    private Stack<List<NestedInteger>> nestStack = new Stack<>();
    private Stack<Integer> indexStack = new Stack<>();
    private Integer nextVal;

    public NestedIterator(List<NestedInteger> nestedList) {
        if (nestedList != null && nestedList.size() != 0) {
            nestStack.add(nestedList);
            indexStack.add(0);
        }
    }

    @Override
    public Integer next() {
        return this.nextVal;
    }

    @Override
    public boolean hasNext() {
        while (!nestStack.isEmpty()) {
            List<NestedInteger> curList = nestStack.peek();
            Integer curIdx = indexStack.pop();
            if (curIdx == curList.size() - 1) {
                // 如果已经访问到了当前栈顶链表的最后一个元素，则弹出该链表
                nestStack.pop();
            } else {
                // 若当前栈顶链表未访问完，则索引栈加一后重新入栈
                indexStack.push(curIdx + 1);
            }
            NestedInteger cur = curList.get(curIdx);
            // 按段是Integer还是List<NestedInteger>
            if (cur.isInteger()) {
                this.nextVal = cur.getInteger();
                return true;
            }
            List<NestedInteger> nextList = cur.getList();
            if (nextList != null && nextList.size() != 0) {
                nestStack.push(nextList);
                indexStack.push(0);
            }
        }
        return false;
    }
}
