import java.util.Stack;

public class MiniStack {
    Stack<Integer> stackMin;
    Stack<Integer> stackData;

    public MiniStack() {
        stackMin = new Stack<>();
        stackData = new Stack<>();
    }

    public void push(int val) {
        if (stackMin.isEmpty()) {
           stackMin.push(val);
        }else if (val <= this.getMin()) {
            stackMin.push(val);
        }
        stackData.push(val);
    }

    public int pop() {
        int value = stackData.pop();
        //当弹出的数与最小栈的数相等时，最小栈元素也要弹出
        if (value == this.getMin()) {
            stackMin.pop();
        }
        return value;
    }

    public int top() {
        return stackData.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}
