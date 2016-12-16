package gui;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;

/**
 * Accidentally wrote all of 48 in here
 *
 * Created by everduin on 12/16/2016.
 */
public class MessagePanel extends JPanel {

    private JTree serverTree;

    public MessagePanel() {

        /*Tree consists of leaves and nodes (They're all default mutable tree nodes)*/
        serverTree = new JTree(createTree());

        /*Set selection mode on the selection model -
        * which allows you to only select one at
        * a time. No CTRL + Click to multi-select*/
        serverTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        /*Could have MessagePanel implement TreeSelectionListener
        * or just create an anonymous class like this*/
        serverTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                /*Called everytime someone selects a node
                * in the tree*/

                /*This works because our tree is made up of
                * DefaultMutableTreeNodes (Hence the safe
                * type casting without any checks)
                * Because we know every value on value
                * change will be a DefaultMutableTreeNode*/
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) serverTree.getLastSelectedPathComponent();

                /*This is whatever you pass to the ctor
                * of DefaultMutableTreeNode*/
                Object userObject = node.getUserObject();

                System.out.println(userObject);
            }
        });

        setLayout(new BorderLayout());

        add(new JScrollPane(serverTree), BorderLayout.CENTER);
    }

    /*Good lesson on building up a tree*/
    private DefaultMutableTreeNode createTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Servers");

        DefaultMutableTreeNode branch1 = new DefaultMutableTreeNode("USA");
        DefaultMutableTreeNode server1 = new DefaultMutableTreeNode("New york");
        DefaultMutableTreeNode server2 = new DefaultMutableTreeNode("Boston");
        DefaultMutableTreeNode server3 = new DefaultMutableTreeNode("Los Angeles");

        /*Leaves*/
        branch1.add(server1);
        branch1.add(server2);
        branch1.add(server3);

        DefaultMutableTreeNode branch2 = new DefaultMutableTreeNode("UK");
        DefaultMutableTreeNode server4 = new DefaultMutableTreeNode("London");
        DefaultMutableTreeNode server5 = new DefaultMutableTreeNode("Edinburgh");

        /*Leaves (Servers)*/
        branch2.add(server4);
        branch2.add(server5);

        /*Branches*/
        root.add(branch1);
        root.add(branch2);

        /*Root, some call this Top*/
        return root;
    }
}
