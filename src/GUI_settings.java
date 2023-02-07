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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        JButton changetheme_btn = new JButton("Theme");
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
        name_register_field.setSize(Addons.objectSize());
        name_register_field.setText("novo ime");
        name_register_field.setLocation((int)(changetheme_btn.getLocation().getX() + changetheme_btn.getSize().getWidth() + 40), (int)(changetheme_btn.getLocation().getY()));
        name_register_field.setBorder(null);
        name_register_field.setHorizontalAlignment(JTextField.CENTER);
        frame.add(name_register_field);

        JTextField priimek_register_field = new JTextField();
        priimek_register_field.setSize(Addons.objectSize());
        priimek_register_field.setText("nov priimek");
        priimek_register_field.setLocation((int)(name_register_field.getLocation().getX()), (int)(name_register_field.getLocation().getY() + name_register_field.getSize().getHeight() + 10));
        priimek_register_field.setBorder(null);
        priimek_register_field.setHorizontalAlignment(JTextField.CENTER);
        frame.add(priimek_register_field);

        JTextField spol_register_field = new JTextField();
        spol_register_field.setSize(Addons.objectSize());
        spol_register_field.setText("nov spol");
        spol_register_field.setLocation((int)(name_register_field.getLocation().getX()), (int)(priimek_register_field.getLocation().getY() + priimek_register_field.getSize().getHeight() + 10));
        spol_register_field.setBorder(null);
        spol_register_field.setHorizontalAlignment(JTextField.CENTER);
        frame.add(spol_register_field);

        JTextField geslo_register_field = new JTextField();
        geslo_register_field.setSize(Addons.objectSize());
        geslo_register_field.setText("novo geslo");
        geslo_register_field.setLocation((int)(name_register_field.getLocation().getX() + geslo_register_field.getSize().getWidth() + 10), (int)(name_register_field.getLocation().getY()));
        geslo_register_field.setBorder(null);
        geslo_register_field.setHorizontalAlignment(JTextField.CENTER);
        frame.add(geslo_register_field);

        JComboBox<String> vrti_box = new JComboBox<>();
        vrti_box.setSize(Addons.objectSize());
        vrti_box.setLocation((int)(geslo_register_field.getLocation().getX()), (int)(geslo_register_field.getLocation().getY() + vrti_box.getSize().getHeight() + 10));
        vrti_box.setBackground(Color.WHITE);
        vrti_box.setVisible(true);
        for (int i = 1; i <= Addons.getMaxIdVrti(); i++) {
            vrti_box.addItem(Addons.getVrtiList(i));
        }
        frame.add(vrti_box);

        JButton save_register_btn = new JButton("Register");
        save_register_btn.setSize((int)(Addons.objectSize().getWidth()/2 - 5), (int)(Addons.objectSize().getHeight()));
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

        JButton clear_register_btn = new JButton("Clear");
        clear_register_btn.setSize((int)(Addons.objectSize().getWidth()/2 - 5), (int)(Addons.objectSize().getHeight()));
        clear_register_btn.setLocation((int)(save_register_btn.getLocation().getX() + save_register_btn.getSize().getWidth() + 10), (int)(save_register_btn.getLocation().getY()));
        clear_register_btn.setBorderPainted(false);
        frame.add(clear_register_btn);

        clear_register_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    name_register_field.setText("");
                    priimek_register_field.setText("");
                    spol_register_field.setText("");
                    geslo_register_field.setText("");
                } catch (Exception ex) {
                    System.out.println("clear_register_btn:: "+ex.getMessage());
                }
            }
        });


        //ime vrsta ogtrozena

        JTextField ime_zival_field = new JTextField();
        ime_zival_field.setSize(Addons.objectSize());
        ime_zival_field.setText("ime živali");
        ime_zival_field.setLocation((int)(changetheme_btn.getLocation().getX() - ime_zival_field.getSize().getWidth()*2 - 50), (int)changetheme_btn.getLocation().getY());
        ime_zival_field.setBorder(null);
        ime_zival_field.setHorizontalAlignment(JTextField.CENTER);
        frame.add(ime_zival_field);

        JTextField vrsta_zival_field = new JTextField();
        vrsta_zival_field.setSize(Addons.objectSize());
        vrsta_zival_field.setText("vrsta živali");
        vrsta_zival_field.setLocation((int)(ime_zival_field.getLocation().getX() + ime_zival_field.getSize().getWidth() + 10), (int)(ime_zival_field.getLocation().getY()));
        vrsta_zival_field.setBorder(null);
        vrsta_zival_field.setHorizontalAlignment(JTextField.CENTER);
        frame.add(vrsta_zival_field);

        JComboBox<String> ogrozena_box = new JComboBox<>();
        ogrozena_box.setSize(Addons.objectSize());
        ogrozena_box.setLocation((int)(ime_zival_field.getLocation().getX()), (int)(ime_zival_field.getLocation().getY() + ime_zival_field.getSize().getHeight() + 10));
        ogrozena_box.setBackground(Color.WHITE);
        ogrozena_box.setVisible(true);
        ogrozena_box.addItem("0");
        ogrozena_box.addItem("1");
        frame.add(ogrozena_box);

        JButton save_zival_btn = new JButton("Dodaj");
        save_zival_btn.setSize((int)(Addons.objectSize().getWidth()/2 - 5), (int)(Addons.objectSize().getHeight()));
        save_zival_btn.setLocation((int)(ogrozena_box.getLocation().getX() + ogrozena_box.getSize().getWidth() + 10), (int)(ogrozena_box.getLocation().getY()));
        save_zival_btn.setBorderPainted(false);
        frame.add(save_zival_btn);

        save_zival_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println(Addons.myHash(ime_zival_field.getText()));
                    if(!ime_zival_field.getText().equals(""))
                    {
                        if(!vrsta_zival_field.getText().equals(""))
                        {
                            if(ogrozena_box.getSelectedIndex() != -1)
                            {
                                Addons.insertZival(ime_zival_field.getText(), vrsta_zival_field.getText(), ogrozena_box.getSelectedIndex());
                            }
                        }
                        else
                        {
                            vrsta_zival_field.setText("vstavi vrsto");
                        }
                    }
                    else
                    {
                        ime_zival_field.setText("vstavi ime");
                    }
                } catch (Exception ex) {
                    System.out.println("save_zival_btn:: "+ex.getMessage());
                }
            }
        });

        JButton clear_zival_btn = new JButton("Počisti");
        clear_zival_btn.setSize((int)(Addons.objectSize().getWidth()/2 - 5), (int)(Addons.objectSize().getHeight()));
        clear_zival_btn.setLocation((int)(save_zival_btn.getLocation().getX() + save_zival_btn.getSize().getWidth() + 10), (int)(save_zival_btn.getLocation().getY()));
        clear_zival_btn.setBorderPainted(false);
        frame.add(clear_zival_btn);

        clear_zival_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ime_zival_field.setText("");
                    vrsta_zival_field.setText("");
                } catch (Exception ex) {
                    System.out.println("clear_zival_btn:: "+ex.getMessage());
                }
            }
        });


        JTextField ime_vrt_field = new JTextField();
        ime_vrt_field.setSize(Addons.objectSize());
        ime_vrt_field.setText("ime vrta");
        ime_vrt_field.setLocation((int)(ogrozena_box.getLocation().getX()), (int)(ogrozena_box.getLocation().getY() + ogrozena_box.getSize().getHeight() + 40));
        ime_vrt_field.setBorder(null);
        ime_vrt_field.setHorizontalAlignment(JTextField.CENTER);
        frame.add(ime_vrt_field);

        JTextField naslov_vrt_field = new JTextField();
        naslov_vrt_field.setSize(Addons.objectSize());
        naslov_vrt_field.setText("naslov vrta");
        naslov_vrt_field.setLocation((int)(ime_vrt_field.getLocation().getX() + ime_vrt_field.getSize().getWidth() + 10), (int)(ime_vrt_field.getLocation().getY()));
        naslov_vrt_field.setBorder(null);
        naslov_vrt_field.setHorizontalAlignment(JTextField.CENTER);
        frame.add(naslov_vrt_field);

        JTextField kraj_vrt_field = new JTextField();
        kraj_vrt_field.setSize(Addons.objectSize());
        kraj_vrt_field.setText("ime kraja");
        kraj_vrt_field.setLocation((int)(ime_vrt_field.getLocation().getX()), (int)(ime_vrt_field.getLocation().getY() + ime_vrt_field.getSize().getHeight()+ 10));
        kraj_vrt_field.setBorder(null);
        kraj_vrt_field.setHorizontalAlignment(JTextField.CENTER);
        frame.add(kraj_vrt_field);

        JButton save_vrt_btn = new JButton("Dodaj");
        save_vrt_btn.setSize((int)(Addons.objectSize().getWidth()/2 - 5), (int)(Addons.objectSize().getHeight()));
        save_vrt_btn.setLocation((int)(kraj_vrt_field.getLocation().getX() + kraj_vrt_field.getSize().getWidth() + 10), (int)(kraj_vrt_field.getLocation().getY()));
        save_vrt_btn.setBorderPainted(false);
        frame.add(save_vrt_btn);

        save_vrt_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(!ime_vrt_field.getText().equals(""))
                    {
                        if(!naslov_vrt_field.getText().equals(""))
                        {
                            if(!kraj_vrt_field.getText().equals(""))
                            {
                                Addons.insertVrt(ime_vrt_field.getText(), naslov_vrt_field.getText(), kraj_vrt_field.getText());
                            }
                            else
                            {
                                kraj_vrt_field.setText("vstavi kraj");
                            }
                        }
                        else
                        {
                            naslov_vrt_field.setText("vstavi naslov");
                        }
                    }
                    else
                    {
                        ime_vrt_field.setText("vstavi ime");
                    }
                } catch (Exception ex) {
                    System.out.println("save_vrt_btn:: "+ex.getMessage());
                }
            }
        });

        JButton clear_vrt_btn = new JButton("Počisti");
        clear_vrt_btn.setSize((int)(Addons.objectSize().getWidth()/2 - 5), (int)(Addons.objectSize().getHeight()));
        clear_vrt_btn.setLocation((int)(save_vrt_btn.getLocation().getX() + save_vrt_btn.getSize().getWidth() + 10), (int)(save_vrt_btn.getLocation().getY()));
        clear_vrt_btn.setBorderPainted(false);
        frame.add(clear_vrt_btn);

        clear_vrt_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ime_vrt_field.setText("");
                    naslov_vrt_field.setText("");
                    kraj_vrt_field.setText("");
                } catch (Exception ex) {
                    System.out.println("clear_vrt_btn:: "+ex.getMessage());
                }
            }
        });



        JComboBox<String> vrt_delete_box = new JComboBox<>();
        vrt_delete_box.setSize(Addons.objectSize());
        vrt_delete_box.setLocation((int)kraj_vrt_field.getLocation().getX(), (int)(kraj_vrt_field.getLocation().getY() + kraj_vrt_field.getSize().getHeight() + 100));
        vrt_delete_box.setBackground(Color.WHITE);
        vrt_delete_box.setVisible(true);

        for (int i = 1; i <= Addons.getMaxIdVrti(); i++) {
            if(Addons.getVrtiList(i) != null)
            {
                vrt_delete_box.addItem(Addons.getVrtiList(i));
            }
        }

        frame.add(vrt_delete_box);

        JButton vrt_delete_btn = new JButton("Izbriši");
        vrt_delete_btn.setSize(Addons.objectSize());
        vrt_delete_btn.setLocation((int)(vrt_delete_box.getLocation().getX()), (int)(vrt_delete_box.getLocation().getY() + vrt_delete_box.getSize().getHeight() + 10));
        vrt_delete_btn.setBorderPainted(false);
        frame.add(vrt_delete_btn);

        vrt_delete_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(vrt_delete_box.getSelectedIndex() != -1)
                    {
                        Addons.deleteVrt((String)vrt_delete_box.getSelectedItem());
                    }
                } catch (Exception ex) {
                    System.out.println("vrt_delete_btn:: "+ex.getMessage());
                }
            }
        });


        JComboBox<String> zaposleni_delete_box = new JComboBox<>();
        zaposleni_delete_box.setSize(Addons.objectSize());
        zaposleni_delete_box.setLocation((int)(vrt_delete_box.getLocation().getX() + vrt_delete_box.getSize().getWidth() + 10), (int)vrt_delete_box.getLocation().getY());
        zaposleni_delete_box.setBackground(Color.WHITE);
        zaposleni_delete_box.setVisible(true);

        for (int j = 0; j < (Addons.getZaposleniAll()).size(); j=j+2) {
            if(Addons.getZaposleniAll().get(j) != null && Addons.getZaposleniAll().get(j+1) != null)
            {
                Object added = Addons.getZaposleniAll().get(j)+" "+Addons.getZaposleniAll().get(j+1);
                zaposleni_delete_box.addItem((String)added);
            }
        }

        frame.add(zaposleni_delete_box);

        JButton zaposleni_delete_btn = new JButton("Izbriši");
        zaposleni_delete_btn.setSize(Addons.objectSize());
        zaposleni_delete_btn.setLocation((int)(zaposleni_delete_box.getLocation().getX()), (int)(zaposleni_delete_box.getLocation().getY() + zaposleni_delete_box.getSize().getHeight() + 10));
        zaposleni_delete_btn.setBorderPainted(false);
        frame.add(zaposleni_delete_btn);

        zaposleni_delete_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(zaposleni_delete_box.getSelectedIndex() != -1)
                    {
                        List<String> formated = new ArrayList<>();
                        formated = Arrays.asList(((String)zaposleni_delete_box.getSelectedItem()).split(" ")); 


                        Addons.deleteZaposleni(formated.get(0), formated.get(1));
                    }
                } catch (Exception ex) {
                    System.out.println("zaposleni_delete_btn:: "+ex.getMessage());
                }
            }
        });


        JComboBox<String> zivali_delete_box = new JComboBox<>();
        zivali_delete_box.setSize(Addons.objectSize());
        zivali_delete_box.setLocation((int)(spol_register_field.getLocation().getX()), (int)(zaposleni_delete_box.getLocation().getY()));
        zivali_delete_box.setBackground(Color.WHITE);
        zivali_delete_box.setVisible(true);

        for (int j = 0; j < (Addons.getZivaliAll()).size(); j=j+2) {
            if(Addons.getZivaliAll().get(j) != null && Addons.getZivaliAll().get(j+1) != null)
            {
                Object added = Addons.getZivaliAll().get(j)+" "+Addons.getZivaliAll().get(j+1);
                zivali_delete_box.addItem((String)added);
            }
        }

        frame.add(zivali_delete_box);

        JButton zivali_delete_btn = new JButton("Izbriši");
        zivali_delete_btn.setSize(Addons.objectSize());
        zivali_delete_btn.setLocation((int)(zivali_delete_box.getLocation().getX()), (int)(zivali_delete_box.getLocation().getY() + zivali_delete_box.getSize().getHeight() + 10));
        zivali_delete_btn.setBorderPainted(false);
        frame.add(zivali_delete_btn);

        zivali_delete_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(zivali_delete_box.getSelectedIndex() != -1)
                    {
                        List<String> formated = new ArrayList<>();
                        formated = Arrays.asList(((String)zivali_delete_box.getSelectedItem()).split(" ")); 

                        Addons.deleteZival(formated.get(0));
                    }
                } catch (Exception ex) {
                    System.out.println("zivali_delete_btn:: "+ex.getMessage());
                }
            }
        });

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

        if(Addons.getDarkMode() == 1)
        {

            back_btn.setForeground(Color.WHITE);
            back_btn.setBackground(new Color(118, 118, 118));
            
            changetheme_btn.setForeground(Color.WHITE);
            changetheme_btn.setBackground(Color.darkGray);

            logout_btn.setBackground(Color.darkGray);
            logout_btn.setForeground(Color.WHITE);

            frame.getContentPane().setBackground(new Color(118, 118, 118));
            
            ime_zival_field.setForeground(Color.WHITE);
            ime_zival_field.setBackground(Color.darkGray);

            vrsta_zival_field.setForeground(Color.WHITE);
            vrsta_zival_field.setBackground(Color.darkGray);

            ogrozena_box.setForeground(Color.WHITE);
            ogrozena_box.setBackground(Color.darkGray);

            save_zival_btn.setForeground(Color.WHITE);
            save_zival_btn.setBackground(Color.darkGray);

            clear_zival_btn.setForeground(Color.WHITE);
            clear_zival_btn.setBackground(Color.darkGray);

            ime_vrt_field.setForeground(Color.WHITE);
            ime_vrt_field.setBackground(Color.darkGray);

            naslov_vrt_field.setForeground(Color.WHITE);
            naslov_vrt_field.setBackground(Color.darkGray);

            kraj_vrt_field.setForeground(Color.WHITE);
            kraj_vrt_field.setBackground(Color.darkGray);

            save_vrt_btn.setForeground(Color.WHITE);
            save_vrt_btn.setBackground(Color.darkGray);

            clear_vrt_btn.setForeground(Color.WHITE);
            clear_vrt_btn.setBackground(Color.darkGray);

            name_register_field.setForeground(Color.WHITE);
            name_register_field.setBackground(Color.darkGray);

            priimek_register_field.setForeground(Color.WHITE);
            priimek_register_field.setBackground(Color.darkGray);

            geslo_register_field.setForeground(Color.WHITE);
            geslo_register_field.setBackground(Color.darkGray);

            spol_register_field.setForeground(Color.WHITE);
            spol_register_field.setBackground(Color.darkGray);

            vrti_box.setForeground(Color.WHITE);
            vrti_box.setBackground(Color.darkGray);

            save_vrt_btn.setForeground(Color.WHITE);
            save_vrt_btn.setBackground(Color.darkGray);

            save_register_btn.setForeground(Color.WHITE);
            save_register_btn.setBackground(Color.darkGray);

            clear_register_btn.setForeground(Color.WHITE);
            clear_register_btn.setBackground(Color.darkGray);

            vrt_delete_box.setForeground(Color.WHITE);
            vrt_delete_box.setBackground(Color.darkGray);

            vrt_delete_btn.setForeground(Color.WHITE);
            vrt_delete_btn.setBackground(Color.darkGray);

            zaposleni_delete_box.setForeground(Color.WHITE);
            zaposleni_delete_box.setBackground(Color.darkGray);

            zaposleni_delete_btn.setForeground(Color.WHITE);
            zaposleni_delete_btn.setBackground(Color.darkGray);

            zivali_delete_box.setForeground(Color.WHITE);
            zivali_delete_box.setBackground(Color.darkGray);

            zivali_delete_btn.setForeground(Color.WHITE);
            zivali_delete_btn.setBackground(Color.darkGray);
        }

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
