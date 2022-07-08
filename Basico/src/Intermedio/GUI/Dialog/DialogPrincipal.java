package Intermedio.GUI.Dialog;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DialogPrincipal {
    public static void main(String[] args) {
        mostrarMensajesDialogs();
        opcionDialog();
        UserInputDialog();

        System.out.println();
        System.out.println();

        JOptionJDialog();
    }

    private static void JOptionJDialog(){
        JFrame frame = new JFrame("TITLE NOSE");

        //Constructor
        final JOptionPane optionPane = new JOptionPane(
                "The only way to close this dialog is by\n"
                        + "pressing one of the following buttons.\n"
                        + "Do you understand?",
                JOptionPane.QUESTION_MESSAGE,   //Icon
                JOptionPane.YES_NO_OPTION);     //Botones Yes or No

        final JDialog dialog = new JDialog(frame,
                "Click a button",
                true);
        dialog.setContentPane(optionPane);

        //Te bloquea para salir , si o si pulsar el boton
        dialog.setDefaultCloseOperation(
                JDialog.DO_NOTHING_ON_CLOSE);

        //Actuar en base si toco el boton x sin pulsar los botones
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.out.println("Thwarted user attempt to close window.");
            }
        });

        optionPane.addPropertyChangeListener(
                new PropertyChangeListener() {
                    public void propertyChange(PropertyChangeEvent e) {
                        String prop = e.getPropertyName();

                        if (dialog.isVisible()
                                && (e.getSource() == optionPane)
                                && (prop.equals(JOptionPane.VALUE_PROPERTY))) {
                            //If you were going to check something
                            //before closing the window, you'd do
                            //it here.
                            dialog.setVisible(false);
                        }
                    }
                });

        dialog.pack();
        dialog.setVisible(true);

        int value = (Integer) optionPane.getValue();
        if (value == JOptionPane.YES_OPTION) {
            System.out.println("Good.");
        } else if (value == JOptionPane.NO_OPTION) {
            System.out.println("Try using the window decorations "
                    + "to close the non-auto-closing dialog. "
                    + "You can't!");
        }
        System.exit(1);
    }

    private static void UserInputDialog(){
        Object[] possibilities = {"ham", "spam", "yam"};
        String comboBox = (String)JOptionPane.showInputDialog(
                null,
                "Complete the sentence:\n"
                        + "\"Green eggs and...\"",
                "Customized Dialog",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                "ham");

        String field = (String)JOptionPane.showInputDialog(
                null,
                "Complete the sentence:\n"
                        + "\"Green eggs and...\"",
                "Customized Dialog",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "ham");

        //If a string was returned, say so.
        if ((comboBox != null) && (comboBox.length() > 0)) {
            System.out.println("Green eggs and... " + comboBox + "!");
        }
        //If a string was returned, say so.
        if ((field != null) && (field.length() > 0)) {
            System.out.println("Green eggs and... " + field + "!");
        }

    }

    private static void opcionDialog(){
        //Custom button text
        Object[] options = {"Yes, please",
                "No, thanks",
                "No eggs, no ham!"};

        int n = JOptionPane.showOptionDialog(null,
                "Would you like some green eggs to go "
                        + "with that ham?",
                "A Silly Question",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);

        switch (n){
            case 1:
            case 2:
            case 3:
                System.out.println("Seleccionaste: " + options[n]);
                break;
        }
    }

    private static void mostrarMensajesDialogs(){
        //Custom
        JOptionPane.showMessageDialog(null,
                "Eggs are not supposed to be green.");

        //Custom title, Question icon
        JOptionPane.showMessageDialog(null,
                "Eggs are not supposed to be green.",
                "Inane warning",
                JOptionPane.QUESTION_MESSAGE);

        //Custom title, warning icon
        JOptionPane.showMessageDialog(null,
                "Eggs are not supposed to be green.",
                "Inane warning",
                JOptionPane.WARNING_MESSAGE);

        //Custom title, error icon
        JOptionPane.showMessageDialog(null,
                "Eggs are not supposed to be green.",
                "Inane error",
                JOptionPane.ERROR_MESSAGE);

        //custom title, no icon
        JOptionPane.showMessageDialog(null,
                "Eggs are not supposed to be green.",
                "A plain message",
                JOptionPane.PLAIN_MESSAGE);//No icon is used.

        //java.net.URL imgURL = CheckBoxDemo.class.getResource(path);
        java.net.URL imgURL = DialogPrincipal.class.getResource("images/Open16.gif");
        System.out.println(imgURL);
        ImageIcon icon = null;
        if (imgURL != null) {
             icon = new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file");
        }

        //Custom title, custom icon
        JOptionPane.showMessageDialog(null,
                "Eggs are not supposed to be green.",
                "Inane custom dialog",
                JOptionPane.INFORMATION_MESSAGE,
                icon);
    }
}
