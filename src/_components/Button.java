package _components;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.Color;

public class Button extends JButton{

  public Button(String text) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        JButton b = new JButton("Log In");//http://www.chacha.com/question/what-are-the-rgb-values-for-the-background-color-of-comments-on-facebook
        b.setBackground(new Color(59, 89, 182));
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setFont(new Font("Tahoma", Font.BOLD, 12));//http://answers.yahoo.com/question/index?qid=20070906133202AAOvnIP
        frame.add(b);
        frame.pack();
        frame.setVisible(true);
  }
}
