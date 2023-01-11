import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.*;
import java.util.List;

public class GUI_main extends JFrame implements ActionListener {

    public GUI_main() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Zivalski vrt");
        frame.setLayout(null);
        frame.setPreferredSize(new Dimension(1000, 600));
        
        frame.setResizable(false);

        JButton setting_btn = new JButton("Settings");
        setting_btn.setSize(100, 50);
        setting_btn.setLocation(885, 0);
        setting_btn.setBackground(Color.WHITE);
        setting_btn.setBorderPainted(false);
        frame.add(setting_btn);

        JComboBox<String> box = new JComboBox<String>();
        for (int i = 1; i <= Addons.getMaxIdVrti(); i++) {
            box.addItem(Addons.getVrtiList(i));
        }
        box.setSize(new Dimension(200, 100));
        box.setBorder(null);

        if(Addons.getDarkMode() == 1)
        {
            box.setForeground(Color.WHITE);
            box.setBackground(Color.darkGray);
            box.getEditor().getEditorComponent().setBackground(Color.darkGray);
        }
        frame.add(box);

        if(Addons.getDarkMode() == 1)
        {
            setting_btn.setForeground(Color.WHITE);
            setting_btn.setBackground(new Color(118, 118, 118));

            frame.getContentPane().setBackground(new Color(118, 118, 118));
        }

        setting_btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GUI_settings gui_settings = new GUI_settings();
                    frame.dispose();
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
