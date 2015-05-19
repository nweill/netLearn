package main;

import java.util.HashSet;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import fingerPrint.Distribution;
import fingerPrint.Entropy;
import algo.CentralityMetrics;
import network.Network;
import textProcessing.Text2Net;
import textProcessing.TextCleaner;
import twitter.TweetFetcher;
import twitter4j.Status;
import twitter4j.TwitterException;

public class TweetToFP {

	public static void main(String[] args) {
		try {
			List<Status> tweets = TweetFetcher.fetch(100);
			HashSet<Integer> memory = Sets.newHashSet();
			for (Status s : tweets){
				List<Double> FP = Lists.newArrayList();
				
				memory.add(s.getText().hashCode());
			
				Network net = Text2Net.readSmallText(s.getText(), TextCleaner.smallTextCleaner, 5);
				
				List<Double> betCen = CentralityMetrics.getBetweenesCentrality(net);
				List<Double> degs = CentralityMetrics.getDegrees(net);

				Distribution d = new Distribution(betCen,Distribution.generateBeans(betCen,20), false);
				List<Double> distBetCen = d.getDistribution();

				d = new Distribution(degs,Distribution.generateBeans(degs,20), false);
				List<Double> distDegs = d.getDistribution();

				FP.addAll(distBetCen);
				FP.add(Entropy.entropyOf(distBetCen, false));
				FP.addAll(distDegs);
				FP.add(Entropy.entropyOf(distDegs,false));
				System.out.println("TWEET = "+s.getText());
				System.out.println(s.getRetweetCount());
				System.out.println(s.getRetweetedStatus()!=null);
				System.out.println(s.getId());
				System.out.println("NODES = "+ net.getNodes());
				System.out.println("NET = "+net);

				System.out.println("BETCEN = " + betCen);
				System.out.println("BETCENDIST = " + distBetCen);
				System.out.println("DEGS = " + degs);
				System.out.println("DEGDIST = " + distDegs);
				System.out.println("FP = "+FP.size() +" "+FP);
			}

		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
