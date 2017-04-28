package gui;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

/**
 * Created by everduin on 12/21/2016.
 */
public class ServerTreeCellEditor extends AbstractCellEditor implements TreeCellEditor {

    /*These 3 methods call in sequence isCellEditable -> getTreeCellEditorComponent -> getCellEditorValue
    * - if isCellEditable is false, it stops there.
    * if true it keeps going up the list of methods
    */

    /*This will give me the correct colors*/
    private ServerTreeCellRenderer renderer;
    private JCheckBox checkBox;
    private ServerInfo info;

    public ServerTreeCellEditor() {
        renderer = new ServerTreeCellRenderer();
    }

    @Override
    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {

       /*First step get component: if leaf it's a checkbox, if not a leaf it's a String*/
        Component component = renderer.getTreeCellRendererComponent(tree, value, isSelected, expanded, leaf, row, true);

        if (leaf) {

            /*Part 2*/
            DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) value;
            info = (ServerInfo) treeNode.getUserObject();
            /*End small part 2*/

            /*Always a checkBox if it's a leaf*/
            checkBox = (JCheckBox) component;

            final ItemListener itemListener = new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    /*Will be called on checkbox click
                    * - Now go back to use the renderer
                    * and get the value from the checkbox*/

                    /*(53) This is the event we're now looking for
                    * instead of tree selection*/
                    fireEditingStopped();
                    checkBox.removeItemListener(this);
                    /*^^ this refers to the anonymous class*/
                }
            };


            checkBox.addItemListener(itemListener);
        }

        return component;
    }

    /*Only called if fireEditingStopped is called aboved to tell it when to stop*/
    @Override
    public Object getCellEditorValue() {
        /*We want to return a ServerInfo Object*/

        /*Get latest information from checkbox*/
        info.setChecked(checkBox.isSelected());
        return info;
    }

    @Override
    public boolean isCellEditable(EventObject event) {
        /*If you don't set this up properly, you're renderer
        * won't be use probably and you'll be editing everything*
        *
        * Note how pattern prevents nesting, constantly work through
        * criteria and at the end pass true or false if all criteria met/

        /*If someone doesn't click*/
        if (!(event instanceof MouseEvent)) {
            return false;
        }

        MouseEvent mouseEvent = (MouseEvent) event;

        JTree tree = (JTree) event.getSource();

        TreePath path = tree.getPathForLocation(mouseEvent.getX(), mouseEvent.getY());

        if (path == null) {
            return false; //Can't edit
        }

        Object lastComponent = path.getLastPathComponent();

        if (lastComponent == null) {
            return false;
        }

        DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) lastComponent;

        /*If it is leaf, let us edit. If it's not, don't edit.*/
        return treeNode.isLeaf();
    }
}
