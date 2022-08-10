
import java.util.Iterator;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sp20-bse-055
 */
public class insertnumber {

    public static void main(String[] args) {
        BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();
        Iterator<Integer> iter;
//        test.add(5);
        test.add(10);
        test.add(3);
        test.add(8);
        test.add(6);
        test.add(5);
        test.add(4);
        test.add(2);
        test.add(5);
        test.add(9);
//        test.remove("B");
// Scanner scan = new Scanner(System.in);
//String a =scan.nextLine();
//test.add(a);
       System.out.print("\nPreorder: ");
 iter = test.getIterator(BSTInterface.Traversal.Preorder);
 while (iter.hasNext()){


            System.out.print("  "+iter.next());

        }

    }}

