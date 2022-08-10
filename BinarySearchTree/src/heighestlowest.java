
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sp20-bse-055
 */
public class heighestlowest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();
        Iterator<Integer> iter;
test.add(10);
        test.add(3);
        test.add(8);
        test.add(6);
        test.add(5);
        test.add(4);
        test.add(2);
        test.add(5);
        test.add(9);
         System.out.print("\nPreorder: \n");
 iter = test.getIterator(BSTInterface.Traversal.Preorder);
 while (iter.hasNext()){


            System.out.print("  "+iter.next()+"\n");

        }
        System.out.println("\n Lowest is ->"+test.min());
        System.out.println("\n Heighest is ->"+test.max());
        System.out.println(test.size());
    
}}
