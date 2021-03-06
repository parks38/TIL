## Min Stack

---

### | Tips

- Collections 클래스
  - sort
  - min
  - max
  - ex. Stack, List, Set, Queue, PriorityQueue

### | 풀이방법 (Java)

```
class MinStack {

    int min;
    Stack<Integer> stack;

    public MinStack() {
       stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return Collections.min(stack);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```
