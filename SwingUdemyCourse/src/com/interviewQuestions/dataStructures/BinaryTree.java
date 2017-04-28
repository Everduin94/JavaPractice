package com.interviewQuestions.dataStructures;

/**
 * Created by everduin on 12/2/2016.
 */
public class BinaryTree {

        // Root node pointer. Will be null for an empty tree.
        private Node root;

        /*
         --Node--
         The binary tree is built using this nested node class.
         Each node stores one data element, and has left and right
         sub-tree pointer which may be null.
         The node is a "dumb" nested class -- we just use it for
         storage; it does not have any methods.
        */
        private static class Node {
            Node left;
            Node right;
            int data;

            Node(int newData) {
                left = null;
                right = null;
                data = newData;
            }
        }

    public Node createNode(int rootData){
        Node root = new Node(5);
        return root;
    }

    public int solution(Node root){
        //Build a tree
        //root = new Node(5);
        root.left = new Node(3);
        //root.left.right = new Node(7);
        //root.right = new Node(6);
        //root.left.left = new node(1);

        if (root == null){
            return 1;
        } else {
            if (root.left != null && root.right != null){
                return 1 + Math.min(solution(root.left), solution(root.right));
            } else {
                return 1 + solution(root.right) + solution(root.left);
            }
        }
    }
}
