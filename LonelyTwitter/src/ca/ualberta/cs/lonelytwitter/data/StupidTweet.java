package ca.ualberta.cs.lonelytwitter.data;

import java.util.Date;

import android.util.Log;

public class StupidTweet extends LonelyTweet {

	public StupidTweet() {
		// TODO Auto-generated constructor stub
	}
	
	public StupidTweet(String text, Date date) {
		this.tweetDate = date;
		this.tweetBody = text;
	}

	@Override
	public boolean isValid() {
		if (tweetBody.trim().length() == 0
				|| tweetBody.trim().length() > 10) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		String stupidString = "STUPID: " + getTweetDate() + " | " + getTweetBody();
		Log.i("TAG", stupidString);
		return stupidString;
	}

}
