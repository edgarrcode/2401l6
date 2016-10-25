public class StringNode {
  public String head;
  public StringNode next;
  
  StringNode(){}
  
  StringNode(String s){
    head = s;
  }      

  StringNode(String s, StringNode tail){
    head = s;
    next=tail;
  }        
} 
