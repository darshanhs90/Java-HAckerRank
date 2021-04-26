package April2021PrepLeetcode;

public class _0032LongestValidParentheses {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("(()"));
		System.out.println(longestValidParentheses(")()())"));
		System.out.println(longestValidParentheses(")((()))"));
		System.out.println(longestValidParentheses(")((())())"));
		System.out.println(longestValidParentheses("()((())())"));
		System.out.println(longestValidParentheses(""));
	}

	public static int longestValidParentheses(String s) {
		if (s == null || s.length() < 2)
			return 0;
		int[] dp = new int[s.length()];
		int maxLength = 0;
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == ')') {
				if (s.charAt(i - 1) == '(') {
					if (i - 2 >= 0) {
						dp[i] = dp[i - 2] + 2;
					} else {
						dp[i] = 2;
					}
				} else {
					if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
						if (i - dp[i - 1] - 2 >= 0) {
							dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
						} else {
							dp[i] = dp[i - 1] + 2;
						}
					}
				}
			}
			maxLength = Math.max(maxLength, dp[i]);
		}
		return maxLength;
	}
}
