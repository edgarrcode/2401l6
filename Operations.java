public class Operations {
  
  public static void main(String[] args){
    StringNode L=new StringNode("0"+getRandString(2+(int)(Math.random()*5)));
    StringNode temp = L;
    for (int i=1; i<=9;i++){
      temp.next=new StringNode(i+getRandString(2+(int)(Math.random()*5)));
      temp=temp.next;
    }
            
    System.out.println("All Strings in the list:");
    printMyList(L);
    System.out.println();
    
    boolean b = isListInOrder(L);
    System.out.println("List is ordered: "+b);
    System.out.println();    
    
    System.out.println("Count of k-length strings");    
    System.out.println("k\tNo. of Strings with length k");    
    for (int k=0; k<7; k++){
      System.out.println(k+"\t"+countKLenghthStrings(L, k));
    }
    
    System.out.println("Longest String="+longestStringOfMyList(L));
    System.out.println("Length="+lengthOfMyList(L));
    
    L=reverseMyList(L);
    System.out.println("All string in the reversed list:");
    printMyList(L);
    System.out.println();    
    
    
    System.out.println("Remove a given String");    
    StringNode LL=removeAStringFromMyList(L, L.next.next.head);
    System.out.println("All strings in the new list:");
    printMyList(LL);    
    System.out.println();    
    
    System.out.println("All strings in the previous list:");
    printMyList(L);
    System.out.println();    

    System.out.println("Insert a string in a position of the new list:");
    LL=insertAStringIntoMyList(LL, "Hello world", 3);
    printMyList(LL);    
    System.out.println();   
    
    b = isListInOrder(L);
    System.out.println("List is ordered: "+b);    
    System.out.println();   
    
    LL=insertAStringIntoMyList(LL, "ABBA", 3);
    LL=insertAStringIntoMyList(LL, "DoGeeseSeeGod", 3);    
        
    int c = countPalindromes(LL);
    System.out.println("Found "+c+" palindromes.");
    
  }
  
  static String getRandString(int length) {
    /* Write your code here */
    String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    String output = "";
    for (int i = 0; i < length; i++) {
        output = output + letters[(int)Math.round(Math.random() * 25)];
    }
    return output;
  }  
  
  
  /* Write a recursive method to print all the strings in separate lines.
  This method cannot contain any loop (that is, uses of for, while, do while 
  are prohibited).
  */  
  public static void printMyList(StringNode M){
    /* Write your code here */
    if (M == null) {
        return;
    }
    System.out.println(M.head);
    printMyList(M.next);
  }

  /* Write a recursive method to retrieve the number of strings that are longer
  than the length provided in the parameter. This method cannot contain any 
  loop (that is, uses of for, while, do while are prohibited).
  */    
  public static int countKLenghthStrings (StringNode M, int k){
    /* Write your code here */ 
    if (M == null) {
        return 0;
    }
    int counter = 0;
    if (M.head.length() == k) {
        counter++;
    }
    return counter  + countKLenghthStrings(M.next, k);
  }  
  
  /* Write a recursive method to retrieve the largest String from the list.
  Assume that there is at least one String in the given list when the method
  is called from the main function. This method cannot contain any loop (that 
  is, uses of for, while, do while are prohibited).
  */  
  public static String longestStringOfMyList (StringNode M){
    /* Write your code here */ 
    if (M == null) {
        return "Your list is empty!";
    }
    if (M.next == null) {
        return M.head;
    }

    String theLongestString = longestStringOfMyList(M.next);
    if (M.head.length() > theLongestString.length()) {
        return M.head;
    }
    return theLongestString;
  }    
  
  /* Write a recursive method to compute the length of a list.
  This method cannot contain any loop (that is, uses of for, while, do while 
  are prohibited).
  */  
  public static int lengthOfMyList (StringNode M){
    /* Write your code here */
    if (M == null) {
        return 0;
    }
    return 1 + lengthOfMyList(M.next);
  }    

  
  /* Write a recursive method named reverseMyList that will reverse a given 
  linked list M. Return the head of the reversed linked list. It is fine
  if you need to modify the given linked list to obtain the reversed one.
  */  
  public static StringNode reverseMyList (StringNode M){
    /* Write your code here */ 
    if (M == null) {
        return null;
    }
    if (M.next == null) {
        return M;
    }

    StringNode temp = M.next;
    M.next = null;

    StringNode theRestOfList = reverseMyList(temp);

    temp.next = M;

    return theRestOfList;        
  }        
  
  /* Write a recursive method to remove the first occurrence of a specific 
  String from a list. As an example, if your list initially contains 
  AA BB CC DD BB KK and if your removee is BB, the returned list should contain 
  AA CC DD BB KK after the removal. Return a new head. You must make sure that
  the parameter list remains intact after returning the new list to the main
  method. This method cannot contain any loop (that is, uses of for, while, 
  do-while are prohibited). 
  */  
  public static StringNode removeAStringFromMyList(StringNode M, String removee){
    /* Write your code here */
    if (M == null) {
        return null;
    }
    if (M.next == null) {
        return M;
    }

    StringNode tempNode = new StringNode(M.head);

    if (removee.equals(tempNode.head)) {
      tempNode = M.next;
      return removeAStringFromMyList(M.next, removee); 

    } else {
      StringNode theRestOfList = removeAStringFromMyList(M.next, removee);
      tempNode.next = theRestOfList;
      return tempNode;

    }
  }

  
  /* Write a recursive method to insert a String (insertee) into a specific 
  position of a list. Positions start from 0 (that is, the position of
  the head of a list is 0). This method cannot contain any loop (that is, 
  uses of for, while, do-while are prohibited). 
  */  
  public static StringNode insertAStringIntoMyList(StringNode M, String insertee, int position){
    /* Write your code here */
    if (M == null) {
        return null;
    }
    if (M.next == null) {
        return M;
    }
    if (position == 0) {
      StringNode inserteeStringNode = new StringNode(insertee);
      inserteeStringNode.next = M;
      M = inserteeStringNode;
    }
    position--;
    StringNode theRestOfList = insertAStringIntoMyList(M.next, insertee, position);
    
    return theRestOfList;
  }  
  
  /* Write a recursive method to verify if the strings are 
  lexicographically ordered in a linked list. Return true if they are 
  ordered, false otherwise. This method cannot contain any loop (that is, 
  uses of for, while, do-while are prohibited). 
  */ 
  public static boolean isListInOrder(StringNode M){
    /* Write your code here */
    if (M == null) {
      return true;
    }
    if (M.next == null) {
      return true;
    }
    int lexiResult = M.head.compareTo(M.next.head);
    boolean b = true;
    if (lexiResult > 0) {
      return false;
    }
    b = isListInOrder(M.next);
    return b;
  }
  
  /* Write a recursive method that will count how many strings of a given
  linked list are palindromes. The method must call another recursive 
  method named isPalindrome to verify if a String is a palindrome, or 
  not. Palindrome checks must NOT be case-sensitive. Neither countPalindromes 
  nor isPalindrome may contain loops (that is, uses of for, while, do-while 
  are prohibited).
  */
  public static int countPalindromes(StringNode M){
    /* Write your code here */
    if (M == null) {
        return 0;
    }

    if (isPalindrome(M.head)) {
        return 1 + countPalindromes(M.next);
    }
    return 0 + countPalindromes(M.next);

  }
  
  public static boolean isPalindrome(String s){
        /* Write your code here */
        // if string's length is 0 or 1 it is a palindrome
        if (s.length() == 0 || s.length() == 1) {
          return true;
        }

        // check first and last characters of string
        if (s.charAt(1) != s.charAt(s.length() - 1) ) {
          return false;
        }

        return isPalindrome(s.substring(1, s.length()-1));
  }
}

