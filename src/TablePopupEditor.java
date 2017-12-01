import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

/*
 * The editor button that brings up the dialog.
 */
//public class TablePopupEditor extends AbstractCellEditor
public class TablePopupEditor extends DefaultCellEditor implements TableCellEditor
{
  private PopupDialog popup;
  private String currentText = "";
  private JButton editorComponent;
  private JButton submitButton;

  public TablePopupEditor()
  {
    super(new JTextField());

    setClickCountToStart(1);

    //  Use a JButton as the editor component

    editorComponent = new JButton();
    editorComponent.setBackground(Color.white);
    editorComponent.setBorderPainted(false);
    editorComponent.setContentAreaFilled( false );

    // Make sure focus goes back to the table when the dialog is closed
    editorComponent.setFocusable( false );

    //  Set up the dialog where we do the actual editing

    popup = new PopupDialog();
  }

  public Object getCellEditorValue()
  {
    return currentText;
  }

  public Component getTableCellEditorComponent(JTable table,
                                               Object value,
                                               boolean isSelected,
                                               int row, int column) {

    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        popup.setText( currentText );
//              popup.setLocationRelativeTo( editorComponent );
        Point p = editorComponent.getLocationOnScreen();
        popup.setLocation(p.x, p.y + editorComponent.getSize().height);
        popup.show();
        fireEditingStopped();
      }
    });

    currentText = value.toString();
    editorComponent.setText( currentText );
    return editorComponent;
  }

  class PopupDialog extends JDialog implements ActionListener {
    private JTextArea textArea;

    public PopupDialog()
    {
      super((Frame)null, "Change Value", true);

      textArea = new JTextArea(5, 20);
      textArea.setLineWrap( true );
      textArea.setWrapStyleWord( true );
      KeyStroke keyStroke = KeyStroke.getKeyStroke("ENTER");
      textArea.getInputMap().put(keyStroke, "none");
      JScrollPane scrollPane = new JScrollPane( textArea );
      getContentPane().add( scrollPane );

      JButton cancel = new JButton("Cancel");
      cancel.addActionListener( this );
      JButton ok = new JButton("Ok");
      ok.setPreferredSize( cancel.getPreferredSize() );
      ok.addActionListener( this );

      JPanel buttons = new JPanel();
      buttons.add( ok );
      buttons.add( cancel );
      getContentPane().add(buttons, BorderLayout.SOUTH);
      pack();

      getRootPane().setDefaultButton( ok );
    }

    public void setText(String text)
    {
      textArea.setText( text );
    }

    /*
    *   Save the changed text before hiding the popup
    */
    public void actionPerformed(ActionEvent e)
    {
      if ("Ok".equals( e.getActionCommand() ) )
      {
        currentText = textArea.getText();
      }

      textArea.requestFocusInWindow();
      setVisible( false );
    }
  }

  public static void createAndShowUI()
  {
      JPanel panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

      JPanel subPanel1 = new JPanel();
      subPanel1.setLayout(new FlowLayout());
      panel.add(subPanel1);

      JButton submitButton = new JButton("Submit");

      subPanel1.add(submitButton);
      panel.add(subPanel1);

    String[] columnNames = {"Item", "F1", "F2", "F1"};
    Object[][] data =
            {
                    {"S1", "Feature 1", "Feature 2", "Feature 3"},
                    {"S2", "Feature 1", "Feature 2", "Feature 3"},
                    {"S3", "Feature 1", "Feature 2", "Feature 3"},
                    {"S4", "Feature 1", "Feature 2", "Feature 3"},
                    {"S5", "Feature 1", "Feature 2", "Feature 3"},

            };



    JTable table = new JTable(data, columnNames);
//    table.getColumnModel().getColumn(1).setPreferredWidth(300);
    table.setPreferredScrollableViewportSize(table.getPreferredSize());
    JScrollPane scrollPane = new JScrollPane(table);

    // Use the popup editor on the second column

    TablePopupEditor popupEditor = new TablePopupEditor();
    table.getColumnModel().getColumn(1).setCellEditor( popupEditor );
    table.getColumnModel().getColumn(2).setCellEditor( popupEditor );
    table.getColumnModel().getColumn(3).setCellEditor( popupEditor );


    JFrame frame = new JFrame("Popup Editor Test");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new JTextField(), BorderLayout.NORTH);
    frame.add( scrollPane );
    frame.pack();
    frame.setLocationRelativeTo( null );
    frame.setVisible(true);


  }

//  public static void main(String[] args)
//  {
//    EventQueue.invokeLater(new Runnable()
//    {
//      public void run()
//      {
//        createAndShowUI();
//      }
//    });
//  }


    public static void main(String[] args){


        createAndShowUI();
    }

}