import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.*;

public class Utilities {
    public static void AddButton(JFrame frame, String text, Color col)
    {
        JButton b = new JButton(text);//http://www.chacha.com/question/what-are-the-rgb-values-for-the-background-color-of-comments-on-facebook
        b.setBackground(col);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setFont(new Font("Tahoma", Font.BOLD, 12));//http://answers.yahoo.com/question/index?qid=20070906133202AAOvnIP
        frame.add(b);
    }
}
