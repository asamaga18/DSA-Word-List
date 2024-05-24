import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

class Main {
public static void main(String[] args) {
  LList[] dictionary = new LList[197]; // declaring 197 LLists and one usedWords list
  LList usedWords = new LList();  // declare linked list for words not found in the dictionary

  
  try {
    // Declare scanner and file for common words list
    File myObj = new File("WordList.txt");  
    Scanner myReader = new Scanner(myObj);

    // loop through each line in WordList.txt
    while (myReader.hasNextLine()) {
      String data = myReader.next().toLowerCase();  // assign each line to 'data' variable
      String data1 = ""; // new variable of 'data' with only letters and apostrophe

      // Loop through each character in line
      for (int j = 0; j<data.length(); j++){//97-122
        // uses ascii values to eliminate characters
        if (((data.charAt(j)>=97)&&(data.charAt(j)<=122))){
          data1+=data.charAt(j);
        }
      }
      // finds key using hasher method
      int val = hasher(data1);
      // System.out.println(data1+" "+val);
        
      //System.out.println(data+ ": " +key);
      if (dictionary[val] == null)   // initializes linked list if empty
        dictionary[val] = new LList();
      dictionary[val].InsertAtHead(data1);  // inserts word into linked list
      //System.out.println(dictionary[val].getHead().getData() + " / " + val);
    }
    //System.out.println("-->"+ dictionary[105].getHead().getData()); //ascii for "i"
      
    myReader.close(); 
  } 
  catch (FileNotFoundException e) {  // detects if there is no file
    System.out.println("An error occurred.");
    e.printStackTrace();
  }

  try {  
    // declare scanner and file for text input
    File txtFile = new File ("textFile.txt");
    Scanner txtScan = new Scanner(txtFile);
    int amtWords = 0;
    // loops through each line of textFile.txt
    while (txtScan.hasNext()) {
      //if (txtScan.hasNext())
      //{
      //String line1 = txtScan.nextLine().toLowerCase();
      //LList txtList = new LList();
      //while()

      // assigns line to 'begInp' variable
      String begInp1 = txtScan.next();
      
      String begInp = begInp1.toLowerCase();
      String word = "";  // creates line with only letters 
      int counter = 0;
      
      for (int i = 0; i<begInp.length(); i++){//97-122
        // eliminates characters using ascii values
        
        if (((begInp.charAt(i)>=97)&&(begInp.charAt(i)<=122))||((begInp.charAt(i)>=48)&&(begInp.charAt(i)<=57))||begInp.charAt(i)==39){
          word+=begInp.charAt(i);//removes all ascii
          counter++; //checker for empty string
        } 
      }
      
      if (counter!=0)//doesnt run if empty string
      {
      // finds key using hasher method
      
        int val2 = hasher(word);
      // creates new list if empty
      if (dictionary[val2] == null)
        dictionary[val2] = new LList();
      
      if (dictionary[val2].Find(word)==null){//always null?
        if (usedWords.Find(word)==null){
          usedWords.InsertAtHead(word);
          amtWords++;
          // System.out.println(word+ "-"+val2+"-"+dictionary[val2].Find(word)+"-"+usedWords.getHead().getData());
        }//tester^
      }
            
      }
        

    //}
    
    }
    // final words print
    
    if (amtWords != 0){
      System.out.println("Words not found: \n");
      usedWords.PrintList(); 
    }//iterate through array
    else{System.out.println("All words have been found in the dictionary");}
    
  } 
  catch (FileNotFoundException e) {  //detects if no file is found 
    System.out.println("An error occurred.");
    e.printStackTrace();
  }
}

// method for finding hash key of each line
public static int hasher(String data){
  int key;
  // determine key when the line is one letter
  if (data.length() == 1){
    key = data.charAt(0) % 197;
  }
  // determine key when line is 2 to 4 characters long   
  else if(data.length()<=4){
    key = (data.charAt(0)*data.charAt(1)) % 197;
  }
  // determine key when line is more than 4 letters
  else{
    key = (data.charAt(0)*data.charAt(1) * data.charAt(data.length()-3)) % 197;
  }
  return key;
  }
}



//Checklist
//words with symbols inbetween are ignored