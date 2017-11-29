import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Lets check out how layout managers work. This is the first layout manager: FlowLayout.
 *
 * @author Matthew Hertz
 */
public class ExampleAlmostD extends JFrame implements ActionListener {
  /** The button to make things red. */
  private JButton redButton;

  /** The button to make things green. */
  private JButton greenButton;

  /** The button to make things green. */
  private JButton blueButton;

  /** The text for our screen. */
  private JLabel label;

  /**
   * Create a new window containing the button.
   */
  public ExampleAlmostD() {
    // Create the add the buttons
    redButton = new JButton("Red");
    redButton.addActionListener(this);

    greenButton = new JButton("Green");
    greenButton.addActionListener(this);

    blueButton = new JButton("Blue");
    blueButton.addActionListener(this);

    // Create the label and add it to the panel.
    label = new JLabel("I hold text");

    // Add everything to the center of the window
    add(redButton,BorderLayout.CENTER);
    add(greenButton,BorderLayout.CENTER);
    add(blueButton,BorderLayout.CENTER);
    add(label,BorderLayout.CENTER);
    
    // What will we see? What will we click?
  }

  /**
   * Create the window with the differently laid out buttons.
   *
   * @param args Command-line arguments which we will ignore.
   */
  public static void main(String[] args) {
	ExampleAlmostD example = new ExampleAlmostD();
    example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    example.setTitle("Go With the Flow");
    example.pack();
    example.setVisible(true);
  }

  /**
   * This method is required by ActionListener. It will be called whenever an object to which
   * we are listening generates an event.
   *
   * @param arg0 Action event that has just been triggered.
   */
  public void actionPerformed(ActionEvent arg0) {
    // If this event was triggered by the button
    if (arg0.getSource() == redButton) {
      label.setForeground(Color.RED);
    } else if (arg0.getSource() == blueButton) {
      label.setForeground(Color.BLUE);
    } else {
      label.setForeground(Color.GREEN);
    }
  }
}
