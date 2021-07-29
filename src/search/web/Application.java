package search.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import spellcorrector.SpellCorrector;

public class Application {

	public static void main(String[] args) throws IOException {

		while (true) {
			System.out.println("Please choose an option from the list below");
			System.out.println("Choose 1 : Search a url");
			System.out.println("Choose 2 : Delete cache");
			System.out.println("Choose 3 : Rank the web pages according to the occurance of a word");
			System.out.println("Choose 4 : Words Suggestion");
			System.out.println("Choose 5 : Exit from program");

//		String url = "https://www.shiksha.com/";
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter your choice");
			int choice = sc.nextInt();
			sc = new Scanner(System.in);
			if (choice == 5) {
				break;
			}

			switch (choice) {
			case 0:
				System.out.println("please select a valid number");
				break;

			case 1:
				System.out.println("Please enter the url to be searched");
				String url = sc.nextLine();
				if (isValidUrl(url)) {
					if (!Cache.isAvailable(url)) {
						Crawler.crawlWeb(1, url, new ArrayList<String>());

					} else {
						System.out.println("This URL has already been crawled.");
					}

				} else {
					System.out.println("Please enter a valid url");
				}

				break;

			case 2:
				Cache.deleteCache();
				break;

			case 3:
				System.out.println("Please enter a word to be searched");
				FindWord.readAllFiles();
				break;
				
			case 4:
				System.out.println("Please enter a word to search");
				String sSearch = sc.nextLine();
				SpellCorrector corrector = new SpellCorrector();
				
				corrector.loadSpellCorrector();
				String suggestion = corrector.findSimilarWord(sSearch);
				
				if (suggestion.length() == 0) 
				    System.out.println("There are no similar words. Please enter the valid word to search");
				else
					System.out.println("Suggestion: " + suggestion);
				
			default:
				System.out.println("Please select a valid number");
				break;
			}
		}

	}

	private static boolean isValidUrl(String url) {
		if (Pattern.matches(Crawler.URL_PATTERN, url))
			return true;
		return false;
	}

}
