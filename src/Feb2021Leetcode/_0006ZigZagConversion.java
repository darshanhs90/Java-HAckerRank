package Feb2021Leetcode;

public class _0006ZigZagConversion {

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 2));
		System.out.println(convert("PAYPALISHIRING", 3));
		System.out.println(convert("PAYPALISHIRING", 4));
		System.out.println(convert("A", 1));
	}

	enum Direction {
		Up, Down
	}

	public static String convert(String s, int numRows) {
		if (numRows <= 1)
			return s;
		StringBuilder[] sb = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++) {
			sb[i] = new StringBuilder();
		}
		Direction currDir = Direction.Down;
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			sb[index].append(s.charAt(i));

			if (currDir == Direction.Down) {
				index++;
				if (index >= numRows) {
					index = numRows - 2;
					currDir = Direction.Up;
				}
			} else {
				index--;
				if (index < 0) {
					index = 1;
					currDir = Direction.Down;
				}
			}
		}

		StringBuilder out = new StringBuilder();
		for (int i = 0; i < sb.length; i++) {
			out.append(sb[i].toString());
		}
		return out.toString();

	}
}
