package April2021PrepLeetcode;

public class _0622CircularQueue {

	public static void main(String[] args) {
		MyCircularQueue myCircularQueue = new MyCircularQueue(3);
		System.out.println(myCircularQueue.enQueue(1)); // return True
		System.out.println(myCircularQueue.enQueue(2)); // return True
		System.out.println(myCircularQueue.enQueue(3)); // return True
		System.out.println(myCircularQueue.enQueue(4)); // return False
		System.out.println(myCircularQueue.Rear()); // return 3
		System.out.println(myCircularQueue.isFull()); // return True
		System.out.println(myCircularQueue.deQueue()); // return True
		System.out.println(myCircularQueue.enQueue(4)); // return True
		System.out.println(myCircularQueue.Rear()); // return 4
	}

	static class MyCircularQueue {

		int[] arr;
		int firstIndex,lastIndex;
		public MyCircularQueue(int k) {
			arr = new int[k];
			firstIndex =-1;
			lastIndex=-1;
		}

		public boolean enQueue(int value) {

		}

		public boolean deQueue() {

		}

		public int Front() {

		}

		public int Rear() {

		}

		public boolean isEmpty() {

		}

		public boolean isFull() {

		}
	}
}
