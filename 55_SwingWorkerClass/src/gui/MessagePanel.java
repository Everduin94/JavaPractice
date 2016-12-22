package gui;

import controller.MessageServer;
import model.Message;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static javafx.scene.input.KeyCode.T;

/**
 * (52) CustomCellEditors, 26 minutes long and referred to one of the more difficult tutorials.
 *
 * Created by everduin on 12/16/2016.
 */
public class MessagePanel extends JPanel {

    private JTree serverTree;
    private ServerTreeCellRenderer treeCellRenderer;
    private ServerTreeCellEditor treeCellEditor;

    private Set<Integer> selectedServers;
    private MessageServer messageServer;

    public MessagePanel() {

        messageServer = new MessageServer();

        selectedServers = new TreeSet<Integer>();
        selectedServers.add(0);
        selectedServers.add(1);


        /*Now we can set the icons*/
        /*51 - To Edit a cell you use editors
        * To view a cell you used renderers
        * - focusing on renderer for (51)*/
        treeCellRenderer = new ServerTreeCellRenderer();
        treeCellEditor = new ServerTreeCellEditor();

        /*Tree consists of leaves and nodes (They're all default mutable tree nodes)*/
        serverTree = new JTree(createTree());
        serverTree.setCellRenderer(treeCellRenderer);
        serverTree.setCellEditor(treeCellEditor);
        serverTree.setEditable(true);

        /*Set selection mode on the selection model -
        * which allows you to only select one at
        * a time. No CTRL + Click to multi-select*/
        serverTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

       /*Removed TreeSelectionListener - We care if it's checked, not selected (53)*/
        treeCellEditor.addCellEditorListener(new CellEditorListener() {
            @Override
            public void editingStopped(ChangeEvent e) {
                ServerInfo info = (ServerInfo) treeCellEditor.getCellEditorValue();
                System.out.println(info + ": " + info.getId() + ": " + info.isChecked());

                /*If we add it twice, it's fine. Sets only store unique values*/
                int serverId = info.getId();
                if(info.isChecked()) {
                    selectedServers.add(serverId);
                } else {
                    selectedServers.remove(serverId);
                }

                messageServer.setSelectedServers(selectedServers);


                retrieveMessages();
            }

            @Override
            public void editingCanceled(ChangeEvent e) {

            }
        });

        setLayout(new BorderLayout());

        add(new JScrollPane(serverTree), BorderLayout.CENTER);
    }

    /*Note - This throws a currentModificationException if you check a box before the
    * first box is finished!*/
    private void retrieveMessages(){

        System.out.println("Messages Waiting: " + messageServer.getMessageCount());

        /*Template class*/
        SwingWorker<List<Message>, Integer> worker = new SwingWorker<List<Message>, Integer>() {

            @Override
            protected List<Message> doInBackground() throws Exception {
                /*Code you want to run in a separate thread
                * SwingWorker will use available Swing thread
                * if all threads are being used. Then it will
                * queue code until it is available*/

                List<Message> retrieveMessages = new ArrayList<>();

                int count = 0;
                for(Message message : messageServer){
                    System.out.println(message.getTitle());

                    retrieveMessages.add(message);

                    count++;

                    /*Process will recieve whatever objects you publish
                    * You may publish many things quickly, so it's called
                    * on the main thread. Type that you specified in 2nd
                    * argument*/
                    publish(count);
                }

                return retrieveMessages;
            }

            @Override
            protected void process(List<Integer> counts) {
                /*For getting feedback from your swing worker*/

                /*Most recent value*/
                int retrieved = counts.get(counts.size() - 1);
                System.out.println("Got " + retrieved + " messages");
            }

            @Override
            protected void done() {
                try {
                    /*get() returns first type specified in worker*/
                    List<Message> retrievedMessages = get();
                    System.out.println("Retrived " + retrievedMessages.size() + " Messages.");
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

        };

        /*Run*/
        worker.execute();
    }

    /*Good lesson on building up a tree*/
    private DefaultMutableTreeNode createTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Servers");

        DefaultMutableTreeNode branch1 = new DefaultMutableTreeNode("USA");
        DefaultMutableTreeNode server1 = new DefaultMutableTreeNode(new ServerInfo("New York", 1, selectedServers.contains(0)));
        DefaultMutableTreeNode server2 = new DefaultMutableTreeNode(new ServerInfo("Boston", 2,  selectedServers.contains(1)));
        DefaultMutableTreeNode server3 = new DefaultMutableTreeNode(new ServerInfo("Los Angeles", 3,  selectedServers.contains(2)));

        /*Leaves*/
        branch1.add(server1);
        branch1.add(server2);
        branch1.add(server3);

        DefaultMutableTreeNode branch2 = new DefaultMutableTreeNode("UK");
        DefaultMutableTreeNode server4 = new DefaultMutableTreeNode(new ServerInfo("London", 4,  selectedServers.contains(3)));
        DefaultMutableTreeNode server5 = new DefaultMutableTreeNode(new ServerInfo("Edinburgh", 5,  selectedServers.contains(4)));

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
