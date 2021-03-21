package Feb2021Leetcode;

import java.util.Stack;

public class _0716MaxStack {
	public static void main(String[] args) {
		MaxStack stk = new MaxStack();
		stk.push(5); // [5] the top of the stack and the maximum number is 5.
		stk.push(1); // [5, 1] the top of the stack is 1, but the maximum is 5.
		stk.push(5); // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is
						// the top most one.
		System.out.println(stk.top()); // return 5, [5, 1, 5] the stack did not change.
		System.out.println(stk.popMax()); // return 5, [5, 1] the stack is changed now, and the top is different from
											// the
		// max.
		System.out.println(stk.top()); // return 1, [5, 1] the stack did not change.
		System.out.println(stk.peekMax()); // return 5, [5, 1] the stack did not change.
		System.out.println(stk.pop()); // return 1, [5] the top of the stack and the max element is now 5.
		System.out.println(stk.top()); // return 5, [5] the stack did not change.
	}

	static class MaxStack {
		Stack<Integer> stack, maxStack;

		/** initialize your data structure here. */
		public MaxStack() {
			stack = new Stack<Integer>();
			maxStack = new Stack<Integer>();
		}

		public void push(int x) {
			if (stack.isEmpty()) {
				stack.push(x);
				maxStack.push(x);
			} else {
				stack.push(x);
				maxStack.push(Math.max(maxStack.peek(), x));
			}
		}

		public int pop() {
			maxStack.pop();
			return stack.pop();
		}

		public int top() {
			return stack.peek();
		}

		public int peekMax() {
			return maxStack.peek();
		}

		public int popMax() {
			int max = maxStack.peek();
			Stack<Integer> buffer = new Stack<Integer>();
			while (top() != max) {
				buffer.push(pop());
			}
			pop();

			while (!buffer.isEmpty()) {
				push(buffer.pop());
			}
			return max;
		}
	}
}
