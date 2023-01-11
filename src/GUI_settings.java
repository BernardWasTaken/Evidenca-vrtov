import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.*;

public class GUI_settings extends JFrame implements ActionListener {
    public GUI_settings()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Zivalski vrt");
        frame.setLayout(null);
        frame.setPreferredSize(new Dimension(1000, 600));
        
        frame.setResizable(false);

        JButton back_btn = new JButton("Back");
        back_btn.setSize(100, 50);
        back_btn.setBorderPainted(false);
        frame.add(back_btn);

        back_btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GUI_main gui_main = new GUI_main();
                    frame.dispose();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        JButton changetheme_btn = new JButton("Change Theme");
        changetheme_btn.setLocation(100, 100);
        changetheme_btn.setSize(100, 50);
        changetheme_btn.setBorderPainted(false);
        if(Addons.getDarkMode() == 1)
        {
            changetheme_btn.setForeground(Color.WHITE);
            changetheme_btn.setBackground(Color.darkGray);

            back_btn.setForeground(Color.WHITE);
            back_btn.setBackground(Color.darkGray);

            frame.getContentPane().setBackground(new Color(118, 118, 118));
        }

        frame.add(changetheme_btn);

        changetheme_btn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    Addons.changeTheme();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
