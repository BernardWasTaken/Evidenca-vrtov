import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.*;

public class GUI_settings extends JFrame implements ActionListener {
    public GUI_settings()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Zivalski vrt");
        frame.setLayout(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setUndecorated(true);
        
        frame.setResizable(false);

        JButton back_btn = new JButton("Back");
        back_btn.setSize(100, 50);
        back_btn.setLocation((int)(Addons.screenSize.getWidth()/2 - back_btn.getSize().getWidth()/2), 0);
        back_btn.setForeground(Color.WHITE);
        back_btn.setBackground(new Color(118, 118, 118));
        back_btn.setBorderPainted(false);
        frame.add(back_btn);

        back_btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GUI_main main = new GUI_main();
                    frame.dispose();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        JButton changetheme_btn = new JButton("Change Theme");
        changetheme_btn.setLocation((int)back_btn.getLocation().getX(), (int)(back_btn.getLocation().getY() + back_btn.getSize().getHeight() + 20));
        changetheme_btn.setSize(100, 50);
        changetheme_btn.setBorderPainted(false);


        JButton logout_btn = new JButton("Logout");
        logout_btn.setSize(100, 50);
        logout_btn.setLocation((int)changetheme_btn.getLocation().getX(), (int)(changetheme_btn.getLocation().getY() + logout_btn.getSize().getHeight() + 20));
        logout_btn.setBorderPainted(false);
        frame.add(logout_btn);

        logout_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GUI_login login = new GUI_login();
                    frame.dispose();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });


        JTextField name_register_field = new JTextField();
        name_register_field.setSize(250, 50);
        name_register_field.setText("novo ime");
        name_register_field.setLocation((int)(Addons.screenSize.getWidth() - name_register_field.getSize().getWidth()*2 - 20), 20);
        name_register_field.setBorder(null);
        name_register_field.setHorizontalAlignment(JTextField.CENTER);
        frame.add(name_register_field);

        JTextField priimek_register_field = new JTextField();
        priimek_register_field.setSize(250, 50);
        priimek_register_field.setText("nov priimek");
        priimek_register_field.setLocation((int)(name_register_field.getLocation().getX()), (int)(name_register_field.getLocation().getY() + name_register_field.getSize().getHeight() + 10));
        priimek_register_field.setBorder(null);
        priimek_register_field.setHorizontalAlignment(JTextField.CENTER);
        frame.add(priimek_register_field);

        JTextField spol_register_field = new JTextField();
        spol_register_field.setSize(250, 50);
        spol_register_field.setText("nov spol");
        spol_register_field.setLocation((int)(name_register_field.getLocation().getX()), (int)(priimek_register_field.getLocation().getY() + priimek_register_field.getSize().getHeight() + 10));
        spol_register_field.setBorder(null);
        spol_register_field.setHorizontalAlignment(JTextField.CENTER);
        frame.add(spol_register_field);

        JTextField geslo_register_field = new JTextField();
        geslo_register_field.setSize(250, 50);
        geslo_register_field.setText("novo geslo");
        geslo_register_field.setLocation((int)(name_register_field.getLocation().getX() + geslo_register_field.getSize().getWidth() + 10), (int)(name_register_field.getLocation().getY()));
        geslo_register_field.setBorder(null);
        geslo_register_field.setHorizontalAlignment(JTextField.CENTER);
        frame.add(geslo_register_field);

        JComboBox<String> vrti_box = new JComboBox<>();
        vrti_box.setSize(250, 50);
        vrti_box.setLocation((int)(geslo_register_field.getLocation().getX()), (int)(geslo_register_field.getLocation().getY() + vrti_box.getSize().getHeight() + 10));
        vrti_box.setBackground(Color.WHITE);
        vrti_box.setVisible(true);
        for (int i = 1; i <= Addons.getMaxIdVrti(); i++) {
            vrti_box.addItem(Addons.getVrtiList(i));
        }
        frame.add(vrti_box);

        JButton save_register_btn = new JButton("Register");
        save_register_btn.setSize(100, 50);
        save_register_btn.setLocation((int)(vrti_box.getLocation().getX()), (int)(vrti_box.getLocation().getY() + vrti_box.getSize().getHeight() + 10));
        save_register_btn.setBorderPainted(false);
        frame.add(save_register_btn);

        save_register_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(!name_register_field.getText().equals(""))
                    {
                        if(!priimek_register_field.getText().equals(""))
                        {
                            if(!geslo_register_field.getText().equals(""))
                            {
                                if(!spol_register_field.getText().equals(""))
                                {
                                    if(vrti_box.getSelectedIndex() != -1)
                                    {
                                        Addons.insertRegister(
                                            name_register_field.getText(),
                                            priimek_register_field.getText(),
                                            geslo_register_field.getText(),
                                            spol_register_field.getText(),
                                            (String)vrti_box.getSelectedItem()
                                        );
                                    }
                                    else
                                    {
                                        System.out.println("vrti_box selected index:: not selected");
                                    }
                                }
                                else
                                {
                                    spol_register_field.setText("vnesi spol");
                                }
                            }
                            else
                            {
                                geslo_register_field.setText("vnesi geslo");
                            }
                        }
                        else
                        {
                            priimek_register_field.setText("vnesi priimek");
                        }
                    }
                    else
                    {
                        name_register_field.setText("vnesi ime");
                    }
                } catch (Exception ex) {
                    System.out.println("save_register_btn:: "+ex.getMessage());
                }
            }
        });


        if(Addons.getDarkMode() == 1)
        {
            changetheme_btn.setForeground(Color.WHITE);
            changetheme_btn.setBackground(Color.darkGray);

            logout_btn.setBackground(Color.darkGray);
            logout_btn.setForeground(Color.WHITE);

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
