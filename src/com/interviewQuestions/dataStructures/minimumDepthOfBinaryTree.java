package com.interviewQuestions.dataStructures;

import javax.swing.tree.TreeNode;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by everduin on 12/2/2016.
 */
public class minimumDepthOfBinaryTree {
    /*Given a binary tree, find it's minimum depth.
    * The minimum depth is the number of nodes along the shortest path
    * from the root node down to the nearest leaf node*/







    /*Thoughts from the editor
    *
    * Should be thinking recursion
    * What is the base or edge case? Empty tree.
    * What is the min depth of an empty tree? 0
    *
    * In the recursion step, the passed in TreeNode 'root' has been looked at.
    * 'root' is not null, which was covered in the base case.
    *
    * Then there are four sub-cases or combinations
    *
    * 1) root is a lea node. (root.left == null && root.right == null)
    * return 1
    *
    * 2) root.left == null && root.right != null. Then just recurse on the
    * right so we return 1 + minDepth(root.right)
    *
    * 3) root.left != null && root.right == null.
    * return 1 + minDepth(root.left)
    *
    * 4) root.left != null && root.right != null.
    * We don't know which branch has the shorter path
    * so return the minimum of these two.
    *
    * In code we can combine 4 cases into 2*/
}
