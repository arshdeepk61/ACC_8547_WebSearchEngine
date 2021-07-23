package search.web;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class TextToHTML {
	
	public static void testfiles(String url) throws IOException
	{
		File dir = new File("TextFiles");
		if(!dir.exists())
		dir.mkdir();
    
		Document doc = Jsoup.connect(url).get();
		String location=null;
//		if (doc.title()!=null)
//		{
//			
//		 location ="TextFiles//"+doc.title()+".htm";
//		}
//		else
//		{
//		 location ="TextFiles//"+url+".htm";
//		}
		long name = System.currentTimeMillis();
        String loc =String.valueOf(name);
        
		location ="TextFiles//"+loc+".htm";
				
		//System.out.println("location "+location);
		File file3 = new File(location);
		

	//	System.out.println("file3 "+file3.toString());
		
		if(!file3.exists())
		file3.createNewFile();
		Elements element = doc.select("*");


		BufferedWriter filefinale = new BufferedWriter(new FileWriter(file3));
		for (Element e : element) {
			filefinale.write(e.ownText());
			filefinale.newLine();
		}

		filefinale.flush();
		filefinale.close();
		
	}

}
