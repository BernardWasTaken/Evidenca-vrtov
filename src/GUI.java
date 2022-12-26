import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class GUI extends JFrame implements ActionListener{
    private Button button;
    private JTextField textField;
    private JLabel label;

    public GUI() {
        // Set the title and layout of the frame
        setTitle("Zivalski vrt");
        setLayout(new FlowLayout());
        setSize(100, 100);
    
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setPreferredSize(new Dimension(400, 300));
        
        Utilities.AddButton(frame, "Login test", new Color(0, 0, 139));

        frame.pack();
        frame.setVisible(true);
      }
    
      public void actionPerformed(ActionEvent e) {
        // Get the text from the text field
        String text = textField.getText();
    
        // Set the text of the label to the text from the text field
        label.setText(text);
      }
}
