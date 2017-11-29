import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * Another way that we can display data in Java's MVC scheme. This splits components onto different tabs and will be
 * useful for later in this class. This is based on (and uses) code from Sun's Swing tutorial. The original can be found
 * here: <a href="http://java.sun.com/docs/books/tutorial/uiswing/examples/components/TabbedPaneDemoProject/src/components/TabbedPaneDemo.java"
 * >http://java.sun.com/docs/books/tutorial/uiswing/examples/components/TabbedPaneDemoProject/src/components/
 * TabbedPaneDemo.java</a>
 */
public class tab extends JFrame {
  /** Create the new instance of our class and get everything ready. */
  public tab() {
    JTabbedPane tabbedPane = new JTabbedPane();
    ImageIcon left = createImageIcon("left.gif");
    ImageIcon middle = createImageIcon("middle.gif");
    ImageIcon right = createImageIcon("right.gif");

    // Create the first tab that holds a JLabel
    JComponent label1 = new JLabel("<html><p style=\"color: red;\">Hi, Mom</p></html>");
    tabbedPane.addTab("Tab 1", left, label1, "Getting warmer");
    tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

    // Create the second tab that holds a JLabel
    JComponent label2 = new JLabel("Yay.");
    tabbedPane.addTab("Tab 2", middle, label2, "You found it!");
    tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

    // Create a third tab, but this one holds a JPanel
    JComponent panel = makeTextPanel("Oops.  Too far.");
    tabbedPane.addTab("Tab 3", right, panel, "Cold");
    tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
    // Add the tabbed pane to this panel.
    add(tabbedPane);

    // Create a third tab, but this one holds a JPanel
    JComponent panel2 = makeTextPanel("Wow.  You are dumb.");
    tabbedPane.addTab("Tab 4", null, panel2, "Hertz has more of a clue than you.");
    tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
    // Add the tabbed pane to this panel.
    add(tabbedPane);

    // The following line enables to use scrolling tabs.
    tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
  }

  /**
   * Returns an ImageIcon, or null if the path was invalid.
   * 
   * @param path Name of the file which we wish to display
   * @return ImageIcon instance for this image or null if it could not be loaded.
   */
  private static ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = tab.class.getResource("images/"+path);
    if (imgURL != null) {
      return new ImageIcon(imgURL);
    } else {
      System.err.println("Couldn't find file: " + path);
      return null;
    }
  }

  /**
   * Run our program.
   * 
   * @param args Ignored.
   */
  public static void main(String[] args) {
    // Create the JFrame that we will use for our display
    JFrame frame = new tab();
    // Now set up this frame.
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  /**
   * Create a panel which holds a JLabel that contains the given String.
   * 
   * @param text String to display on the JPanel which we create.
   * @return JPanel containing a JLabel displaying this String.
   */
  private JPanel makeTextPanel(String text) {
    JPanel retVal = new JPanel();
    retVal.add(new JLabel(text));
    return retVal;
  }
}
