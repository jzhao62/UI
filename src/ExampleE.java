import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This examines the possibility that we combine layout managers.
 *
 * @author Matthew Hertz
 */
public class ExampleE extends JFrame implements ActionListener {
  /** The button to make things red. */
  private JButton redButton;

  /** The button to make things green. */
  private JButton greenButton;

  /** The button to make things green. */
  private JButton blueButton;

  /** The button to make things cyan. */
  private JButton cyanButton;

  /** The button to make things green. */
  private JButton orangeButton;

  /** The button to make things green. */
  private JButton pinkButton;

  /** The text for our screen. */
  private JLabel label;

  /**
   * Create a new window containing the button.
   */
  public ExampleE() {
    // Create the panel and give it a BoxLayout manager.
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    // Create two sub-panels and add them to the main panel
    JPanel subPanel1 = new JPanel();
    subPanel1.setLayout(new FlowLayout());
    panel.add(subPanel1);
    //add(subPanel1, BorderLayout.NORTH);
    // Question: what if we add the subpanel directly to the JFrame?

    JPanel subPanel2 = new JPanel();
    subPanel2.setLayout(new FlowLayout());
    //add(subPanel2, BorderLayout.SOUTH);
    // Question: what if we add the subpanel directly to the JFrame?

    // Create & add the buttons
    redButton = new JButton("Red");
    redButton.addActionListener(this);

    greenButton = new JButton("Green");
    greenButton.addActionListener(this);

    blueButton = new JButton("Blue");
    blueButton.addActionListener(this);

    // Create & add the buttons
    cyanButton = new JButton("Cyan");
    cyanButton.addActionListener(this);

    orangeButton = new JButton("Orange");
    orangeButton.addActionListener(this);

    pinkButton = new JButton("Pink");
    pinkButton.addActionListener(this);

    // Create the label and add it to the panel.
    label = new JLabel("I hold text");

    // Add things to the various panels
    subPanel1.add(redButton);
    subPanel1.add(greenButton);
    subPanel1.add(blueButton);
    subPanel2.add(cyanButton);
    subPanel2.add(orangeButton);
    subPanel2.add(pinkButton);
    panel.add(subPanel1);
    panel.add(subPanel2);
    panel.add(label);
    add(panel, BorderLayout.CENTER);
  }

  /**
   * This method is required by ActionListener. It will be called
   * whenever an object to which we are listening generates an
   * event.
   *
   * @param arg0 Action event that has just been triggered.
   */
  public void actionPerformed(ActionEvent arg0) {
    // If this event was triggered by the button
    if (arg0.getSource() == redButton) {
      label.setForeground(Color.RED);
    } else if (arg0.getSource() == blueButton) {
      label.setForeground(Color.BLUE);
    } else if (arg0.getSource() == greenButton) {
      label.setForeground(Color.GREEN);
    } else if (arg0.getSource() == cyanButton) {
      label.setForeground(Color.CYAN);
    } else if (arg0.getSource() == orangeButton) {
      label.setForeground(Color.ORANGE);
    } else {
      label.setForeground(Color.PINK);
    }
  }

  /**
   * Create the window with all the buttons.
   *
   * @param args Command-line arguments which we will ignore.
   */
  public static void main(String[] args) {
    ExampleE example = new ExampleE();
    example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    example.setTitle("Boxy and Cool");
    example.pack();
    example.setVisible(true);
  }
}
