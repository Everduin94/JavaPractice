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