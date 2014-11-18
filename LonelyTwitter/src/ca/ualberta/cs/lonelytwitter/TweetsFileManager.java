package ca.ualberta.cs.lonelytwitter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import ca.ualberta.cs.lonelytwitter.data.LonelyTweet;

import android.content.Context;
import android.util.Log;

public class TweetsFileManager {

	private static final String FILENAME = "file.sav";
	private Context ctx;

	public TweetsFileManager(Context ctx) {
		this.ctx = ctx;
	}

	@SuppressWarnings("unchecked")
	public List<LonelyTweet> loadTweets() {
		List<LonelyTweet> tweets = new ArrayList<LonelyTweet>();

		try {
			FileInputStream fis = ctx.openFileInput(FILENAME);
			ObjectInputStream ois = new ObjectInputStream(fis);

			Object o = ois.readObject();

			tweets = isInstanceOf(tweets, o);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return tweets;
	}

	// Refactor #1: Extracted Method
	private List<LonelyTweet> isInstanceOf(List<LonelyTweet> tweets, Object o) {
		if (o instanceof ArrayList) {
			tweets = (ArrayList<LonelyTweet>) o;
		} else {
			Log.i("LonelyTwitter", "Error casting");
		}
		return tweets;
	}

	public void saveTweets(List<LonelyTweet> tweets) {
		try {
			FileOutputStream fos = ctx.openFileOutput(FILENAME, 0);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(tweets);

			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
