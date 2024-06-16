import java.util.ArrayList;

import org.w3c.dom.Node;

public class Merge {
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
   public static void getInorder(Node root , ArrayList<Integer> arr){
    if(root == null ){
        return  ; 
    }
    getInorder(root.left, arr);
    arr.add(root.data ); 
    getInorder(root.right, arr);
   }
   public static Node createBST(ArrayList<Integer>arr , int st , int end ){
    int mid = (st+end )/2 ;
    Node root = new Node(arr.get(mid )) ; 
    if(st > end ){
         return null ;
    }
   root.left =   createBST(arr, st, mid-1);
   root.right =  createBST(arr , mid+1 , end ); 
   return root ; 
   }
   public static Node MergeBST(Node root1 , Node root2){
    ArrayList<Integer> arr1 = new ArrayList<>();
    getInorder(root1, arr1);
    ArrayList<Integer> arr2 = new ArrayList<>();
    getInorder(root2 , arr2);
    // merge 2 bst 
    int i =0 , j =0 ; 
    ArrayList<Integer> Finalarr = new ArrayList<>() ; 
    while(i<arr1.size() && j<arr2.size()){
        if( arr1.get(i) <arr2.get(i)){
          Finalarr.add(arr1.get(i));
          i++;
        }else {
             Finalarr.add(arr2.get(j));
             j++ ; 
        }
    }
    while(i<arr1.size()){
        Finalarr.add(arr1.get(i));
        i++;
    }
    while(j<arr2.size()){
        Finalarr.add(arr2.get(j));
        j++ ; 
    }
    //sorted arraylist to balanced bst 
     return createBST(Finalarr, 0, Finalarr.size()-1 ) ; 
   }
   public static void preorder (Node root ){
    if(root== null ){
         return ; 
    }
    System.out.print( root.data +" ");
     preorder(root.left );
     preorder(root.right );
}
    public static void main(String[] args) {
     Node root1 = new Node (2 );
    root1.left  = new Node(1 );
    root1.right =new Node(4 );
    Node root2 = new Node ( 9);
    root2.left =new Node(3 );
    root2.right= new Node (12 ) ; 
    Node root = MergeBST(root1 , root2) ; 
    preorder(root);
}
}