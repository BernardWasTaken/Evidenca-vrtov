import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.event.*;

public class GUI_main extends JFrame implements ActionListener {

    public GUI_main() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Zivalski vrt");
        frame.setLayout(null);
        frame.setPreferredSize(new Dimension(1000, 600));
        frame.setResizable(false);

        JButton button = new JButton("test");
        button.setSize(300, 50);
        frame.add(button);

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
