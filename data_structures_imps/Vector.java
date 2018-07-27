/* 

Mutable array for ints with automatic resizing.

Inspired by https://github.com/jwasham/coding-interview-university

*/

public class Vector {
	
	private int size;
	private int capacity;
	private int[] data;

	public Vector() {
		/* 8 is an arbitrary small power of 2. */
		this.capacity = 8;
		this.size = 0;
		this.data = new int[this.capacity];
	}

	public int size() {
		return this.size;
	}

	public int capacity() {
		return this.capacity;
	}

	public boolean is_empty() {
		return (this.size == 0);
	}

	public int at(int index) {
		if (index < 0 || index >= this.capacity) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
		}
		return this.data[index];
	}

	/* Returns first index of found vector value, -1 if not found. */
	public int find(int value) {
		for (int i = 0; i < this.size; i++) {
			if (this.data[i] == value) {
				return i;
			}
		}
		return -1;
	}

	public void push(int item) {
		if (this.size == this.capacity) {
			this.resize(this.capacity * 2);
		}
		this.data[size] = item;
		this.size++;
	}

	public int pop() {
		if (this.size <= 0) {
			return -1;
		}
		int last_item = this.data[this.size];
		this.delete(this.size);
		return last_item;
	}

	public void prepend(int value) {
		if (this.size == this.capacity) {
			this.resize(this.capacity * 2);
		}
		for (int i = this.size; i >= 0; i--) {
			this.data[i] = this.data[i - 1];
		}
		this.data[0] = value;
	}

	private void resize(int new_capacity) {
		int[] new_data = new int[new_capacity];
		for (int i = 0; i < this.capacity; i++) {
			new_data[i] = this.data[i];
		}
		this.data = new_data;
		this.capacity = new_capacity;
	}

	public void insert(int index, int value) {
		if (index < 0 || index >= this.capacity) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
		}
		if (index > this.size) {
			this.data[this.size] = value;
		} else {
			this.data[index] = value;
		}
		this.size++;
	}

	public void delete(int index) {
		if (index < 0 || index >= this.capacity) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
		}
		for (int i = index; i < this.size - 1; i++) {
			this.data[i] = this.data[i+1];
		}
		this.size--;
	}


	/* Looks for value and removes index holding it (even if in multiple places). 
	   Opts for O(n) space and time as opposed to calling delete() and having
	   worst case 1 + 2 + ... + n ~ O(n^2) runtime.
	*/
	public void remove(int value) {
		int count = 0;
		for (int i = 0; i < this.size; i++) {
			if (this.data[i] == value) {
				count++;
			}
		}
		this.size = this.size - count;
		int[] new_data = new int[this.size];
		int j = 0;
		for (int i = 0; i < this.size; i++) {
			if (this.data[i] != value) {
				new_data[j] = this.data[i];
			}
		}
		this.data = new_data;
	}

	public String view() {
		return java.util.Arrays.toString(this.data);
	}
}
