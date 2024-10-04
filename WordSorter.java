import java.io.File;
import java.util.Scanner;
import java.util.ArrayList; 
public class WordSorter 
{


	public static void main(String[] args) 
	{

		boolean keepGoing= true; 
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
			
			int curLocation= word.charAt(0)-97;
			boolean found = false;
			for (int x =0; x < wordList[curLocation].size();x++){
				if(word.equals(wordList[curLocation].get(x)))
					found= true;

				else 
					found = false;

			}// end for loop
			if(found = false )	
				wordList[curLocation].add(word);

		}// end while loop

		while(keepGoing == true){
			System.out.println("Welcome!  You have the following options:");
			System.out.println("1- Print out all words starting with a specific letter");
			System.out.println("2- Print out all words");
			System.out.println("3- Print out the total number of unique words");
			System.out.println("4- Search and determine if a word is in the article");
			System.out.println("5- Remove a word from the data structure");
			System.out.println("6- Exit");
			System.out.println("Which type of conversion would you like to perform?");
			int decision = myObj.nextInt();
			myObj.nextLine();

			if(decision== 1)
				wordsWithLetter();
			else if(decision == 2)
				printAll();
			else if(decision == 3)
				printSize();
			else if(decision == 4)
				findWord();
			else if (decision == 5)
				removeWord();
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

		for(int x =0;x<array.length;x++){

		}

		System.out.println(array[currentLocation]);

	}



	public static void printSize(){
		int total;

		for(){// start for


		}// end for





	}



	public static void printAll(){

	}



	public static void findWord(){

	}


	public static void binaryToDecimal(){

	}



	public static void removeWord(){

	}






















}