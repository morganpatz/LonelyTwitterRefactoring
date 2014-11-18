package ca.ualberta.cs.lonelytwitter.data;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

public abstract class LonelyTweet {

	private static final long serialVersionUID = 1L;

	public abstract boolean isValid();
	

	@Override
	public abstract String toString();


	protected Date tweetDate;
	protected String tweetBody;

	public LonelyTweet() {
		super();
	}

	public Date getTweetDate() {
		return tweetDate;
	}

	public void setTweetDate(Date tweetDate) {
		this.tweetDate = tweetDate;
	}

	public String getTweetBody() {
		return tweetBody;
	}

	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.writeObject(tweetDate);
		out.writeObject(tweetBody);
	}

	private void readObject(java.io.ObjectInputStream in) throws IOException,
			ClassNotFoundException {
				tweetDate = (Date) in.readObject();
				tweetBody = (String) in.readObject();
			}

}