import java.util.Scanner;

public class Submission { 

    public static class Node { 
        int key; 
        Node left, right; 
        int counter = 1;
        public Node(int data){ 
            key = data; 
            left = right = null; 
            
        } 
    } 

    static Node root; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int response = 0;

        while (scanner.hasNextInt()) {
            response = scanner.nextInt();
            if (response == 1) {
                insert(scanner.nextInt());
            }
            if (response == 2) {
                search(scanner.nextInt());
            }
            if (response == 3) {
                maxV();
            }
            if (response == 4) {
                minV();
            }
            if (response == 5) {
                preorder();
        
            }
            if (response == 6) {
                postorder();
            }
            if (response == 7) {
                inorder();
            }
            if (response == 8) {
                deleteKey(scanner.nextInt());
            }
            if (response == 0) {
                break;
            }

        }

    }

    Submission(){ 
        root = null; 
    } 

    public static void deleteKey(int key) { 
        root = delete_Recursive(root, key); 
    } 

    private static Node delete_Recursive(Node root, int key)  { 
        if (root == null)  

            return root; 

        if (key < root.key)    
            root.left = delete_Recursive(root.left, key); 
        else if (key > root.key) 
            root.right = delete_Recursive(root.right, key); 
        else  { 

            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 

            root.key = minValue(root.right); 

            root.right = delete_Recursive(root.right, root.key); 
            root.counter--;            
        } 
        return root; 
    } 

    public static int minValue(Node root)  { 
        if(root == null){
            System.out.print("0(0)");
            return 0;
           
        }
        if (root.left != null) {
        minValue(root.left);
        return root.key;
    }
    search(root.key);
    return (root.key);
    } 

    public static void maxV(){

        maxValue(root);   
    }

    public static void minV(){

        minValue(root);   
    }

    public static int maxValue(Node root)  { 
       
        if(root == null){
            System.out.print("0(0)");
            return 0;
           
        }
        if(root.right != null) {
            maxValue(root.right);
            return root.key;
        } 
        search(root.key);
        return root.key;
    }

    public static void insert(int key)  { 
        root = insert_Recursive(root, key); 
    } 

    private static Node insert_Recursive(Node root, int key) { 
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
        if (key == root.key) {
            root.counter++;
        }
        else if (key < root.key) {    
            root.left = insert_Recursive(root.left, key); 
        }
        else {    
            root.right = insert_Recursive(root.right, key); 
        }
        return root; 
    } 

    public static void inorder() { 
        inorder_Recursive(root); 
    } 

    private static void inorder_Recursive(Node root) { 
        if (root != null) { 
            inorder_Recursive(root.left); 
            search(root.key); 
            inorder_Recursive(root.right); 
        } 
    } 

    public static void preorder() { 
        preorder_Recursive(root); 
    } 

    private static void preorder_Recursive(Node root) { 
        if (root != null) { 
            search(root.key);
            preorder_Recursive(root.left); 
            preorder_Recursive(root.right); 
        } 
    } 

    public static void postorder() { 
        postorder_Recursive(root); 
    } 

    private static void postorder_Recursive(Node root) { 
        if (root != null) { 
            postorder_Recursive(root.left); 
            postorder_Recursive(root.right); 
            search(root.key);
        } 
    } 

    public static void search(int key)  { 
        search_Recursive(root, key); 
    } 

    private static void search_Recursive(Node root, int key)  { 
        if (root==null) {
            System.out.print(key + "(0)");
            return;
        }

        if (root.key == key) {
            System.out.print(root.key + "(" + root.counter + ")");
        }
        else if (root.key > key) {
            search_Recursive(root.left, key);
        }
        else {
            search_Recursive(root.right, key); 
        }
    } 

}