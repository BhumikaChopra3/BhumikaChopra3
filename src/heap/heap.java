package heap;

import java.util.ArrayList;

public class heap {

	ArrayList<Integer> data = new ArrayList<>();

	// tc = logn
	public void add(int item) {
		data.add(item);
		upheapify(data.size() - 1);

	}

	private void upheapify(int ci) {
		// TODO Auto-generated method stub
		int pi = (ci - 1) / 2;

		if (data.get(ci) < data.get(pi)) {
			swap(pi, ci);
			upheapify(pi);
		}

	}

	private void swap(int i, int j) {

		int ith = data.get(i);
		int jth = data.get(j);

		data.set(i, jth);
		data.set(j, ith);
	}

	public void display() {
		System.out.println(data);

	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	// tc = logn
	public int remove() {

		swap(0, data.size() - 1);

		int rv = this.data.remove(this.data.size() - 1);

		downheapify(0);

		return rv;

	}

	private void downheapify(int pi) {
		// TODO Auto-generated method stub

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mini = pi;

		if (data.get(lci) < data.get(mini) && lci < this.data.size())
			mini = lci;

		if (data.get(rci) < data.get(mini) && rci < this.data.size())
			mini = rci;

		if (mini != pi) {
			swap(pi, mini);
			downheapify(mini);
		}

	}

	public int get() {
		return this.data.get(0);
	}

}
