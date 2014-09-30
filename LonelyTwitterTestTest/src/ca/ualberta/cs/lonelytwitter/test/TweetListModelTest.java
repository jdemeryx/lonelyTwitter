package ca.ualberta.cs.lonelytwitter.test;

import java.util.ArrayList;
import java.util.Date;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.TweetListModel;

public class TweetListModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
	public TweetListModelTest() {
		super(LonelyTwitterActivity.class);
	}

	public void testFiveIsFive() {
		assertEquals(5, 5);
	}
	
	public void testTweetListModel() {
		TweetListModel tlm = new TweetListModel();
	}
	
	public void testAdd() {
		LonelyTweetModel t = new LonelyTweetModel("Hello");
		TweetListModel tlm = new TweetListModel();
		tlm.add(t);


		assertTrue(tlm.hasTweet(t));
	}
	
	public void testDuplicateAdd() {
		try {
		LonelyTweetModel t = new LonelyTweetModel("Hello");
		LonelyTweetModel t2 = new LonelyTweetModel("Hello");
		TweetListModel tlm = new TweetListModel();
		tlm.add(t);
		tlm.add(t2);
		fail("Duplicate Tweet: Failed to add");
		} 
		catch (IllegalArgumentException e) {
			assertNotNull(e);
		}
	}
	
	public void testGetTweets() {
		LonelyTweetModel t = new LonelyTweetModel("Hello", new Date(99, 2, 1));
		LonelyTweetModel t2 = new LonelyTweetModel("Hello2", new Date(95, 2, 1));
		LonelyTweetModel t3 = new LonelyTweetModel("Hello3");
		TweetListModel tlm = new TweetListModel();
		tlm.add(t);
		tlm.add(t2);
		tlm.add(t3);
		ArrayList<LonelyTweetModel> test = new ArrayList<LonelyTweetModel>();
		test.add(t2);
		test.add(t);
		test.add(t3);
		ArrayList<LonelyTweetModel> tweetOrder = tlm.getTweets();
		assertEquals(test, tweetOrder);
	}
	
	public void testHasTweet() {
		LonelyTweetModel t = new LonelyTweetModel("Hello");
		LonelyTweetModel t2 = new LonelyTweetModel("Hello");
		TweetListModel tlm = new TweetListModel();
		tlm.add(t);
		assertTrue(tlm.hasTweet(t2));
		assertTrue(tlm.hasTweet(t));
	}
	
	public void testRemoveTweet() {
		LonelyTweetModel t = new LonelyTweetModel("Hello");
		LonelyTweetModel t2 = new LonelyTweetModel("Hello2");
		TweetListModel tlm = new TweetListModel();
		tlm.add(t);
		tlm.removeTweet(t);
		assertFalse(tlm.hasTweet(t));
	}
	
	public void testGetCount() {
		LonelyTweetModel t = new LonelyTweetModel("Hello");
		LonelyTweetModel t2 = new LonelyTweetModel("Hello2");
		TweetListModel tlm = new TweetListModel();
		tlm.add(t);
		tlm.add(t2);
		
		assert(tlm.getCount() == 2);
	}
}
