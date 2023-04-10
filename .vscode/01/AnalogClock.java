import java.awt.*;
import javax.swing.*;
import java.util.Calendar;

public class AnalogClock extends JPanel {
  private int radius;
  private int centerX;
  private int centerY;
  
  public AnalogClock(int radius) {
    this.radius = radius;
    this.centerX = radius;
    this.centerY = radius;
  }
 
  public static void main(String[] args) {
    JFrame frame = new JFrame("Analog Clock");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    frame.add(new AnalogClock(150));
    frame.setVisible(true);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    // Draw the clock face
    g.setColor(Color.BLACK);
    g.fillOval(0, 0, 2 * radius, 2 * radius);
    
    // Draw the hour marks
    for (int i = 0; i < 12; i++) {
      int x = (int)(centerX + radius * Math.sin(i * Math.PI / 6));
      int y = (int)(centerY - radius * Math.cos(i * Math.PI / 6));
      g.drawLine(centerX, centerY, x, y);
    }
    
    // Draw the hands of the clock
    int hourHandLength = (int)(radius * 0.5);
    int minuteHandLength = (int)(radius * 0.8);
    int secondHandLength = (int)(radius * 0.9);
    
    // Get the current time
    Calendar calendar = Calendar.getInstance();
    int hour = calendar.get(Calendar.HOUR);
    int minute = calendar.get(Calendar.MINUTE);
    int second = calendar.get(Calendar.SECOND);
    
    // Calculate the angles of the hands
    double hourAngle = (hour + minute / 60.0) * (2 * Math.PI / 12);
    double minuteAngle = (minute + second / 60.0) * (2 * Math.PI / 60);
    double secondAngle = second * (2 * Math.PI / 60);
    
    // Draw the hour hand
    int hourX = (int)(centerX + hourHandLength * Math.sin(hourAngle));
    int hourY = (int)(centerY - hourHandLength * Math.cos(hourAngle));
    g.setColor(Color.BLUE);
    g.drawLine(centerX, centerY, hourX, hourY);
    
    // Draw the minute hand
    int minuteX = (int)(centerX + minuteHandLength * Math.sin(minuteAngle));
    int minuteY = (int)(centerY - minuteHandLength * Math.cos(minuteAngle));
    g.setColor(Color.RED);
    g.drawLine(centerX, centerY, minuteX, minuteY);
    
    // Draw the second hand
    int secondX = (int)(centerX + secondHandLength * Math.sin(secondAngle));
    int secondY = (int)(centerY - secondHandLength * Math.cos(secondAngle));
    g.setColor(Color.GREEN);
    g.drawLine(centerX, centerY, secondX, secondY);
  }
  
}