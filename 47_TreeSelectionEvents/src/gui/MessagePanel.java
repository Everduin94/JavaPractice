package gui;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

/**
 * Created by everduin on 12/16/2016.
 */
public class MessagePanel extends JPanel {

    private JTree serverTree;

    public MessagePanel() {

        /*Tree consists of leaves and nodes (They're all default mutable tree nodes)*/
        serverTree = new JTree(createTree());
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
