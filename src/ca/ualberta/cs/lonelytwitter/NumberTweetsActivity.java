package ca.ualberta.cs.lonelytwitter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class NumberTweetsActivity extends LonelyTwitterActivity {
	private Integer numTweets = getNumTweets();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_number_tweets);
		
	}
	




}
