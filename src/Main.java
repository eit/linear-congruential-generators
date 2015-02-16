import java.util.HashMap;

public class Main {

	public static void main(String[] args) {

		// input 5 integers
		int a = 1234;
		int b = 5678;
		int x = 123;
		int k = 12345;
		int m = 9876;

		// int a = 3; int b = 2; int x = 5; int k = 13; int m = 7;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		// build map table
		int order = 1;

		while (!map.containsValue(x)) {
			map.put(order, x);
			// System.out.println(x);
			x = ((a * x) + b) % m;
			order++;
		}

		int cycle_point = 0;
		for (int i = 1; i < map.size(); i++) {
			if (map.get(i) == x) {
				cycle_point = i;
				// System.out.println("is " + y);
			}
		}

		if (k < map.size()) {

			// print K to K+4
			int pin = k;
			for (int i = 0; i <= 4; i++) {
				System.out.println(map.get(pin));
				pin++;
			}
		}

		else {
			// print K to K+4
			int pin = (k - (cycle_point - 1))
					% (map.size() - (cycle_point - 1));
			if (pin == 0) {
				pin = map.size();
			}
			pin = pin + (cycle_point - 1);
			for (int i = 0; i <= 4; i++) {
				if (pin >= map.size()) {
					pin = pin - cycle_point;
				}
				System.out.println(pin + ":" + map.get(pin));
				pin++;
			}
		}
	}

}
