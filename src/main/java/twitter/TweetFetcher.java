package twitter;

import java.util.List;

import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TweetFetcher {
	public static List<Status> fetch(int numOfTweet) throws TwitterException{

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("OmlRqWzwV8MYBYSrZgQVWBzDd")
		.setOAuthConsumerSecret("Sh4NvpdNeaMRbYXoG9VstyTyvoHxAZqR1F1eGdT7cRiaj0l0od")
		.setOAuthAccessToken("572754696-vZH5HFmeWBZ07aMpUrWP6knjjTfDF9m5nkB7qhDW")
		.setOAuthAccessTokenSecret("veSYHlTgezaBdCVbrjQMdELQ6GbcSK6uQ4X1RHEiUg00B");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();

		Query query = new Query().geoCode(new GeoLocation( 45.508669900000000000,-73.553992499999990000), 500.0, "km"); 
		query.count(numOfTweet); //You can also set the number of tweets to return per page, up to a max of 100
		QueryResult result = twitter.search(query);

		List<Status> statuses = result.getTweets();
//		for (Status s : statuses){
//			System.out.println((s.isTruncated()));
//			System.out.println(s.getText());
//			System.out.println(s.getLang());
//		}
		return statuses;
		


	}


}
