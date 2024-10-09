// Cesar Farieta 
//pd 3
//10/9/24
//In this program I get a file from the user and I sort, store all the words based off of the letter that they start with. Then I ask the user to pick one of 6 options these option all do different things. 
//To create this options I made them into methods which I just then called, depending on the input that they give me. The options are, Print out all words starting with a specific letter, the user would give me the letter. Print out all 
//words that are stored. Print out the total number of unique words user.  Search and determine if a word is in the article, the user would give me the word that they want me to look for. Remove a word from the list, the user would also 
//give me the word that they want me to remove from the listand finally they can exit the program.




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
		{// start while
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

		while(keepGoing == true){// start while
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
			else{// start else
				System.out.println("Thank you for coming");
				keepGoing= false;
			}// end else
		}// end while
	}// end main

	public static void wordsWithLetter(ArrayList<String>[]wordList){// start wordsWithLetter
		Scanner in = new Scanner(System.in); 
		System.out.println("Please enter a letter");
		String inputLetter = in.nextLine();
		int currentLocation = inputLetter.charAt(0)-97;
		if(wordList[currentLocation].size()>0){// start if
			for(int x =0;x<wordList[currentLocation].size();x++)
				System.out.println(wordList[currentLocation].get(x));
			
		}// end if
		else 
			System.out.println("no words for this letter");
	}// end wordWithLetter



	public static void printSize(ArrayList<String>[]wordList){// start printSize
		int total=0;
		for(int x =0 ;x<wordList.length ; x++){// start for
			total+=wordList[x].size();
		}// end for

		if(total>0)
			System.out.println("There are "+ total+ " unique words in the article" );
		else 
			System.out.println( "Empty List" );

	}// end printSize



	public static void printAll(ArrayList<String>[]wordList){// start printAll
		int count=0;
		String alpha="abcdefghijklmnopqrstuvwxyz";
		for(int x =0 ;x<wordList.length ; x++){// start for
			System.out.println("List for the letter " + alpha.charAt(x) + ":" );
			for(int y =0 ;y<wordList[x].size() ; y++)
				System.out.println(wordList[x].get(y));
					
		}//end for
		if (count !=0)
			System.out.println("Empty List");

	}// end PrintAll



	public static void findWord(ArrayList<String>[]wordList){// start findWord
		Scanner in = new Scanner(System.in);
		String alpha="abcdefghijklmnopqrstuvwxyz";
		System.out.println("Please enter a single word with no symbols that you want to search for:");
		String userW = in.nextLine();
		boolean found = false;
		ArrayList<String> temp = wordList[alpha.indexOf(userW.toLowerCase().charAt(0))];

		for (int x =0;x<temp.size();x++)
			if(temp.get(x).equals(userW))
				found= true;

		if(found == true)
			System.out.println("Word found in the article ");
		else 
			System.out.println("“Word NOT found in the article.”");

	}// end findWord

	public static void removeWord(ArrayList<String>[]wordList){//start removeWord
		Scanner in = new Scanner(System.in); 
		String alpha="abcdefghijklmnopqrstuvwxyz";
		System.out.println("Please enter a single word with no symbols that you want to remove:");
		String userRemove = in.nextLine();
		ArrayList<String> temp = wordList[alpha.indexOf(userRemove.toLowerCase().charAt(0))];
		boolean removedWord = false;
		int curLo= userRemove.charAt(0)-97;

		for (int x =0;x<temp.size();x++)
			if(temp.get(x).equals(userRemove)){// start if 
				temp.remove(x);
				removedWord = true;
				x--;
			}// end if

		if(removedWord == true)
			System.out.println( "Word successfully removed from the list" );
		else 
			System.out.println( "Word NOT found in the article.");

	}// end removeWord

}// end class