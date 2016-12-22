General Notes:

Resources:
Google, WindowBuilder
Visual Guide Swing Components
Visual Guide to Swing Layout Managers
Docs.oracle.com - JavaDocs

Notes:

Layout Managers
- Decide where the components go
- Move them to appropriate locations
- etc...

Just finished Lesson 12
- Author refers to Swing Events and
GridBagLayout as the most complex elements.
- Everything else after this point is much
simpler.
- Don't waste time racking your brain over
the event handling
- Work on it a second and third time through,
using your own examples, at your own pace.


Lesson 11, Notes removed to stay organized
``` java
//GridBag is most complex and flexible
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 1;

        //Laying out components in a grid
        //0,0 is the top left
        gc.gridx = 0;
        gc.gridy = 0;

        //Weight controls how much space it takes
        //Relative to the other cells.

        //Whether to take up all the space in the cell
        gc.fill = GridBagConstraints.NONE;
        //Anchor determines how one cell is lined up with another cell
        gc.anchor = GridBagConstraints.LINE_END;
        //^^ Stick to right hand side of the cell
        add(nameLabel, gc);

        //gridy is still the same here,
        gc.gridy = 0; //This is just to keep track of whats happening
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);
        ```


```
/*Compiler suggests only need INFORMATION_MESSAGE
                * Still a good example on using pipes in a param*/
                String text = JOptionPane.showInputDialog(MainFrame.this,
                        "Enter your username",
                        "Enter Username",
                        JOptionPane.OK_OPTION | JOptionPane.INFORMATION_MESSAGE);


                System.out.println(text)
```


Things in the backend shouldn't reference the front end
(There should be no import gui in the back end)
(However the gui can import the model, but it generally communicates to the model through the controller)

Having all of these as packages in Intellij and not as directories is terrible.



26 Summary:
- We added an actionlistener on the ok button
in the class FormPanel
- clicking the ok button fires the action event
- That action event sets local var values to the
values in the Swing Components (I.E. JTextBox)
- After the values are set, a new FormEvent is
Initialized. Passed to the constructor are the
values from the Swing Components.

- We've created a FormListener Interface that
defines FormEventOccurred
- In the mainframe (local controller). We
create a setFormListener method that takes
a form listener as an argument
- Then we create an anonymous class for that
argument which defines formEventOccured
- That formEventOccured method then calls
controller.addPerson(e) passing in the
event as the object
- add person takes a FormEvent as an
argument and creates a new Person Object
(adds to the data model) from that data
and then adds that Person to the database
(Which is currently just an ArrayList).
- Then tablePanel (which was previously
just a textArea) has setData called on it
to set the data to controller.getPeople()
which gets all the People in the ArrayList

This is no doubt confusing and not a complete
explanation, so just work through it a few times
and don't wrack your brain on it.

**30** /*Similar to Action Listener
        * Explanation of steps:
        *
        * We wrote all the code here
        * before actually defining
        * the Interface and it's methods
        *
        * We created a new Interface
        * PersonTableListener
        *
        * We gave it one method
        * public void rowDeleted()
        *
        * We then went into the
        * TablePanel class and
        * created a new method
        * public void setPersonTableListener
        * (PersonTableListener listener) {}
        * and set this.personTableListener
        * equal to the parameter listener
        *
        * then we declared a private variable
        * private PersonTableListener
        * personTableListener in TablePanel
        * class so that the above method
        * would work
        *
        * Reminds me of TDD, Red -> Green -> Refactor*/

32) Spinners are specialized controls for entering numbers

34) Preferences. Author mentions properties are the old way,
also preferences aren't good for saving large amounts of data.

35) Added some explanation of whats a custom component and whats
from a java library, leaving this note here as I may remove them
later on, as they are quite clunky.

36/37) Setting up MySQL by myself wasn't bad at all

43 - http://www.oracle.com/technetwork/java/index-138612.html
 is a repository of button icons that can be used for development
 You can also make your own icons. This webpage loads, but
 the downloads button doesn't seem to work :/

 ^^ So Orcale has some sort of policy against 'Deep Linking'?
 I went through a link on stackoverflow and managed to download
 the jar


 53 - Removed tree selection listener
 ```java

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

 ```

