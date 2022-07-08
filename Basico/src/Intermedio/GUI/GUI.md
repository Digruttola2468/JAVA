# TOP-Level Containers
Swing provides three generally useful top-level container classes: JFrame, JDialog, and JApplet.
Here's a picture of a frame created by an application. 
The frame contains a green menu bar (with no menus) and, in the frame's content pane, a large blank, yellow label.

![ConceptualPane](https://docs.oracle.com/javase/tutorial/figures/uiswing/components/ConceptualPane.gif)

You can find the entire source for this example in TopLevelDemo.java. 
Although the example uses a JFrame in a standalone application, the same concepts apply to JApplets and JDialogs.

### Adding Components to the Content Pane
`frame.getContentPane().add(yellowLabel, BorderLayout.CENTER);`

As the code shows, you find the content pane of a top-level container by calling the getContentPane method. 
The default content pane is a simple intermediate container that inherits from JComponent, and that uses a BorderLayout as its layout manager.

The `getContentPane` method returns a Container object, not a `JComponent` object. 
This means that if you want to take advantage of the content pane's `JComponent` features,
you need to either typecast the return value or create your own component to be the content pane.

**Note** that the default layout manager for `JPanel` is `FlowLayout`; you'll probably want to change it.

To make a component the content pane, use the top-level container's `setContentPane` method. For example:

```
//Create a panel and add components to it.
JPanel contentPane = new JPanel(new BorderLayout());
contentPane.setBorder(someBorder);
contentPane.add(someComponent, BorderLayout.CENTER);
contentPane.add(anotherComponent, BorderLayout.PAGE_END);

topLevelContainer.setContentPane(contentPane);
```

### The Root Pane
Each top-level container relies on a reclusive intermediate container called the root pane. 
The root pane manages the content pane and the menu bar, along with a couple of other containers. 
You generally don't need to know about root panes to use Swing components.
However, if you ever need to intercept mouse clicks or paint over multiple components, you should get acquainted with root panes.

![ui-rootPane](https://docs.oracle.com/javase/tutorial/figures/ui/ui-rootPane.gif)

he two other components that a root pane adds are a layered pane and a glass pane. 
The layered pane contains the menu bar and content pane, and enables Z-ordering of other components. 
The glass pane is often used to intercept input events occuring over the top-level container, and can also be used to paint over multiple components.

# JComponent
With the exception of top-level containers, all Swing components whose names begin with "J" descend from the JComponent class. 
For example, JPanel, JScrollPane, JButton, and JTable all inherit from JComponent. However, JFrame and JDialog don't because they implement top-level containers.

The `JComponent` class extends the `Container` class, which itself extends `Component`.
The Component class includes everything from providing layout hints to supporting painting and events. 
The Container class has support for adding components to the container and laying them out. 
This section's API tables summarize the most often used methods of Component and Container, as well as of JComponent.


# Dialog
A Dialog window is an independent sub window meant to carry temporary notice apart from the main Swing Application Window. Most Dialogs present an error message or warning to a user, but Dialogs can present images, directory trees, or just about anything compatible with the main Swing Application that manages them.

For convenience, several Swing component classes can directly instantiate and display dialogs. To create simple, standard dialogs, you use the JOptionPane class. The ProgressMonitor class can put up a dialog that shows the progress of an operation. Two other classes, JColorChooser and JFileChooser, also supply standard dialogs. To bring up a print dialog, you can use the Printing API. To create a custom dialog, use the JDialog class directly.

The code for simple dialogs can be minimal. For example, here is an informational dialog:

`JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");`
![](https://docs.oracle.com/javase/tutorial/figures/uiswing/components/InformationalDialogMetal.png)


# Layout Managers
- BorderLayout
- BoxLayout
- CardLayout
- FlowLayout
- GridBagLayout
- GridLayout
- GroupLayout
- SpringLayout

### BorderLayout
![](https://docs.oracle.com/javase/tutorial/figures/uiswing/layout/BorderLayoutDemo.png)
Every content pane is initialized to use a BorderLayout.
A BorderLayout places components in up to five areas: top, bottom, left, right, and center. All extra space is placed in the center area.

### BoxLayout
![](https://docs.oracle.com/javase/tutorial/figures/uiswing/layout/BoxLayoutDemo.png)
The BoxLayout class puts components in a single row or column. It respects the components' requested maximum sizes and also lets you align components

### CardLayout
![](https://docs.oracle.com/javase/tutorial/figures/uiswing/layout/CardLayoutDemo.png) ![](https://docs.oracle.com/javase/tutorial/figures/uiswing/layout/CardLayoutDemo-2.png)
The CardLayout class lets you implement an area that contains different components at different times. A CardLayout is often controlled by a combo box, with the state of the combo box determining which panel (group of components) the CardLayout displays.

### FlowLayout
![](https://docs.oracle.com/javase/tutorial/figures/uiswing/layout/FlowLayoutDemo.png)
FlowLayout is the default layout manager for every JPanel. It simply lays out components in a single row, starting a new row if its container is not sufficiently wide.

### GridBagLayour
![](https://docs.oracle.com/javase/tutorial/figures/uiswing/layout/GridBagLayoutDemo.png)
GridBagLayout is a sophisticated, flexible layout manager. It aligns components by placing them within a grid of cells, allowing components to span more than one cell. The rows in the grid can have different heights, and grid columns can have different widths.

### GridLayout
![](https://docs.oracle.com/javase/tutorial/figures/uiswing/layout/GridLayoutDemo.png)
GridLayout simply makes a bunch of components equal in size and displays them in the requested number of rows and columns.

### GroupLayout
![](https://docs.oracle.com/javase/tutorial/figures/uiswing/layout/find.png)
GroupLayout is a layout manager that was developed for use by GUI builder tools, but it can also be used manually. GroupLayout works with the horizontal and vertical layouts separately. The layout is defined for each dimension independently. Consequently, however, each component needs to be defined twice in the layout.

### SpringLayout
![](https://docs.oracle.com/javase/tutorial/figures/uiswing/layout/SpringBox.png)
![](https://docs.oracle.com/javase/tutorial/figures/uiswing/layout/SpringForm.png)
SpringLayout is a flexible layout manager designed for use by GUI builders. It lets you specify precise relationships between the edges of components under its control.









