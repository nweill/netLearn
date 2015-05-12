package textProcessing;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import network.Network;

import org.junit.Assert;
import org.junit.Test;

public class Text2NetTest {

	@Test
	public void test() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("./src/test/resources/text.txt"));
			StringBuilder sb = new StringBuilder();
			String line = "";
			while ((line=br.readLine())!=null){
				sb.append(line+" ");
			}
			Network res = Text2Net.read(sb.toString(), TextCleaner.defaultTextCleaner);
			Assert.assertTrue(res.toString().equals("Net-N-742-E-2330"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
