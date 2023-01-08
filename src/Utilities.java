import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.*;

public class Utilities {
    public static void AddButton(JFrame frame, String text, Color col)
    {
        JButton b = new JButton(text);
        b.setBackground(col);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setBounds(40, 100, 100, 60);
        b.setFont(new Font("Tahoma", Font.BOLD, 12));
        frame.add(b);
    }
}
