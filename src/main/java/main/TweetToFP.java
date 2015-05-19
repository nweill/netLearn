package main;

import io.FormatFP;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

	static int window=5; 
	static int numOfBeans = 20;
	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
			bw.write(FormatFP.getHeader(20*2+2+2, ",")+"\n");
			List<Status> tweets = TweetFetcher.fetch(100);
			HashSet<Integer> memory = Sets.newHashSet();
			for (Status s : tweets){
				List<Double> FP = Lists.newArrayList();
				
				memory.add(s.getText().hashCode());
			
				Network net = Text2Net.readSmallText(s.getText(), TextCleaner.smallTextCleaner, window);
				if (net.getNodes().size() < window*2)
					continue;
				
				List<Double> betCen = CentralityMetrics.getBetweenesCentrality(net);
				List<Double> degs = CentralityMetrics.getDegrees(net);

				System.out.println("TWEET = "+s.getText());
				System.out.println(s.getRetweetCount());
				System.out.println(s.getRetweetedStatus()!=null);
				System.out.println(s.getUser().getFollowersCount());
				System.out.println("NODES = "+ net.getNodes());
				System.out.println("NET = "+net);
				Distribution d = new Distribution(betCen,Distribution.generateBeans(betCen,numOfBeans), false);
				List<Double> distBetCen = d.getDistribution();

				d = new Distribution(degs,Distribution.generateBeans(degs,numOfBeans), false);
				List<Double> distDegs = d.getDistribution();
				FP.add(s.getText().hashCode()*1.0);
				FP.addAll(distBetCen);
				FP.add(Entropy.entropyOf(distBetCen, false));
				FP.addAll(distDegs);
				FP.add(Entropy.entropyOf(distDegs,false));
				FP.add(s.getUser().getFollowersCount()*1.0);

				System.out.println("BETCEN = " + betCen);
				System.out.println("BETCENDIST = " + distBetCen);
				System.out.println("DEGS = " + degs);
				System.out.println("DEGDIST = " + distDegs);
				System.out.println("FP = "+FP.size() +" "+FP);
				bw.write(FormatFP.list2String(FP, ",")+"\n");
			}
			bw.close();

		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
