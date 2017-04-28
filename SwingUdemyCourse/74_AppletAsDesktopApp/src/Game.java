import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

/**
 * Created by everduin on 1/24/2017.
 */
public class Game extends JComponent {

    private Ellipse2D.Double ball = new Ellipse2D.Double(100, 100, 15, 15);

    private RoundRectangle2D.Double bat = new RoundRectangle2D.Double(200, 200, 100, 10, 20, 20);

    private double speed = 10.0;
    private int xDirectionBall = 1;
    private int yDirectionBall = 1;
    private double batSpeed = 10.0;

    private BufferedImage buffer;

    private boolean checkIntersection = true; //prevent ball from getting stuck

    public Game() {
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                bat.x = e.getX() - bat.getWidth() / 2; //bat position is equal to the mouse position
                bat.y = e.getY() - bat.getHeight() / 2;
                //The - bat.getWidth() / 2 stuff is so the mouse is in the center and not the edge
            }
        });

        /*Mouse Adapter abstract class, so we don't have to implement all methods of MouseListener*/
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ball.x = e.getX();
                ball.y = e.getY(); //Sends the ball to the bat
            }
        });

        //This is still game(){} ctor




        /*Key Listeners (Global)*/
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
                new KeyEventDispatcher() {
                    @Override
                    public boolean dispatchKeyEvent(KeyEvent e) {
                        int key = e.getKeyCode();
                        switch (key) {
                            case KeyEvent.VK_UP:
                                bat.y -= batSpeed; //Screen redraws from the top
                                break;
                            case KeyEvent.VK_DOWN:
                                bat.y += batSpeed;
                                break;
                            case KeyEvent.VK_LEFT:
                                bat.x -= batSpeed;
                                break;
                            case KeyEvent.VK_RIGHT:
                                bat.x += batSpeed;
                                break;

                        }

                        return false;
                    }
                }
        );

         /*Detecting Component Resizes*/
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                buffer = null;
                /*We have a line in paint component,
                * that will resize the component
                * when the buffer is null*/
            }
        });

        //A Stand for Alpha which means there's transparency in the image
        Cursor hiddenCursor =
                getToolkit().createCustomCursor
                        (new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB), new Point(1, 1), "");
        setCursor(hiddenCursor);
    }

    @Override
    public void paintComponent(Graphics g) {
        /*g references Graphics2D object*/

        /*Creating a black background*/
        if (buffer == null) {
            buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        }

        Graphics2D g2 = (Graphics2D) buffer.getGraphics();
        //Graphics2D g2 = (Graphics2D) g; //This gives us extended capabilities, REMOVED FOR BUFFEREDIMAGE

        /*This is so the shapes are smooth*/
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());

        /*Drawing shapes, exploring the graphics API*/
        g2.setColor(Color.RED); //Red Sphere
        g2.fill(ball);
        g2.setColor(Color.BLUE); //Blue Rectangle
        g2.fill(bat);

        g.drawImage(buffer, 0, 0, null); //Last step to Double Buffering
    }

    /*Animation*/
    public void update() {

        /*Check if ball has gone off the edge - begin*/
        ball.x += xDirectionBall * speed;
        ball.y += yDirectionBall * speed;

        if (ball.x < 0) {
            xDirectionBall = 1; //Change direction of ball if it's moving left off screen
            ball.x = 0;
        } else if (ball.x > getWidth() - ball.getBounds().width) { //Prevent right hand edge from going off
            xDirectionBall = -1;
            ball.x = getWidth() - ball.getBounds().width;
        }

        if (ball.y < 0) {
            yDirectionBall = 1; //Change direction of ball if it's moving left off screen
            ball.y = 0;
        } else if (ball.y > getHeight() - ball.getBounds().height) { //Prevent right hand edge from going off
            yDirectionBall = -1;
            ball.y = getHeight() - ball.getBounds().height;
        }
        /*Check if ball has gone off the edge - end*/

        if(ball.intersects(bat.getBounds2D())) {
            if(checkIntersection){
                yDirectionBall = -yDirectionBall; //Reverse direction if it intersects the bat
                checkIntersection = false;
            }
        } else {
            checkIntersection = true; //Ball and bat are no longer intersecting
        }

        repaint(); //Tells Swing to call pain component at earliest opportunity

        /*Double Buffering - Explanation
        * Doing drawing to an offscreen image,
        * then when the offscreen image is complete,
        * you then draw that image on the screen.
        *
        * Without double buffering, it's being drawn while
        * on screen causing flickering*/

    }

    @Override
    public void update(Graphics g) {
        paint(g);
    } //This may or may not, make your animation smoother. via not haivng two methods
    //updating a black background.
}
