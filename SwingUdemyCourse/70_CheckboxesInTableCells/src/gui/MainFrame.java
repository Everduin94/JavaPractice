package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.prefs.Preferences;

public class MainFrame extends JFrame { //Custom JFrame, Local GUI Controller


    private Toolbar toolbar; //Custom JToolBar implements ActionListener
    private FormPanel formPanel; //Custom JPanel
    private JFileChooser fileChooser; //javax.swing extends JComponent implements Accessible
    private Controller controller; //Custom class
    private TablePanel tablePanel; //Custom JPanel
    private PrefsDialog prefsDialog; //Custom JDialog
    private Preferences prefs; // java.util.prefs (Abstract Class) written by Josh Bloch
    private JSplitPane splitPane;
    private JTabbedPane tabPane;
    private MessagePanel messagePanel;

    public MainFrame() {
        super("Swing Application");

        setLayout(new BorderLayout());

        toolbar = new Toolbar();
        formPanel = new FormPanel();
        tablePanel = new TablePanel();

        controller = new Controller();
        prefsDialog = new PrefsDialog(this); /*This = MainFrame*/
        messagePanel = new MessagePanel(this);

        /*Starting to add more layers to the gui of the application
        * that are becoming harder to follow because there's small
        * changes like instead of adding the form panel and the
        * table panel directly to Mainframe with add(). we now
        * add form panel and a tabpane to a split pane and then
        * add table panel into the tabpane*/
        tabPane = new JTabbedPane();

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, formPanel, tabPane);
        splitPane.setOneTouchExpandable(true); //Creates one click icons

        tabPane.addTab("Person Database", tablePanel);
        tabPane.addTab("Messages", messagePanel);

        /*Method work noting*/
        //tabPane.setTabComponentAt();

        /*Store information in nodes on OS*/
        prefs = Preferences.userRoot().node("db");

        tablePanel.setData(controller.getPeople());

        tablePanel.setPersonTableListener(new PersonTableListener() {
            @Override
            public void rowDeleted(int row) { //Defined (30)

                controller.removePerson(row);
            }
        });

        //Alternatively, Mainframe could implement Change Listener
        tabPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
//Called when tab is selected
                int tabIndex = tabPane.getSelectedIndex();
                /*Goal is to retrieve message on tab selection*/
                if (tabIndex == 1) {
                    messagePanel.refresh();
                }
            }
        });

        prefsDialog.setPrefsListener(new PrefsListener() {
            @Override
            public void preferencesSet(String user, String password, int port) {
                prefs.put("User", user);
                prefs.put("Password", password);
                prefs.putInt("Port", port);

                try {
                    controller.configure(port, user, password);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Unable to re-connect");
                }
            }
        });

        String user = prefs.get("User", "");
        String password = prefs.get("Password", "");
        int port = prefs.getInt("Port", 3306);
        prefsDialog.setDefaults(user, password, port);

        try {
            controller.configure(port, user, password);
        } catch (Exception e1) {
            System.err.println("Can't connect to the DB");
        }

        fileChooser = new JFileChooser();

        fileChooser.addChoosableFileFilter(new PersonFileFilter());

        setJMenuBar(createMenuBar());

        toolbar.setToolbarListener(new ToolbarListener() {

            @Override
            public void refreshEventOccured() {

                refresh();
            }

            @Override
            public void saveEventOccured() {

                connect();
                try {
                    controller.save();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Could not save to DB", "DB save fail",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });


    formPanel.setFormListener(new

    FormListener() {
        public void formEventOccurred (FormEvent e){
            controller.addPerson(e);
            tablePanel.refresh();
        }
    }

    );

    /*Window Closing Event so that no matter how I exit
    * the application, I'll disconnect from the DB*/
    addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing (WindowEvent e){
            controller.disconnect();
            dispose(); /*Quits automatically, running GC at the last possible moment*/
            System.gc(); /*Prevent thread interrupt Swing error*/
        }
    }

    );

    add(toolbar, BorderLayout.PAGE_START);

    add(splitPane, BorderLayout.CENTER);

        refresh(); //Added in Editable tables, to refresh whenever possible.

    setMinimumSize(new Dimension(500, 400)

    );

    setSize(600,500);

    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    setVisible(true);

}

    private void connect() {
        try {
            controller.connect();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(MainFrame.this, "Could not connect to DB", "DB connection fail",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    public void refresh() {
        try {
            controller.connect();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(MainFrame.this, "Could not connect to DB", "DB connect fail",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            controller.load();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(MainFrame.this, "Could not load from DB", "DB load fail",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        tablePanel.refresh();
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exportDataItem = new JMenuItem("Export Data...");
        JMenuItem importDataItem = new JMenuItem("Import Data...");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(exportDataItem);
        fileMenu.add(importDataItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu windowMenu = new JMenu("Window");
        JMenu showMenu = new JMenu("Show");
        JMenuItem prefsItem = new JMenuItem("Preferences...");

        JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
        showFormItem.setSelected(true);

        showMenu.add(showFormItem);
        windowMenu.add(showMenu);
        windowMenu.add(prefsItem);

        menuBar.add(fileMenu);
        menuBar.add(windowMenu);

        prefsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prefsDialog.setVisible(true);
            }
        });

        showFormItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) ev.getSource();

                /*Set size of divider to fix bug where re-showing form panel fails*/

                /*Clicking check box to show panel*/
                if (menuItem.isSelected()) {
                    /*Cast width to an int to get overloaded version of divider
                    * where it's setting the pixel from the left*/
                    splitPane.setDividerLocation((int) formPanel.getMinimumSize().getWidth());
                }
                formPanel.setVisible(menuItem.isSelected());
            }
        });

        fileMenu.setMnemonic(KeyEvent.VK_F);
        exitItem.setMnemonic(KeyEvent.VK_X);

        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
                ActionEvent.CTRL_MASK));
        importDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
                ActionEvent.CTRL_MASK));
        prefsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
                ActionEvent.CTRL_MASK));

        importDataItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.loadFromFile(fileChooser.getSelectedFile());
                        tablePanel.refresh();
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(MainFrame.this,
                                "Failed to load data from file",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        exportDataItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.saveToFile(fileChooser.getSelectedFile());
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(MainFrame.this,
                                "Failed to save data to file",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                int action = JOptionPane.showConfirmDialog(MainFrame.this,
                        "Do you really want to exit the application?",
                        "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);

                if (action == JOptionPane.OK_OPTION) {

                    WindowListener[] windowListeners = getWindowListeners();

                    for (WindowListener listener : windowListeners) {
                        listener.windowClosing(new WindowEvent(MainFrame.this, 0));
                    }
                }
            }
        });

        return menuBar;
    }
}