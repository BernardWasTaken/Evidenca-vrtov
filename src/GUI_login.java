import javax.swing.*;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.ExtendedDigest;
import org.w3c.dom.css.RGBColor;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;

import java.awt.font.*;

public class GUI_login extends JFrame implements ActionListener{
    private JTextField textField;

    public static String logged;

    public GUI_login() {
        // Set the title and layout of the frame
        setTitle("Zivalski vrt");
        setLayout(new FlowLayout());
        setSize(100, 100);
    
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Zivalski vrt");
        frame.setLayout(null);
        //frame.setPreferredSize(new Dimension((int)Addons.screenSize.getWidth(), (int)Addons.screenSize.getHeight()));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setUndecorated(true);
        frame.setResizable(false);

        JTextField username_field = new JTextField();
        JPasswordField password_field = new JPasswordField();

        username_field.setSize(250, 50);
        username_field.setText("username");
        username_field.setLocation((Addons.screenSize.width / 2) - (username_field.getSize().width/2), (Addons.screenSize.height / 2) - (username_field.getSize().height*2));
        username_field.setBorder(null);
        username_field.setHorizontalAlignment(JTextField.CENTER);
        frame.add(username_field);

        password_field.setSize(250, 50);
        password_field.setText("password");
        password_field.setEchoChar('*');
        password_field.setLocation((Addons.screenSize.width / 2) - (password_field.getSize().width/2), (Addons.screenSize.height / 2) - (password_field.getSize().height/2));
        password_field.setBorder(null);
        password_field.setHorizontalAlignment(JPasswordField.CENTER);
        frame.add(password_field);

        JButton login_btn = new JButton();
        login_btn.setText("login");
        login_btn.setSize(250, 50);
        login_btn.setLocation((Addons.screenSize.width / 2) - (username_field.getSize().width/2), (Addons.screenSize.height / 2) + (username_field.getSize().height));
        login_btn.setBorderPainted(false);
        frame.add(login_btn);

        JLabel exit_lbl = new JLabel();
        exit_lbl.setText("exit");
        exit_lbl.setSize(50, 25);
        exit_lbl.setLocation((login_btn.getLocation().x + login_btn.getSize().width/2) - exit_lbl.getSize().width/8, (login_btn.getLocation().y) + (login_btn.getSize().height * 2));
        Font font = exit_lbl.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        exit_lbl.setFont(font.deriveFont(attributes));
        exit_lbl.setForeground(Color.RED);
        frame.add(exit_lbl);

        exit_lbl.addMouseListener(new MouseAdapter()  
        {  
            @Override
            public void mouseClicked(MouseEvent e)  
            {  
              try {
                System.exit(ABORT);
              } catch (Exception ex) {
                System.out.println(ex.getMessage());
              }
            }  
        }); 

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
                logged = username_field.getText();
                System.out.println(logged);
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
      }
}
