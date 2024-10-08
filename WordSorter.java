import java.io.File;
import java.util.Scanner;
import java.util.ArrayList; 
public class WordSorter 
{// start class


	public static void main(String[] args) 
	{// start main

		boolean keepGoing= true; 
		Scanner in = new Scanner(System.in); 

		ArrayList<String>[] wordList =  new ArrayList[26];

		for(int x =0;x<26;x++){// start for loop
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
			//System.out.println(word);
			word=word.toLowerCase();
			
			int curLocation= word.charAt(0)-97;
			boolean found = false;
			for (int x =0; x < wordList[curLocation].size();x++){
				if(word.equals(wordList[curLocation].get(x)))
					found= true;


			}// end for loop
			if(found == false )	
				wordList[curLocation].add(word);

		}// end while loop

		in = new Scanner(System.in); 

		while(keepGoing == true){
			System.out.println("Welcome!  You have the following options:");
			System.out.println("1- Print out all words starting with a specific letter");
			System.out.println("2- Print out all words");
			System.out.println("3- Print out the total number of unique words");
			System.out.println("4- Search and determine if a word is in the article");
			System.out.println("5- Remove a word from the data structure");
			System.out.println("6- Exit");
			System.out.println("Which type of conversion would you like to perform?");
			int decision = in.nextInt();
			in.nextLine();

			if(decision== 1)
				wordsWithLetter(wordList);
			else if(decision == 2)
				printAll(wordList);
			else if(decision == 3)
				printSize(wordList);
			else if(decision == 4)
				findWord(wordList);
			else if (decision == 5)
				removeWord(wordList);
			else{
				System.out.println("Thank you for coming");
				keepGoing= false;
			}
		}
	}

	public static void wordsWithLetter(ArrayList<String>[]array){
		Scanner in = new Scanner(System.in); 
		System.out.println("Please enter a letter");
		String inputLetter = in.nextLine();
		int currentLocation = inputLetter.charAt(0)-97;
		if(array[currentLocation].size()>0){
			for(int x =0;x<array[currentLocation].size();x++){
				System.out.println(array[currentLocation].get(x));
			}
		}
		else 
			System.out.println("no words for this letter");
	}



	public static void printSize(ArrayList<String>[]array){
		int total=0;
		for(int x =0 ;x<array.length ; x++){// start for
			total+=array[x].size();
		}// end for

		if(total>0)
			System.out.println("There are "+ total+ " unique words in the article” or “Empty List”  " );
		else 
			System.out.println( "Empty List" );

	}



	public static void printAll(ArrayList<String>[]array){
		int count=0;
		for(int x =0 ;x<array.length ; x++){// start for
			for(int y =0 ;y<array[x].size() ; y++)
				System.out.println(array[x].get(y));
		}
		if (count !=0)
			System.out.println("Empty List");

	}



	public static void findWord(ArrayList<String>[]array){
		Scanner in = new Scanner(System.in); 
		System.out.println("Please enter a single word with no symbols that you want to search for:");
		String userW = in.nextLine();
		boolean found = false;
		int currLoco= userW.charAt(0)-97;

		for (int x =0;x<array.length;x++)
			if(userW.equals(array[currLoco].get(x)))
				found= true;

		if(found == true)
			System.out.println("Word found in the article ");
		else 
			System.out.println("“Word NOT found in the article.”");

	}

	public static void removeWord(ArrayList<String>[]array){
		Scanner in = new Scanner(System.in); 
		System.out.println("Please enter a single word with no symbols that you want to remove:");
		String userRemove = in.nextLine();
		boolean removedWord = false;
		int curLo= userRemove.charAt(0)-97;

		for (int x =0;x<array.length;x++)
			if(userRemove.equals(array[curLo].get(x))){
				array[curLo].remove(x);
				removedWord = true;
			}

		if(removedWord == true)
			System.out.println( "Word successfully removed from the list" );
		else 
			System.out.println( "Word NOT found in the article.");

	}














}