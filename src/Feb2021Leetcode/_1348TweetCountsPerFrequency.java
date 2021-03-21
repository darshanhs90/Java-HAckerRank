package Feb2021Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class _1348TweetCountsPerFrequency {
	public static void main(String[] args) {
		TweetCounts tweetCounts = new TweetCounts();
		tweetCounts.recordTweet("tweet3", 0);
		tweetCounts.recordTweet("tweet3", 60);
		tweetCounts.recordTweet("tweet3", 10); // All tweets correspond to "tweet3" with recorded times at 0, 10 and 60.
		System.out.println(tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59)); // return [2]. The
																								// frequency is per
																								// minute
		// (60 seconds), so there is one interval of
		// time: 1) [0, 60> - > 2 tweets.
		System.out.println(tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60)); // return [2, 1]. The
																								// frequency is per
																								// minute
		// (60 seconds), so there are two intervals
		// of time: 1) [0, 60> - > 2 tweets, and 2)
		// [60,61> - > 1 tweet.
		tweetCounts.recordTweet("tweet3", 120); // All tweets correspond to "tweet3" with recorded times at 0, 10, 60
												// and 120.
		System.out.println(tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210)); // return [4]. The
																								// frequency is per hour
																								// (3600
		// seconds), so there is one interval of
		// time: 1) [0, 211> - > 4 tweets.

	}

	static class TweetCounts {
		HashMap<String, TreeMap<Integer, Integer>> map;

		public TweetCounts() {
			map = new HashMap<String, TreeMap<Integer, Integer>>();
		}

		public void recordTweet(String tweetName, int time) {
			if (!map.containsKey(tweetName)) {
				map.put(tweetName, new TreeMap<Integer, Integer>());
			}
			map.get(tweetName).compute(time, (k, v) -> v == null ? 1 : v + 1);
		}

		public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {

			if (!map.containsKey(tweetName))
				return null;
			List<Integer> res = new LinkedList<>();

			int interval = 0, size = 0;
			if (freq.equals("minute")) {
				interval = 60;
			} else if (freq.equals("hour")) {
				interval = 3600;
			} else {
				interval = 86400;
			}
			size = ((endTime - startTime) / interval) + 1;

			int[] buckets = new int[size];

			TreeMap<Integer, Integer> tweetMap = map.get(tweetName);

			for (Map.Entry<Integer, Integer> entry : tweetMap.subMap(startTime, endTime + 1).entrySet()) {

				int index = (entry.getKey() - startTime) / interval;
				buckets[index] += entry.getValue();
			}

			for (int num : buckets)
				res.add(num);

			return res;
		}
	}

}
