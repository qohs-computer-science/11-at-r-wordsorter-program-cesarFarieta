import java.io.File;
import java.util.Scanner;
import java.util.ArrayList; 
public class WordSorter 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in); 

		ArrayList<String>[] wordList =  new ArrayList[26];

		for(int x =0;x<26;x++){
			wordList[x]=  new ArrayList<String>(); 
		}// end for loop



		try
		{
			in = new Scanner(new File("article.txt"));	
		}
		catch(Exception e)
		{
			System.out.println("Cannot find file... Exiting Program");
			return;
		}	




		String word = "";
		while(in.hasNext())
		{
			word = in.next();
			word = word.replace(",", "");
			word = word.replace("(tm)", "");
			word = word.replace(")", "");
			word = word.replace("(", "");
			word = word.replace(".", "");
			word = word.replace("'s", "");
			word = word.replace(":", "");
			word = word.replace("!", "");
			word = word.replace("?", "");
			word = word.replace("'", "");
			System.out.println(word);
			word=word.toLowerCase();
			
			
		}


		int location;

		for (int x =0 x < word.length();x++){
			location= word.charAt(x)-97;
			wordList[location].add(word);
		}// end for loop 
		


	}

//}