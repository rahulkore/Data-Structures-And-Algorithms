package DataStructures;

import java.util.ArrayList;
import java.util.List;


/**
 * Node having one data and two child which is pointed by two pointers left and right
 */
class Node {
    int data;
    Node left,right;

    Node(int ele){
        data = ele;
        left = null;
        right = null;
    }
}

/**
 * Head class having root which will point to the root of the 
 * BST (Binary Search Tree)
 */
class Head {
    Node root;
}
                                                                                                                                                                                                                                                                                                                                                                                  
public class BinarySearchTree {

    static Node father(Head h, Node p){
        Node q;
        if(p == h.root){
            return null;
        }
        q = h.root;
        while(q!=null){
            if(q.left == p || q.right == p){
                return q;
            }else{
                if(p.data < q.data){
                    q=q.left;
                }else{
                    q=q.right;
                }
            }
        }
        return null;
    }

    static Node findMax(Node r){
        if(r.right == null)
            return r;
        else return(findMax(r.right));
    }

    static boolean search(Head h, int ele){
        Node q = h.root;
        while(q!=null){
            if(q.data == ele){
                return true;
            }else{
                if(ele < q.data)
                    q=q.left;
                else 
                    q=q.right;
            }
        }
        return false;
    }

    static void insert(Head h, int ele){
        Node p = new Node(ele);
        if(h.root == null){
            h.root = p;
            return;
        }
        Node q = h.root;
        while(q!=null){
            if(ele <= q.data){
                if(q.left == null){
                    q.left = p;
                    return;
                }else{
                    q=q.left;
                }
            }else{
                if(q.right == null){
                    q.right = p;
                    return;
                }else{
                    q=q.right;
                }
            }
        }
        return;
    }

    /**
     * Delete function has three cases and we will go check one by one and implement the same.
     * 1] leaf node => root node
     *                 non root node
     * 2] has left 
     * 2] only right => root node
     *                  non root node
     * @param h
     * @param ele
     */
    static void delete(Head h, int ele){
        if(h.root == null){
            System.out.println("BST Empty");
            return;
        }
        Node q = h.root;
        /**
         * first we will find the element
         */
        while(q!=null){
            if(ele == q.data){
                break;
            }else{
                if(ele < q.data){
                    q=q.left;
                }else{
                    q=q.right;
                }
            }
        }
        /**
         * If not found then return
         */
        if(q==null){
            System.out.println("Element not found");
            return;
        }
        /**
         * Start : leaf node case beginn
         */
        if(q.left == null && q.right == null){
            //leaf node
            //check if root 
            if(h.root == q){
                h.root = null;
                return;
            }else{
                //non root
                Node f = father(h, q);
                if(f.left == q){
                    f.left = null;
                }else{
                    f.right = null;
                }
            }
            return;
        }
        /**
         * End : leaf node case
         */
         

         /**
          * Start : has left case
          */
        if(q.left != null){
            Node max = findMax(q.left);
            int val = max.data;
            delete(h, max.data);
            q.data = val;
            return;
        }
        /**
         * End : has left case
         */

        /**
         * Start : only right case
         */

        if(h.root == q){
            h.root = h.root.right;
            return;
        }else{
            Node f = father(h, q);
            if(f.left == q){
                f.left = q.right;
            }else{
                f.right = q.right;
            }
            return;
        }

        /**
         * End : only right case
         */
        
    }

    static void inorder(Node x){
        if(x != null){
            inorder(x.left);
            System.out.println(x.data);
            inorder(x.right);
        }
    }

    static void preorder(Node x){
        if(x != null){
            System.out.println(x.data);
            preorder(x.left);
            preorder(x.right);
        }
    }

    static void postorder(Node x){
        if(x != null){
            postorder(x.left);
            postorder(x.right);
            System.out.println(x.data);
        }
    }


    public static void main(String[] args) {

        Head h = new Head();
        h.root = null;
        int elements[]= {59,23,65,12,38,80,30,45,35};
        for (int i : elements) {
            insert(h, i);
        }
        System.out.println("Inorder");
        inorder(h.root);
        System.out.println("Preorder");
        preorder(h.root);
        System.out.println("PostOrder");
        postorder(h.root);
    }
                                                       
}
