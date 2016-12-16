package gui;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;

/*49*/
class ServerInfo {
    private String name;
    private int id;

    ServerInfo(String name,
               int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}



/**
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

                if(userObject instanceof ServerInfo){
                    int id = ((ServerInfo)userObject).getId();

                    System.out.println("Got user object with ID: " + id);
                    /*In his example he gets rid of it and reformats
                    * the toString to print id and name but we use
                    * this instanceof keyword a lot at NISC to ID
                    * things like Layers. I'm not very familiar with
                    * this so it's good practice. I may remove this
                    * in future modules*/
                }

                /*How this work is a DefaultMutableTreeNode takes an
                * object as a parameter, like a String. I've made a
                * local class 'ServerInfo' that holds a String name
                * and an int id. So that the info can remain the same,
                * and the name can be changed in the future.
                *
                * Calling println on userObject calls my overrided
                * toString method.*/
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
        DefaultMutableTreeNode server1 = new DefaultMutableTreeNode(new ServerInfo("New York", 1));
        DefaultMutableTreeNode server2 = new DefaultMutableTreeNode(new ServerInfo("Boston", 2));
        DefaultMutableTreeNode server3 = new DefaultMutableTreeNode(new ServerInfo("Los Angeles", 3));

        /*Leaves*/
        branch1.add(server1);
        branch1.add(server2);
        branch1.add(server3);

        DefaultMutableTreeNode branch2 = new DefaultMutableTreeNode("UK");
        DefaultMutableTreeNode server4 = new DefaultMutableTreeNode(new ServerInfo("London", 4));
        DefaultMutableTreeNode server5 = new DefaultMutableTreeNode(new ServerInfo("Edinburgh", 5));

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
