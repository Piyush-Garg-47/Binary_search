import java.util.ArrayList;

public class RootToPath {
    static class Node{
        int data ; 
        Node left ; 
        Node right ; 
        Node (int data){
           this .data = data ; 
           this.left = null ; 
           this .right = null ; 
        }
   }
   public static Node insert( Node root , int val ){
    if(root == null ){
         root = new Node(val );
         return root ; 
    }
    if(root.data > val ){
         // insert left 
          root .left  = insert(root.left , val) ; 
    }else {
         // insert right 
         root.right  = insert(root.right , val); 
    }
   return root ;    
}
public static void inorder (Node root ){
    if(root== null ){
         return ; 
    }
     inorder(root.left );
     System.out.print( root.data +" ");
     inorder(root.right );
}
   public static boolean getSearchkey(Node root  ,  int key ){
      if(root == null ){
         return  false ; 
      }
     if (root.data == key ){
         return true  ; 
     }
      if(root.data > key ){
        return   getSearchkey(root.left , key) ;
      }else {
        return   getSearchkey(root.right , key) ; 
      }
   }
   public static void printPath( ArrayList<Integer> path){
    for(int i =0 ; i <path.size() ; i++){
        System.out.print(path.get(i)+ "-> ");
    }
    System.out.println("null");
   }
   public static void printroot2leaf(Node root , ArrayList<Integer> path){
    if(root == null ){
         return ; 
    }
    path.add(root.data);
    if(root.left == null || root.right== null ){
         printPath(path); 
    }
    printroot2leaf(root.left , path);
    printroot2leaf(root.right, path);
    path.remove(path.size()-1);
   }
   public static void main(String[] args) {
    int values[] ={8, 5, 3, 1, 4, 6, 10, 11, 14};
    Node root = null ;
    int key = 8 ; 
    for (int i=0 ; i< values.length ; i++ ){
        root = insert(root,values[i]) ; 
   }
    inorder(root); 
    System.out.print(root + " ");
    if(getSearchkey(root, key)){
         System.out.println(" found ");
    }else {
        System.out.println(" not found ");
    }
    printroot2leaf(root,new  ArrayList<>());
}
}
