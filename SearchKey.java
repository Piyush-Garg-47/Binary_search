public class SearchKey {
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
   public static void main(String[] args) {
    int values[] = {5,1,3,4,2,7} ;
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
}
}

