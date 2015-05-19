package twitter;

import java.util.List;

import network.Network;

import org.junit.Test;

import textProcessing.Text2Net;
import textProcessing.TextCleaner;
import twitter4j.Status;
import twitter4j.TwitterException;

public class TweetFetcherTest {

	@Test
	public void test() {
		try {
			TweetFetcher.fetch();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testToNet() {
		try {
			List<Status> l = TweetFetcher.fetch();
			for (Status s:l){
				Network net = Text2Net.readSmallText(s.getText(), TextCleaner.smallTextCleaner,5);
				System.out.println(s.getText());
				System.out.println(net.getNodes());
				System.out.println(net);
				
			}
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
