import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GUI_main extends JFrame implements ActionListener {

    public GUI_main() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Zivalski vrt");
        frame.setLayout(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setUndecorated(true);
        
        frame.setResizable(false);

        frame.addWindowFocusListener(new WindowAdapter() {
            public void windowGainedFocus(WindowEvent e) {
                frame.invalidate();
                frame.validate();
                frame.repaint();
            }
        });
        JButton setting_btn = new JButton("Settings");
        setting_btn.setSize(100, 50);
        setting_btn.setLocation((int)(Addons.screenSize.getWidth()/2 - setting_btn.getSize().getWidth()/2), 0);
        setting_btn.setBackground(Color.WHITE);
        setting_btn.setBorderPainted(false);
        setting_btn.setVisible(true);

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
                    System.out.println("setting_btn action listener:: "+ex.getMessage());
                }
            }
        });

        String test = GUI_login.logged;

        if(test.equals("admin"))
        {
            System.out.println("zaznan admin");
            frame.add(setting_btn);
        }

        DefaultListModel<String> model = new DefaultListModel<>();
        JComboBox<String> zaposleni_list = new JComboBox<>();
        zaposleni_list.setSize(300, 290);
        zaposleni_list.setLocation(150, 400);
        zaposleni_list.setBackground(Color.WHITE);
        zaposleni_list.setVisible(true);
        frame.add(zaposleni_list);

        JTextField name_field = new JTextField();
        name_field.setSize(250, 50);
        name_field.setLocation((int)(zaposleni_list.getLocation().getX() + zaposleni_list.getSize().getWidth() + 10), (int)zaposleni_list.getLocation().getY());
        name_field.setBorder(null);
        name_field.setHorizontalAlignment(JTextField.CENTER);
        name_field.setEnabled(false);
        frame.add(name_field);

        JTextField surname_field = new JTextField();
        surname_field.setSize(250, 50);
        surname_field.setLocation((int)name_field.getLocation().getX(), (int)(name_field.getLocation().getY() + name_field.getSize().getHeight() + 10));
        surname_field.setBorder(null);
        surname_field.setHorizontalAlignment(JTextField.CENTER);
        surname_field.setEnabled(false);
        frame.add(surname_field);

        JTextField username_field = new JTextField();
        username_field.setSize(250, 50);
        username_field.setLocation((int)surname_field.getLocation().getX(), (int)(surname_field.getLocation().getY() + surname_field.getSize().getHeight() + 10));
        username_field.setBorder(null);
        username_field.setHorizontalAlignment(JTextField.CENTER);
        username_field.setEnabled(false);
        frame.add(username_field);

        JTextField password_field = new JTextField();
        password_field.setSize(250, 50);
        password_field.setLocation((int)(name_field.getLocation().getX() + name_field.getSize().getWidth() + 10), (int)name_field.getLocation().getY());
        password_field.setBorder(null);
        password_field.setHorizontalAlignment(JTextField.CENTER);
        password_field.setEnabled(false);
        frame.add(password_field);

        JTextField spol_field = new JTextField();
        spol_field.setSize(250, 50);
        spol_field.setLocation((int)(surname_field.getLocation().getX() + surname_field.getSize().getWidth() + 10), (int)surname_field.getLocation().getY());
        spol_field.setBorder(null);
        spol_field.setHorizontalAlignment(JTextField.CENTER);
        spol_field.setEnabled(false);
        frame.add(spol_field);

        JComboBox<String> vrt_box = new JComboBox<String>();
        for (int i = 1; i <= Addons.getMaxIdVrti(); i++) {
            vrt_box.addItem(Addons.getVrtiList(i));
        }
        vrt_box.setSize(250, 50);
        vrt_box.setLocation((int)(username_field.getLocation().getX() + username_field.getSize().getWidth() + 10), (int)username_field.getLocation().getY());
        vrt_box.setBorder(null);
        vrt_box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    Object selected = null;
                    selected = vrt_box.getSelectedItem();
                    System.out.println("vrt_box action listener:: "+selected);
                } catch (Exception ex) {
                    System.out.println("vrt_box action listener:: "+ex.getMessage());
                }
            }
        });
        vrt_box.setEnabled(false);
        frame.add(vrt_box);

        JButton save_btn = new JButton("Save");
        save_btn.setSize(250, 50);
        save_btn.setLocation((int)username_field.getLocation().getX(), (int)(username_field.getLocation().getY() + username_field.getSize().getHeight() + 10));
        save_btn.setBackground(Color.WHITE);
        save_btn.setBorderPainted(false);
        save_btn.setVisible(true);
        save_btn.setEnabled(false);
        frame.add(save_btn);
        save_btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    
                    List<String> formated = new ArrayList<>();
                    if(!model.isEmpty())
                    {
                        formated = Arrays.asList(model.get(zaposleni_list.getSelectedIndex()).split(" ")); 
                    }

                    Addons.updateUser(
                        formated.get(0),
                        formated.get(1),
                        name_field.getText(),
                        surname_field.getText(),
                        username_field.getText(),
                        password_field.getText(),
                        spol_field.getText(),
                        (String)vrt_box.getSelectedItem()
                        );

                } catch (Exception ex) {
                    System.out.println("save_btn action listener:: "+ex.getMessage());
                }
            }
        });

        JButton unlock_btn = new JButton("Unlock");
        unlock_btn.setSize(250, 50);
        unlock_btn.setLocation((int)vrt_box.getLocation().getX(), (int)(vrt_box.getLocation().getY() + vrt_box.getSize().getHeight() + 10));
        unlock_btn.setBackground(Color.WHITE);
        unlock_btn.setBorderPainted(false);
        unlock_btn.setVisible(true);
        frame.add(unlock_btn);
        unlock_btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    
                    name_field.setEnabled(true);
                    surname_field.setEnabled(true);
                    username_field.setEnabled(true);
                    password_field.setEnabled(true);
                    spol_field.setEnabled(true);
                    vrt_box.setEnabled(true);
                    save_btn.setEnabled(true);

                } catch (Exception ex) {
                    System.out.println("unlock_btn Action listener:: "+ex.getMessage());
                }
            }
        });





        JTextField name_field_vrt = new JTextField();
        name_field_vrt.setSize(250, 50);
        name_field_vrt.setLocation((int)(Addons.screenSize.getWidth()/2 - name_field.getSize().getWidth() - name_field.getSize().getWidth()/2 - 10), (int)(setting_btn.getLocation().getY() + 150));
        name_field_vrt.setBorder(null);
        name_field_vrt.setHorizontalAlignment(JTextField.CENTER);
        name_field_vrt.setEnabled(false);
        frame.add(name_field_vrt);

        JTextField naslov_field_vrt = new JTextField();
        naslov_field_vrt.setSize(250, 50);
        naslov_field_vrt.setLocation((int)(name_field_vrt.getLocation().getX() + name_field_vrt.getSize().getWidth() + 10), (int)(name_field_vrt.getLocation().getY()));
        naslov_field_vrt.setBorder(null);
        naslov_field_vrt.setHorizontalAlignment(JTextField.CENTER);
        naslov_field_vrt.setEnabled(false);
        frame.add(naslov_field_vrt);

        JTextField kraj_field_vrt = new JTextField();
        kraj_field_vrt.setSize(250, 50);
        kraj_field_vrt.setLocation((int)(naslov_field_vrt.getLocation().getX() + naslov_field_vrt.getSize().getWidth() + 10), (int)(naslov_field_vrt.getLocation().getY()));
        kraj_field_vrt.setBorder(null);
        kraj_field_vrt.setHorizontalAlignment(JTextField.CENTER);
        kraj_field_vrt.setEnabled(false);
        frame.add(kraj_field_vrt);

        JButton save_vrt_btn = new JButton("Save");
        save_vrt_btn.setSize(250, 50);
        save_vrt_btn.setLocation((int)(naslov_field_vrt.getLocation().getX() - save_vrt_btn.getSize().getWidth()/2 - 5), (int)(naslov_field_vrt.getLocation().getY() + naslov_field_vrt.getSize().getHeight() + 10));
        save_vrt_btn.setBackground(Color.WHITE);
        save_vrt_btn.setBorderPainted(false);
        save_vrt_btn.setVisible(true);
        save_vrt_btn.setEnabled(false);
        frame.add(save_vrt_btn);

        JButton unlock_vrt_btn = new JButton("Unlock");
        unlock_vrt_btn.setSize(250, 50);
        unlock_vrt_btn.setLocation((int)(save_vrt_btn.getLocation().getX() + unlock_vrt_btn.getSize().getWidth() + 10), (int)(save_vrt_btn.getLocation().getY()));
        unlock_vrt_btn.setBackground(Color.WHITE);
        unlock_vrt_btn.setBorderPainted(false);
        unlock_vrt_btn.setVisible(true);
        frame.add(unlock_vrt_btn);
        unlock_vrt_btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    
                    name_field_vrt.setEnabled(true);
                    naslov_field_vrt.setEnabled(true);
                    kraj_field_vrt.setEnabled(true);
                    save_vrt_btn.setEnabled(true);

                } catch (Exception ex) {
                    System.out.println("unlock_vrt_btn Action listener:: "+ex.getMessage());
                }
            }
        });

        zaposleni_list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                    List<String> formated = new ArrayList<>();
                    if(!model.isEmpty())
                    {
                        formated = Arrays.asList(((String) zaposleni_list.getSelectedItem()).split(" ")); 
                    }

                    if(!formated.isEmpty())
                    {
                        name_field.setText(formated.get(0));
                        surname_field.setText(formated.get(1));
                        username_field.setText(Addons.getUsername(name_field.getText(), surname_field.getText()));
                        password_field.setText(Addons.getGeslo(name_field.getText(), surname_field.getText()));
                        spol_field.setText(Addons.getSpol(name_field.getText(), surname_field.getText()));
                        vrt_box.setSelectedItem(Addons.getVrt(name_field.getText(), surname_field.getText()));

                        name_field.setEnabled(false);
                        surname_field.setEnabled(false);
                        username_field.setEnabled(false);
                        password_field.setEnabled(false);
                        spol_field.setEnabled(false);
                        vrt_box.setEnabled(false);
                        save_btn.setEnabled(false);
                    }
            }
        });
        



        DefaultListModel<String> model_zivali = new DefaultListModel<>();
        JList<String> zivali_list = new JList<>(model_zivali);
        zivali_list.setSize(300, 290);
        zivali_list.setLocation((int)(password_field.getLocation().getX() + password_field.getSize().getWidth() + 200), (int)(password_field.getLocation().getY()));
        zivali_list.setBackground(Color.WHITE);
        zivali_list.setVisible(true);
        frame.add(zivali_list);

        JTextField name_field_zivali = new JTextField();
        name_field_zivali.setSize(250, 50);
        name_field_zivali.setLocation((int)(zivali_list.getLocation().getX() + zivali_list.getSize().getWidth() + 10), (int)zivali_list.getLocation().getY());
        name_field_zivali.setBorder(null);
        name_field_zivali.setHorizontalAlignment(JTextField.CENTER);
        name_field_zivali.setEnabled(false);
        frame.add(name_field_zivali);

        JTextField vrsta_field = new JTextField();
        vrsta_field.setSize(250, 50);
        vrsta_field.setLocation((int)name_field_zivali.getLocation().getX(), (int)(name_field_zivali.getLocation().getY() + name_field_zivali.getSize().getHeight() + 10));
        vrsta_field.setBorder(null);
        vrsta_field.setHorizontalAlignment(JTextField.CENTER);
        vrsta_field.setEnabled(false);
        frame.add(vrsta_field);

        JComboBox<String> ogrozena_box = new JComboBox<String>();
        ogrozena_box.addItem("0");
        ogrozena_box.addItem("1");
        ogrozena_box.setSize(250, 50);
        ogrozena_box.setLocation((int)(vrsta_field.getLocation().getX()), (int)(vrsta_field.getLocation().getY() + vrsta_field.getSize().getHeight() + 10));
        ogrozena_box.setBorder(null);




        
        JComboBox<String> box = new JComboBox<String>();
        for (int i = 1; i <= Addons.getMaxIdVrti(); i++) {
            box.addItem(Addons.getVrtiList(i));
        }
        box.setSize(new Dimension(250, 50));
        box.setLocation((int)Addons.screenSize.getWidth()/2 - (int)box.getSize().getWidth()/2, (int)(setting_btn.getLocation().getY() + setting_btn.getSize().getHeight() + 30));
        box.setBorder(null);
        box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                
            }
        });
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    model.clear();
                    model_zivali.clear();
                    name_field.setText(null);
                    surname_field.setText(null);
                    username_field.setText(null);
                    password_field.setText(null);
                    spol_field.setText(null);
                    vrt_box.removeAll();
                    name_field_zivali.setText(null);
                    vrsta_field.setText(null);
                    Object selected = null;
                    selected = box.getSelectedItem();
                        for (int j = 0; j < (Addons.getZaposleni((String)selected)).size(); j=j+2) {
                            System.out.println(Addons.getAllZaposleni((String)selected));
                            if(Addons.getZaposleni((String)selected).get(j) != null && Addons.getZaposleni((String)selected).get(j+1) != null)
                            {
                                Object added = Addons.getZaposleni((String)selected).get(j)+" "+Addons.getZaposleni((String)selected).get(j+1);
                                zaposleni_list.addItem((String)added);
                            }
                        }
                        for (int i = 0; i < (Addons.getZivali((String)selected)).size(); i=i+2) {
                            if(Addons.getZivali((String)selected).get(i) != null && Addons.getZivali((String)selected).get(i+1) != null)
                            {
                                model_zivali.addElement(Addons.getZivali((String)selected).get(i)+" "+Addons.getZivali((String)selected).get(i+1));
                            }
                        }
                    
                    
                        name_field_vrt.setText((String)box.getSelectedItem());
                        naslov_field_vrt.setText(Addons.getNaslov((String)box.getSelectedItem()));
                        kraj_field_vrt.setText(Addons.getKraj((String)box.getSelectedItem()));
                    
                    System.out.println(selected);
                    zivali_list.setModel(model_zivali);
                    name_field.setEnabled(false);
                    surname_field.setEnabled(false);
                    username_field.setEnabled(false);
                    password_field.setEnabled(false);
                    spol_field.setEnabled(false);
                    vrt_box.setEnabled(false);
                    save_btn.setEnabled(false);
                    name_field_vrt.setEnabled(false);
                    naslov_field_vrt.setEnabled(false);
                    kraj_field_vrt.setEnabled(false);
                    save_vrt_btn.setEnabled(false);
                } catch (Exception ex) {
                    System.out.println("box action listener:: "+ex.getMessage());
                }
            }
        });

        save_vrt_btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    
                    Addons.updateVrt((String)box.getSelectedItem() ,name_field_vrt.getText(), naslov_field_vrt.getText(), kraj_field_vrt.getText());

                } catch (Exception ex) {
                    System.out.println("save_btn action listener:: "+ex.getMessage());
                }
            }
        });

        JLabel zaposleni_label = new JLabel();
        zaposleni_label.setText("Zaposleni");
        zaposleni_label.setSize(90, 25);
        zaposleni_label.setLocation((int)zaposleni_list.getLocation().getX(), (int)(zaposleni_list.getLocation().getY() - zaposleni_label.getSize().getHeight() - 5));
        zaposleni_label.setVisible(true);
        zaposleni_label.setForeground(Color.WHITE);
        frame.add(zaposleni_label);

        JButton clear_btn = new JButton("Clear");
        clear_btn.setSize(100, 50);
        clear_btn.setLocation((int)(username_field.getLocation().getX() + username_field.getSize().getWidth()) + 10, (int)(username_field.getLocation().getY()));
        clear_btn.setBorderPainted(false);
        clear_btn.setVisible(true);
        frame.add(clear_btn);
        clear_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    model.removeAllElements();
                    name_field.setText(null);
                    surname_field.setText(null);
                    username_field.setText(null);
                } catch (Exception ex) {
                    System.out.println("clear button action listener:: "+ex.getMessage());
                }   
            }
        });

        ogrozena_box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    Object selected = null;
                    selected = ogrozena_box.getSelectedIndex();
                } catch (Exception ex) {
                    System.out.println("ogrozena_box action listener:: "+ex.getMessage());
                }
            }
        });
        ogrozena_box.setEnabled(false);
        frame.add(ogrozena_box);

        JButton save_zivali_btn = new JButton("Save");
        save_zivali_btn.setSize(250, 50);
        save_zivali_btn.setLocation((int)ogrozena_box.getLocation().getX(), (int)(ogrozena_box.getLocation().getY() + ogrozena_box.getSize().getHeight()*2 + 20));
        save_zivali_btn.setBackground(Color.WHITE);
        save_zivali_btn.setBorderPainted(false);
        save_zivali_btn.setVisible(true);
        save_zivali_btn.setEnabled(false);
        frame.add(save_zivali_btn);
        save_zivali_btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    
                    List<String> formated = new ArrayList<>();
                    if(!model_zivali.isEmpty())
                    {
                        formated = Arrays.asList(model_zivali.get(zivali_list.getSelectedIndex()).split(" ")); 
                    }

                    Addons.updateZival(formated.get(0), name_field_zivali.getText(), vrsta_field.getText(), ogrozena_box.getSelectedIndex());

                } catch (Exception ex) {
                    System.out.println("save_btn action listener:: "+ex.getMessage());
                }
            }
        });

        JButton unlock_zivali_btn = new JButton("Unlock");
        unlock_zivali_btn.setSize(250, 50);
        unlock_zivali_btn.setLocation((int)ogrozena_box.getLocation().getX(), (int)(ogrozena_box.getLocation().getY() + ogrozena_box.getSize().getHeight() + 10));
        unlock_zivali_btn.setBackground(Color.WHITE);
        unlock_zivali_btn.setBorderPainted(false);
        unlock_zivali_btn.setVisible(true);
        frame.add(unlock_zivali_btn);
        unlock_zivali_btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    
                    name_field_zivali.setEnabled(true);
                    vrsta_field.setEnabled(true);
                    ogrozena_box.setEnabled(true);
                    save_zivali_btn.setEnabled(true);

                } catch (Exception ex) {
                    System.out.println("unlock_zivali_btn Action listener:: "+ex.getMessage());
                }
            }
        });

        zivali_list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0)
            {
                    

                    List<String> formated = new ArrayList<>();
                    if(!model_zivali.isEmpty())
                    {
                        formated = Arrays.asList(model_zivali.get(zivali_list.getSelectedIndex()).split(" ")); 
                    }

                    if(Addons.getOgrozena(name_field_zivali.getText()) == 1)
                    {
                        ogrozena_box.setSelectedItem("1");
                    }
                    else
                    {
                        ogrozena_box.setSelectedItem("0");
                    }

                    if(!formated.isEmpty())
                    {
                        name_field_zivali.setText(formated.get(0));
                        vrsta_field.setText(Addons.getVrstaZivali(formated.get(0)));

                        name_field_zivali.setEnabled(false);
                        vrsta_field.setEnabled(false);
                        ogrozena_box.setEnabled(false);
                        save_zivali_btn.setEnabled(false);
                    }
            }
        });

        JLabel zivali_label = new JLabel();
        zivali_label.setText("Živali");
        zivali_label.setSize(90, 25);
        zivali_label.setLocation((int)zivali_list.getLocation().getX(), (int)(zivali_list.getLocation().getY() - zivali_label.getSize().getHeight() - 5));
        zivali_label.setVisible(true);
        zivali_label.setForeground(Color.WHITE);
        frame.add(zivali_label);



        if(Addons.getDarkMode() == 1)
        {
            box.setForeground(Color.WHITE);
            box.setBackground(Color.darkGray);
            box.getEditor().getEditorComponent().setBackground(Color.darkGray);
        }
        frame.add(box);

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
