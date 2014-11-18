package ca.ualberta.cs.lonelytwitter.data;

import java.util.Date;

import android.util.Log;


public class ImportantTweet extends LonelyTweet {

	public ImportantTweet() {
	}
	
	public ImportantTweet(String text, Date date) {
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
		// Refactor #2: Chaged string name from ImportantString to importantString
		String importantString = "IMPORTANT: " + getTweetDate() + " | " + getTweetBody();
		Log.i("TAG", importantString);
		return importantString;
	}
	
	

}
