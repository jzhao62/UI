import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * For our last example class, we look at drawing pretty pictures on
 * the screen.
 *
 * @author Matthew Hertz
 */
public class ExampleG extends JFrame implements ActionListener {
  /** Create a panel on which we draw our animation */
  private AnimatorPanel drawHere;

  /** The color with which we draw our animation. */
  private Color color;

  /**
   * Create an instance of our example window. This will instantiate
   * the buttons and perform another of other actions.
   */
  public ExampleG() {
    color = Color.CYAN;
    // Create & add the buttons
    JButton redButton = new JButton("Red");
    redButton.addActionListener(new ButtonListener(Color.RED));
    add(BorderLayout.EAST, redButton);

    JButton blueButton = new JButton("Blue");
    blueButton.addActionListener(new ButtonListener(Color.BLUE));
    add(BorderLayout.WEST, blueButton);

    JButton greenButton = new JButton("Green");
    greenButton.addActionListener(new ButtonListener(Color.GREEN));
    add(BorderLayout.NORTH, greenButton);

    JButton startButton = new JButton("Start Your Engines");
    startButton.addActionListener(this);
    add(BorderLayout.SOUTH, startButton);

    // Create the panel in which we draw our animations
    drawHere = new AnimatorPanel();
    add(BorderLayout.CENTER, drawHere);
  }

  /**
   * Let's start animating!
   */
  public void actionPerformed(ActionEvent e) {
    // If we are starting our animations
      // Set a timer to go off periodically and drive our
      // animations.
      drawHere.drawMeNow = new Timer(50, drawHere);
      drawHere.drawMeNow.start();
  }

  /**
   * This inner-class defines actions common to all buttons. As an
   * inner-class it can automatically use anything in the outer
   * class, but cannot normally be used by any other object.
   *
   * @author Matthew Hertz
   */
  private class ButtonListener implements ActionListener {
    /** Color to use for this drawing. */
    private Color myColor;

    /**
     * Create a new button listener that will make label a specific
     * color.
     *
     * @param colorToUse Color to set label when the action occurs
     */
    public ButtonListener(Color colorToUse) {
      myColor = colorToUse;
    }

    /**
     * This method is required by ActionListener. It will be called
     * whenever an object to which we are listening generates an
     * event.
     *
     * @param arg0 Action event that has just been triggered.
     */
    public void actionPerformed(ActionEvent arg0) {
      color = myColor;
    }
  }

  /**
   * Inner-class that animates a circle of a given color.
   *
   * @author Matthew Hertz
   */
  private class AnimatorPanel extends JPanel implements ActionListener {
    private static final int WIDTH = 80;
    private static final int HEIGHT = 80;
    /** Change in x location that we will move the animation. */
    private int xOffset;
    /** Change in y location that we will move the animation. */
    private int yOffset;
    /** X location at which we draw the actual animation. */
    private int x;
    /** Y location at which we draw the actual animation. */
    private int y;
    /** Whether we should be animating anything. */
    private Timer drawMeNow;

    /**
     * Create a new panel instance.
     */
    public AnimatorPanel() {
      xOffset = 1;
      yOffset = 1;
    }

    /**
     * Update our drawing of the animation.
     *
     * @param g Graphic instance on which we draw the picture.
     */
    public void paintComponent(Graphics g) {
      if (drawMeNow != null) {
        g.setColor(getBackground());
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(color);
        x += xOffset;
        if ((x < 0) || (x > (getWidth()))) {
          xOffset *= -1;
        }
        y += yOffset;
        if ((y < 0) || (y > (getHeight()))) {
          yOffset *= -1;
        }
        g.fillOval(x, y, WIDTH, HEIGHT);
      }
    }

    /**
     * Let's start animating!
     */
    public void actionPerformed(ActionEvent e) {
      repaint();
    }
  }

  /**
   * Create the window on which we will draw our picture.
   *
   * @param args Command-line arguments which we will ignore.
   */
  public static void main(String[] args) {
    ExampleG window = new ExampleG();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(300, 300);
    window.setTitle("Tyin' it all together");
    window.setVisible(true);
  }
}