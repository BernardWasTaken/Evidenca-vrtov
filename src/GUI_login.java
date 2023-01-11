import javax.swing.*;

import org.w3c.dom.css.RGBColor;

import java.awt.*;
import java.awt.event.*;

public class GUI_login extends JFrame implements ActionListener{
    private JTextField textField;
    private JLabel label;

    public GUI_login() {
        // Set the title and layout of the frame
        setTitle("Zivalski vrt");
        setLayout(new FlowLayout());
        setSize(100, 100);
    
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Zivalski vrt");
        frame.setLayout(null);
        frame.setPreferredSize(new Dimension(500, 300));
        frame.setResizable(false);

        JTextField username_field = new JTextField();
        JPasswordField password_field = new JPasswordField();

        username_field.setSize(250, 50);
        username_field.setText("username");
        username_field.setLocation(125, 0);
        username_field.setBorder(null);
        username_field.setHorizontalAlignment(JTextField.CENTER);
        frame.add(username_field);

        password_field.setSize(250, 50);
        password_field.setText("password");
        password_field.setEchoChar('*');
        password_field.setLocation(125, 51);
        password_field.setBorder(null);
        password_field.setHorizontalAlignment(JPasswordField.CENTER);
        frame.add(password_field);

        JButton login_btn = new JButton();
        login_btn.setText("login");
        login_btn.setSize(250, 50);
        login_btn.setLocation(125, 102);
        login_btn.setBorderPainted(false);
        frame.add(login_btn);

        if(Addons.getDarkMode() == 1)
        {
          login_btn.setBackground(Color.darkGray);
          login_btn.setForeground(Color.WHITE);

          username_field.setBackground(Color.darkGray);
          username_field.setForeground(Color.WHITE);

          password_field.setBackground(Color.darkGray);
          password_field.setForeground(Color.WHITE);

          frame.getContentPane().setBackground(new Color(118, 118, 118));
        }
        
        login_btn.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
              if(Addons.getLoginData(username_field.getText(), password_field.getText()) == 1)
              {
                GUI_main gui_main = new GUI_main();
                frame.dispose();
                System.out.println("logged in");
              }
              else
              {
                frame.add(new JLabel("narobe"));
              }
          }
      });
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
