import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * This example introduces a new concept: scrollbars!
 *
 * @author Matthew Hertz
 */
public class ExampleC extends JFrame implements ActionListener {
  private JTextArea textBox;

  /** Create a new window in which to write the great American novel. */
  public ExampleC() {
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    JMenuItem saveMe = new JMenuItem("Save");
    saveMe.addActionListener(this);
    menuBar.add(saveMe);
    textBox = new JTextArea(1, 20);
    textBox.setLineWrap(false);
    textBox.setText("It was a dark and stormy night...");
    // Create the area with scroll bars in which we place the text
    // box.
    JScrollPane scroller = new JScrollPane();
    scroller.setViewportView(textBox);
    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    // Add it all to the Frame
    add(scroller);
  }

  /**
   * Run the example program that starts the day
   *
   * @param args Command-line arguments which we will ignore.
   */
  public static void main(String[] args) {
    ExampleC window = new ExampleC();
    // Finish setting up this window.
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setTitle("Full Example");
    window.pack();
    window.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    System.out.println(textBox.getText());
  }
}
