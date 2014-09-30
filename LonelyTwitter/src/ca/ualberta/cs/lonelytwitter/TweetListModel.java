package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TweetListModel {
	private ArrayList<LonelyTweetModel> tweets;
	private Integer tweetCount = 0;

	public TweetListModel() {
		super();
		this.tweets = new ArrayList<LonelyTweetModel>();
	}
	
	public void add(LonelyTweetModel t) throws IllegalArgumentException {
		for (int i = 0; i < tweets.size(); i++){
			if (tweets.get(i).getText() == t.getText()) {
				throw new java.lang.IllegalArgumentException("Tried to add a duplicate tweet");
			}
		}
		tweets.add(t);
		
	}

	public boolean hasTweet(LonelyTweetModel t) {
		for (int i = 0; i < tweets.size(); i++){
			if (tweets.get(i).getText() == t.getText()) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<LonelyTweetModel> getTweets() {
		ArrayList<LonelyTweetModel> sortedTweets = tweets;
		Collections.sort(tweets, new Comparator<LonelyTweetModel>() {
			public int compare(LonelyTweetModel t, LonelyTweetModel t2) {
				return t.getTimestamp().compareTo(t2.getTimestamp());
			}			
		});
		return sortedTweets;
	}

	public void removeTweet(LonelyTweetModel t) {
		tweets.remove(t);
	}

	public int getCount() {
		tweetCount = tweets.size();
		return tweetCount;
	}

	
	
	
}
