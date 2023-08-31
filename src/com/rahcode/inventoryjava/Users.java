package com.rahcode.inventoryjava;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.FontFormatException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Users extends JFrame{
    private JPanel contentPane;
    private JPanel panelBar;
    private JPanel panelMain;
    private JPanel panelFooter;
    private JPanel panelLogin;
    private JTextField login_user_input;
    private JPasswordField login_password_input;
    private JPanel panelRegister;
    private JTextField register_user_input;
    private JPasswordField register_password_input;
    private JPasswordField register_confirm_input;
    private JPanel panelNav;
    private JPanel panelUser;
    private JTextField user_search;
    private JPanel panelTableUsers;
    private JPanel panelEditUser;
    private JTextField editUser_name_text;
    private JTextField editUser_pass_text;
    @SuppressWarnings("rawtypes")
    private JComboBox editUser_level_box;
    private JPanel panelAddUser;
    private JTextField addUser_name_text;
    private JTextField addUser_pass_text;
    @SuppressWarnings("rawtypes")
    private JComboBox addUser_level_box;
    private String[] priv={"Choose privilege","User","Admin","SuperUser"};
    private JPanel panelDocs;
    
    private App app=new App();
    private Products products=new Products();

    public Users(Boolean darkTheme){
        setIconImage(Toolkit.getDefaultToolkit().getImage("assets\\img\\perfil.png"));
        try{
            index(darkTheme);
        } catch (FontFormatException | IOException e){
            e.printStackTrace();
        }
    }

    public void index(Boolean darkTheme) throws FontFormatException,IOException{
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,0,1249,711);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panelBar = new JPanel();
        panelBar.setBackground(app.colors(darkTheme,9));
        panelBar.setBounds(0,0,1234,30);
        contentPane.add(panelBar);
        panelBar.setLayout(null);
        
        JLabel nav_logo = new JLabel("inventory.java");
        nav_logo.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                nav_logo.setForeground(app.colors(darkTheme,1));
            }
            @Override
            public void mouseExited(MouseEvent e){
                nav_logo.setForeground(app.colors(darkTheme,5));
            }
            @Override
            public void mouseClicked(MouseEvent e){
                app.createConfig(app.config()[0],app.config()[1],darkTheme,"1");
                refresh(darkTheme);
            }
        });
        nav_logo.setForeground(app.colors(darkTheme,5));
        nav_logo.setFont(app.fonts(2,16));
        nav_logo.setBounds(177,2,136,25);
        panelBar.add(nav_logo);

        JLabel change_theme = new JLabel("");
        change_theme.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                if(darkTheme){
                    change_theme.setIcon(new ImageIcon("assets\\icons\\brightness-activate.png"));
                }else{
                    change_theme.setIcon(new ImageIcon("assets\\icons\\moon-activate.png"));
                }
            }
            @Override
            public void mouseExited(MouseEvent e){
                if(darkTheme){
                    change_theme.setIcon(new ImageIcon("assets\\icons\\brightness.png"));
                }else{
                    change_theme.setIcon(new ImageIcon("assets\\icons\\moon.png"));
                }
            }
            @Override
            public void mouseClicked(MouseEvent e){
                app.createConfig(app.config()[0],app.config()[1],!darkTheme,app.config()[3]);
                refresh(!darkTheme);
            }
        });
        if(darkTheme){
            change_theme.setIcon(new ImageIcon("assets\\icons\\brightness.png"));
        }else{
            change_theme.setIcon(new ImageIcon("assets\\icons\\moon.png"));
        }
        change_theme.setBounds(1038,2,25,25);
        panelBar.add(change_theme);

        panelNav = new JPanel();
        panelNav.setBackground(app.colors(darkTheme,9));
        panelNav.setBounds(471,6,535,21);
        panelBar.add(panelNav);
        panelNav.setLayout(null);
        
        JLabel nav_link_1 = new JLabel("Users");
        nav_link_1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                nav_link_1.setForeground(app.colors(darkTheme,1));
            }
            @Override
            public void mouseExited(MouseEvent e){
                nav_link_1.setForeground(app.colors(darkTheme,5));
            }
            @Override
            public void mouseClicked(MouseEvent e){
                if(app.session(app.config()[0],app.config()[1],2)==3){
                    app.createConfig(app.config()[0],app.config()[1],darkTheme,"2");
                    refresh(darkTheme);
                }else{
                    app.auth();
                }
            }
        });
        nav_link_1.setForeground(app.colors(darkTheme,5));
        nav_link_1.setFont(app.fonts(2,14));
        nav_link_1.setBounds(332,0,39,21);
        panelNav.add(nav_link_1);
        
        JLabel nav_link_2 = new JLabel("Update");
        nav_link_2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                nav_link_2.setForeground(app.colors(darkTheme,1));
            }
            @Override
            public void mouseExited(MouseEvent e){
                nav_link_2.setForeground(app.colors(darkTheme,5));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                app.createConfig(app.config()[0],app.config()[1],darkTheme,"3");
                refresh(darkTheme);
            }
        });
        nav_link_2.setForeground(app.colors(darkTheme,5));
        nav_link_2.setFont(app.fonts(2,14));
        nav_link_2.setBounds(403,0,52,21);
        panelNav.add(nav_link_2);
        
        JLabel nav_link_3 = new JLabel("Logout");
        nav_link_3.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                app.createConfig(null,null,darkTheme,"1");
                System.exit(WIDTH);
            }
            @Override
            public void mouseEntered(MouseEvent e){
                nav_link_3.setForeground(app.colors(darkTheme,1));
            }
            @Override
            public void mouseExited(MouseEvent e){
                nav_link_3.setForeground(app.colors(darkTheme,5));
            }
        });
        nav_link_3.setForeground(app.colors(darkTheme,5));
        nav_link_3.setFont(app.fonts(2,14));
        nav_link_3.setBounds(487,0,48,21);
        panelNav.add(nav_link_3);
                
        panelMain = new JPanel();
        panelMain.setBackground(app.colors(darkTheme,9));
        panelMain.setBounds(0,30,1234,386);
        contentPane.add(panelMain);
        panelMain.setLayout(null);
        
        panelFooter = new JPanel();
        panelFooter.setBackground(app.colors(darkTheme,2));
        panelFooter.setBounds(0,416,1234,256);
        contentPane.add(panelFooter);
        panelFooter.setLayout(null);
        
        JLabel footer_title = new JLabel("App");
        footer_title.setForeground(Color.WHITE);
        footer_title.setFont(app.fonts(3,36));
        footer_title.setBounds(267,55,207,35);
        panelFooter.add(footer_title);
        
        JLabel footer_subtitle = new JLabel("by RAH Code");
        footer_subtitle.setForeground(Color.WHITE);
        footer_subtitle.setFont(app.fonts(1,14));
        footer_subtitle.setBounds(267,102,126,19);
        panelFooter.add(footer_subtitle);
        
        JLabel footer_link = new JLabel("Services");
        footer_link.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                footer_link.setForeground(app.colors(darkTheme,4));
            }
            @Override
            public void mouseExited(MouseEvent e){
                footer_link.setForeground(Color.WHITE);
            }
        });
        footer_link.setForeground(Color.WHITE);
        footer_link.setFont(app.fonts(1,16));
        footer_link.setBounds(480,46,83,21);
        panelFooter.add(footer_link);
        
        JLabel footer_link_1 = new JLabel("Portfolio");
        footer_link_1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                footer_link_1.setForeground(app.colors(darkTheme,4));
            }
            @Override
            public void mouseExited(MouseEvent e){
                footer_link_1.setForeground(Color.WHITE);
            }
        });
        footer_link_1.setForeground(Color.WHITE);
        footer_link_1.setFont(app.fonts(1,16));
        footer_link_1.setBounds(570,46,83,21);
        panelFooter.add(footer_link_1);
        
        JLabel footer_link_2 = new JLabel("Contactme");
        footer_link_2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                footer_link_2.setForeground(app.colors(darkTheme,4));
            }
            @Override
            public void mouseExited(MouseEvent e){
                footer_link_2.setForeground(Color.WHITE);
            }
        });
        footer_link_2.setForeground(Color.WHITE);
        footer_link_2.setFont(app.fonts(1,16));
        footer_link_2.setBounds(660,46,104,21);
        panelFooter.add(footer_link_2);
        
        JLabel footer_social = new JLabel("");
        footer_social.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                footer_social.setIcon(new ImageIcon("assets\\icons\\github-alt-activate.png"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                footer_social.setIcon(new ImageIcon("assets\\icons\\github-alt.png"));
            }
        });
        footer_social.setIcon(new ImageIcon("assets\\icons\\github-alt.png"));
        footer_social.setBounds(768,49,20,20);
        panelFooter.add(footer_social);
        
        JLabel footer_social_1 = new JLabel("");
        footer_social_1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                footer_social_1.setIcon(new ImageIcon("assets\\icons\\blogger-alt-activate.png"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                footer_social_1.setIcon(new ImageIcon("assets\\icons\\blogger-alt.png"));
            }
        });
        footer_social_1.setIcon(new ImageIcon("assets\\icons\\blogger-alt.png"));
        footer_social_1.setBounds(808,49,20,20);
        panelFooter.add(footer_social_1);
        
        JLabel footer_social_2 = new JLabel("");
        footer_social_2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                footer_social_2.setIcon(new ImageIcon("assets\\icons\\arrow-activate.png"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                footer_social_2.setIcon(new ImageIcon("assets\\icons\\arrow.png"));
            }
        });
        footer_social_2.setIcon(new ImageIcon("assets\\icons\\arrow.png"));
        footer_social_2.setBounds(848,49,20,20);
        panelFooter.add(footer_social_2);
        
        JLabel footer_social_3 = new JLabel("");
        footer_social_3.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                footer_social_3.setIcon(new ImageIcon("assets\\icons\\facebook-f-activate.png"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                footer_social_3.setIcon(new ImageIcon("assets\\icons\\facebook-f.png"));
            }
        });
        footer_social_3.setIcon(new ImageIcon("assets\\icons\\facebook-f.png"));
        footer_social_3.setBounds(888,49,20,20);
        panelFooter.add(footer_social_3);
        
        JLabel footer_social_4 = new JLabel("");
        footer_social_4.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                footer_social_4.setIcon(new ImageIcon("assets\\icons\\instagram-activate.png"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                footer_social_4.setIcon(new ImageIcon("assets\\icons\\instagram.png"));
            }
        });
        footer_social_4.setIcon(new ImageIcon("assets\\icons\\instagram.png"));
        footer_social_4.setBounds(768,76,20,20);
        panelFooter.add(footer_social_4);
        
        JLabel footer_social_5 = new JLabel("");
        footer_social_5.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                footer_social_5.setIcon(new ImageIcon("assets\\icons\\twitter-alt-activate.png"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                footer_social_5.setIcon(new ImageIcon("assets\\icons\\twitter-alt.png"));
            }
        });
        footer_social_5.setIcon(new ImageIcon("assets\\icons\\twitter-alt.png"));
        footer_social_5.setBounds(808,76,20,20);
        panelFooter.add(footer_social_5);
        
        JLabel footer_social_6 = new JLabel("");
        footer_social_6.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                footer_social_6.setIcon(new ImageIcon("assets\\icons\\youtube-activate.png"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                footer_social_6.setIcon(new ImageIcon("assets\\icons\\youtube.png"));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        footer_social_6.setIcon(new ImageIcon("assets\\icons\\youtube.png"));
        footer_social_6.setBounds(848,76,20,20);
        panelFooter.add(footer_social_6);
        
        start(darkTheme);
    }

    public void start(Boolean darkTheme) throws FontFormatException,IOException{
        panelNav.setVisible(false);

        if(!app.usersDB.exists()){
            register(darkTheme);
        }else if(!app.userConfig.exists()){
            login(darkTheme);
        }else if(app.config()[0].equals("null")||app.config()[1].equals("null")){
            login(darkTheme);
        }else if(app.session(app.config()[0],app.config()[1],1)!=2){
            login(darkTheme);
        }else if(app.config()[3].equals("2")){
            if(app.session(app.config()[0],app.config()[1],2)==3){
                user(darkTheme);
            }else{
                app.auth();
                products(darkTheme);
            }
        }else if(app.config()[3].equals("3")){
            docs(darkTheme);
        }else{
            products(darkTheme);
        }
    }

    public void register(Boolean darkTheme) throws FontFormatException,IOException{
        panelRegister = new JPanel();
            panelRegister.setBackground(app.colors(darkTheme,9));
            panelRegister.setBounds(10,11,1214,364);
            panelMain.add(panelRegister);
            panelRegister.setLayout(null);
            
            JLabel register_title = new JLabel("Register");
            register_title.setHorizontalAlignment(SwingConstants.CENTER);
            register_title.setBounds(0,46,1214,55);
            register_title.setForeground(app.colors(darkTheme,5));
            register_title.setFont(app.fonts(3,36));
            panelRegister.add(register_title);
            
            JLabel register_subtitle = new JLabel("Create a SuperUser");
            register_subtitle.setHorizontalAlignment(SwingConstants.CENTER);
            register_subtitle.setBounds(0,97,1214,21);
            register_subtitle.setForeground(app.colors(darkTheme,6));
            register_subtitle.setFont(app.fonts(1,14));
            panelRegister.add(register_subtitle);
            
            JButton register_button = new JButton("Register");
            register_button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    rFile(darkTheme);
                }
            });
            register_button.setBounds(619,269,336,69);
            register_button.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e){
                    register_button.setBackground(app.colors(darkTheme,3));
                }
                @Override
                public void mouseExited(MouseEvent e){
                    register_button.setBackground(app.colors(darkTheme,1));
                }
            });
            register_button.setBackground(app.colors(darkTheme,1));
            register_button.setFont(app.fonts(2,16));
            register_button.setForeground(Color.WHITE);
            panelRegister.add(register_button);
            
            JPanel register_user = new JPanel();
            register_user.setBackground(app.colors(darkTheme,8));
            register_user.setBounds(259,176,336,69);
            panelRegister.add(register_user);
            register_user.setLayout(null);
            
            JLabel register_user_label = new JLabel("User");
            register_user_label.setBounds(10,5,316,23);
            register_user.add(register_user_label);
            register_user_label.setForeground(app.colors(darkTheme,6));
            register_user_label.setFont(app.fonts(1,16));
            
            register_user_input = new JTextField();
            register_user_input.setBackground(app.colors(darkTheme,8));
            register_user_input.setBounds(10,24,316,37);
            register_user.add(register_user_input);
            register_user_input.setForeground(app.colors(darkTheme,6));
            register_user_input.setFont(app.fonts(1,16));
            register_user_input.setColumns(10);
            register_user_input.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            
            JPanel register_password = new JPanel();
            register_password.setBackground(app.colors(darkTheme,8));
            register_password.setBounds(619,176,336,69);
            panelRegister.add(register_password);
            register_password.setLayout(null);
            
            JLabel register_password_label = new JLabel("Password");
            register_password_label.setBounds(10,5,316,23);
            register_password.add(register_password_label);
            register_password_label.setForeground(app.colors(darkTheme,6));
            register_password_label.setFont(app.fonts(1,16));
            
            register_password_input = new JPasswordField();
            register_password_input.setBackground(app.colors(darkTheme,8));
            register_password_input.setBounds(10,24,316,37);
            register_password.add(register_password_input);
            register_password_input.setForeground(app.colors(darkTheme,6));
            register_password_input.setFont(app.fonts(1,16));
            register_password_input.setBorder(javax.swing.BorderFactory.createEmptyBorder());

            JPanel register_confirm = new JPanel();
            register_confirm.setBackground(app.colors(darkTheme,8));
            register_confirm.setBounds(259,269,336,69);
            panelRegister.add(register_confirm);
            register_confirm.setLayout(null);
            
            JLabel register_confirm_label = new JLabel("Confirm password");
            register_confirm_label.setBounds(10,5,316,23);
            register_confirm.add(register_confirm_label);
            register_confirm_label.setForeground(app.colors(darkTheme,6));
            register_confirm_label.setFont(app.fonts(1,16));
            
            register_confirm_input = new JPasswordField();
            register_confirm_input.setBackground(app.colors(darkTheme,8));
            register_confirm_input.setBounds(10,24,316,37);
            register_confirm.add(register_confirm_input);
            register_confirm_input.setForeground(app.colors(darkTheme,6));
            register_confirm_input.setFont(app.fonts(1,16));
            register_confirm_input.setBorder(javax.swing.BorderFactory.createEmptyBorder());
    }

    public void login(Boolean darkTheme) throws FontFormatException,IOException{
        panelLogin = new JPanel();
        panelLogin.setBackground(app.colors(darkTheme,9));
        panelLogin.setBounds(10,11,1214,364);
        panelMain.add(panelLogin);
        panelLogin.setLayout(null);
        
        JLabel login_title = new JLabel("Login");
        login_title.setHorizontalAlignment(SwingConstants.CENTER);
        login_title.setBounds(0,46,1214,55);
        login_title.setForeground(app.colors(darkTheme,5));
        login_title.setFont(app.fonts(3,36));
        panelLogin.add(login_title);
        
        JLabel login_subtitle = new JLabel("If you don't have a user contact the administrator");
        login_subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        login_subtitle.setBounds(0,97,1214,21);
        login_subtitle.setForeground(app.colors(darkTheme,6));
        login_subtitle.setFont(app.fonts(1,14));
        panelLogin.add(login_subtitle);
        
        JButton login_button = new JButton("Login");
        login_button.setBounds(259,269,336,69);
        login_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                lFile(darkTheme);
            }
        });
        login_button.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                login_button.setBackground(app.colors(darkTheme,3));
            }
            @Override
            public void mouseExited(MouseEvent e){
                login_button.setBackground(app.colors(darkTheme,1));
            }
        });
        login_button.setBackground(app.colors(darkTheme,1));
        login_button.setFont(app.fonts(2,16));
        login_button.setForeground(Color.WHITE);
        panelLogin.add(login_button);
        
        JPanel login_user = new JPanel();
        login_user.setBackground(app.colors(darkTheme,8));
        login_user.setBounds(259,176,336,69);
        panelLogin.add(login_user);
        login_user.setLayout(null);
        
        JLabel login_user_label = new JLabel("User");
        login_user_label.setBounds(10,5,316,23);
        login_user.add(login_user_label);
        login_user_label.setForeground(app.colors(darkTheme,6));
        login_user_label.setFont(app.fonts(1,16));
        
        login_user_input = new JTextField();
        login_user_input.setBackground(app.colors(darkTheme,8));
        login_user_input.setBounds(10,24,316,37);
        login_user.add(login_user_input);
        login_user_input.setForeground(app.colors(darkTheme,6));
        login_user_input.setFont(app.fonts(1,16));
        login_user_input.setColumns(10);
        login_user_input.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
        JPanel login_password = new JPanel();
        login_password.setBackground(app.colors(darkTheme,8));
        login_password.setBounds(619,176,336,69);
        panelLogin.add(login_password);
        login_password.setLayout(null);
        
        JLabel login_password_label = new JLabel("Password");
        login_password_label.setBounds(10,5,316,23);
        login_password.add(login_password_label);
        login_password_label.setForeground(app.colors(darkTheme,6));
        login_password_label.setFont(app.fonts(1,16));
        
        login_password_input = new JPasswordField();
        login_password_input.setBackground(app.colors(darkTheme,8));
        login_password_input.setBounds(10,24,316,37);
        login_password.add(login_password_input);
        login_password_input.setForeground(app.colors(darkTheme,6));
        login_password_input.setFont(app.fonts(1,16));
        login_password_input.setBorder(javax.swing.BorderFactory.createEmptyBorder());
    }

    public void user(Boolean darkTheme) throws FontFormatException,IOException{
        navLinks(darkTheme);

        panelUser = new JPanel();
        panelUser.setBackground(app.colors(darkTheme,9));
        panelUser.setBounds(10,11,1214,364);
        panelMain.add(panelUser);
        panelUser.setLayout(null);
        
        JLabel user_title = new JLabel("users");
        user_title.setHorizontalAlignment(SwingConstants.CENTER);
        user_title.setBounds(0,46,1214,55);
        user_title.setFont(app.fonts(3,36));
        user_title.setForeground(app.colors(darkTheme,5));
        panelUser.add(user_title);
        
        JLabel user_subtitle = new JLabel("inventory.java");
        user_subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        user_subtitle.setBounds(0,97,1214,21);
        user_subtitle.setFont(app.fonts(1,14));
        user_subtitle.setForeground(app.colors(darkTheme,6));
        panelUser.add(user_subtitle);
        
        JButton user_button = new JButton("Add a user");
        user_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(app.session(app.config()[0],app.config()[1],2)>=2){
                    panelUser.setVisible(false);
                    try{
                        addUser(darkTheme);
                    } catch (FontFormatException | IOException e1){
                        e1.printStackTrace();
                    }
                }else{
                    app.auth();
                }
            }
        });
        user_button.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                user_button.setBackground(app.colors(darkTheme,3));
            }
            @Override
            public void mouseExited(MouseEvent e){
                user_button.setBackground(app.colors(darkTheme,1));
            }
        });
        user_button.setBounds(250,170,160,57);
        user_button.setBackground(app.colors(darkTheme,1));
        user_button.setForeground(Color.WHITE);
        user_button.setFont(app.fonts(2,16));
        panelUser.add(user_button);    

        JButton user_table_button = new JButton("View table");
        user_table_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panelUser.setVisible(false);
                try{
                    tableUsers(darkTheme);
                } catch (FontFormatException | IOException e1){
                    e1.printStackTrace();
                }
            }
        });
        user_table_button.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                user_table_button.setBackground(app.colors(darkTheme,3));
            }
            @Override
            public void mouseExited(MouseEvent e){
                user_table_button.setBackground(app.colors(darkTheme,1));
            }
        });
        user_table_button.setForeground(Color.WHITE);
        user_table_button.setFont(app.fonts(2,16));
        user_table_button.setBackground(app.colors(darkTheme,1));
        user_table_button.setBounds(480,170,160,57);
        panelUser.add(user_table_button);
        
        user_search = new JTextField();
        user_search.setBounds(250,290,218,57);
        user_search.setForeground(app.colors(darkTheme,6));
        user_search.setFont(app.fonts(1,16));
        user_search.setBackground(app.colors(darkTheme,8));
        panelUser.add(user_search);
        user_search.setColumns(10);
        user_search.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
        JButton user_search_button = new JButton("Search");
        user_search_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(searchUsers(user_search.getText(),2)==0){
                    JOptionPane.showMessageDialog(null,"User not found","M E S S A G E",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        user_search_button.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                user_search_button.setBackground(app.colors(darkTheme,3));
            }
            @Override
            public void mouseExited(MouseEvent e){
                user_search_button.setBackground(app.colors(darkTheme,1));
            }
        });
        user_search_button.setBounds(480,290,218,57);
        user_search_button.setFont(app.fonts(2,16));
        user_search_button.setBackground(app.colors(darkTheme,1));
        user_search_button.setForeground(Color.WHITE);
        panelUser.add(user_search_button);
    }

    public void tableUsers(Boolean darkTheme) throws FontFormatException,IOException{
        panelTableUsers = new JPanel();
        panelTableUsers.setBackground(app.colors(darkTheme,9));
        panelTableUsers.setBounds(10,11,1214,364);
        panelMain.add(panelTableUsers);
        panelTableUsers.setLayout(null);
        
        JScrollPane tableUsers_scroll = new JScrollPane();
        tableUsers_scroll.setBounds(0,0,1205,355);
        panelTableUsers.add(tableUsers_scroll);
        
        JTable tableUsers_table = new JTable();
        tableUsers_table.setSelectionForeground(app.colors(darkTheme,6));
        tableUsers_table.setSelectionBackground(app.colors(darkTheme,8));
        tableUsers_table.setRowHeight(62);
        tableUsers_table.setForeground(app.colors(darkTheme,6));
        tableUsers_table.setFont(app.fonts(1,16));
        tableUsers_table.setBackground(app.colors(darkTheme,9));
        tableUsers_table.setModel(new DefaultTableModel(
            new Object[][]{
                {"ID","USER","PASSWORD","LEVEL"}
            },
            new String[]{
                "","","",""
            }
        ));
        tableUsers_table.getColumnModel().getColumn(0).setMaxWidth(25);
        tableUsers_scroll.setViewportView(tableUsers_table);

        fillTableUsers((DefaultTableModel)tableUsers_table.getModel());
        
        JPanel tableUsers_info = new JPanel();
        tableUsers_info.setBackground(app.colors(darkTheme,9));
        tableUsers_scroll.setRowHeaderView(tableUsers_info);
        tableUsers_info.setLayout(new GridLayout(0,1,0,0));
        
        JButton tableUsers_info_button = new JButton("Edit");
        tableUsers_info_button.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                tableUsers_info_button.setBackground(app.colors(darkTheme,3));
            }
            @Override
            public void mouseExited(MouseEvent e){
                tableUsers_info_button.setBackground(app.colors(darkTheme,1));
            }
        });
        tableUsers_info_button.setForeground(Color.WHITE);
        tableUsers_info_button.setBackground(app.colors(darkTheme,1));
        tableUsers_info_button.setFont(app.fonts(2,16));
        tableUsers_info_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(app.session(app.config()[0],app.config()[1],2)==3){
                    String id=JOptionPane.showInputDialog(null,"Insert the ID of the user to edit","I N P U T",JOptionPane.QUESTION_MESSAGE);
                    panelTableUsers.setVisible(false);
                    try{
                        editUser(darkTheme,id);
                    } catch (FontFormatException | IOException e1){
                        e1.printStackTrace();
                    }
                }else{
                    app.auth();
                }
            }
        });
        tableUsers_info.add(tableUsers_info_button);
        
        JButton tableUsers_info_button_1 = new JButton("Delete");
        tableUsers_info_button_1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                tableUsers_info_button_1.setBackground(app.colors(darkTheme,3));
            }
            @Override
            public void mouseExited(MouseEvent e){
                tableUsers_info_button_1.setBackground(app.colors(darkTheme,1));
            }
        });
        tableUsers_info_button_1.setBackground(app.colors(darkTheme,1));
        tableUsers_info_button_1.setFont(app.fonts(2,16));
        tableUsers_info_button_1.setForeground(Color.WHITE);
        tableUsers_info_button_1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(app.session(app.config()[0],app.config()[1],2)>=2){
                    deleteUsers();
                }
                else{
                    app.auth();
                }
            }
        });
        tableUsers_info.add(tableUsers_info_button_1);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void addUser(Boolean darkTheme) throws FontFormatException,IOException{
        panelAddUser = new JPanel();
        panelAddUser.setBackground(app.colors(darkTheme,9));
        panelAddUser.setBounds(10,11,1214,364);
        panelAddUser.setLayout(null);
        panelMain.add(panelAddUser);
        
        JLabel addUser_title = new JLabel("Add");
        addUser_title.setHorizontalAlignment(SwingConstants.CENTER);
        addUser_title.setBounds(10,0,1214,55);
        addUser_title.setForeground(app.colors(darkTheme,5));
        addUser_title.setFont(app.fonts(3,36));
        panelAddUser.add(addUser_title);
        
        JLabel addUser_subtitle = new JLabel("User");
        addUser_subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        addUser_subtitle.setBounds(10,51,1214,21);
        addUser_subtitle.setForeground(app.colors(darkTheme,6));
        addUser_subtitle.setFont(app.fonts(1,14));
        panelAddUser.add(addUser_subtitle);
        
        JButton addUser_button = new JButton("Add");
        addUser_button.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                addUser_button.setBackground(app.colors(darkTheme,3));
            }
            @Override
            public void mouseExited(MouseEvent e){
                addUser_button.setBackground(app.colors(darkTheme,1));
            }
        });
        addUser_button.setBounds(629,223,336,69);
        addUser_button.setFont(app.fonts(2,16));
        addUser_button.setBackground(app.colors(darkTheme,1));
        addUser_button.setForeground(Color.WHITE);
        addUser_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Boolean addF=true;
                if(addUser_level_box.getSelectedIndex()==3){
                    addF=false;
                    if(JOptionPane.showConfirmDialog(null,"Are you sure you want to give this user SuperUser access?\n"+"SuperUsers cannot be edited","C O N F I R M",0)==0){
                        addF=true;
                    }
                }else if(addUser_level_box.getSelectedIndex()==0){
                    addUser_level_box.setSelectedIndex(1);
                }
                if(addF){
                    try{
                        newUser(id(app.usersDB),addUser_name_text.getText(),addUser_pass_text.getText(),String.valueOf(addUser_level_box.getSelectedIndex()),app.usersDB);
                    } catch (IOException e1){
                        e1.printStackTrace();
                    }
        
                    panelAddUser.setVisible(false);
                    panelUser.setVisible(true);
                }
            }
        });
        panelAddUser.add(addUser_button);

        JPanel addUser_name = new JPanel();
        addUser_name.setBounds(269,130,336,69);
        addUser_name.setBackground(app.colors(darkTheme,8));
        panelAddUser.add(addUser_name);
        addUser_name.setLayout(null);
        
        JLabel addUser_name_label = new JLabel("Username");
        addUser_name_label.setBounds(10,5,316,23);
        addUser_name.add(addUser_name_label);
        addUser_name_label.setForeground(app.colors(darkTheme,6));
        addUser_name_label.setFont(app.fonts(1,16));
        
        addUser_name_text = new JTextField();
        addUser_name_text.setBounds(10,24,316,37);
        addUser_name.add(addUser_name_text);
        addUser_name_text.setFont(app.fonts(1,16));
        addUser_name_text.setBackground(app.colors(darkTheme,8));
        addUser_name_text.setForeground(app.colors(darkTheme,6));
        addUser_name_text.setColumns(10);
        addUser_name_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
        JPanel addUser_pass = new JPanel();
        addUser_pass.setBounds(629,130,336,69);
        addUser_pass.setBackground(app.colors(darkTheme,8));
        panelAddUser.add(addUser_pass);
        addUser_pass.setLayout(null);
        
        JLabel addUser_pass_label = new JLabel("Password");
        addUser_pass_label.setBounds(10,5,316,23);
        addUser_pass.add(addUser_pass_label);
        addUser_pass_label.setForeground(app.colors(darkTheme,6));
        addUser_pass_label.setFont(app.fonts(1,16));
        
        addUser_pass_text = new JTextField();
        addUser_pass_text.setBounds(10,24,316,37);
        addUser_pass.add(addUser_pass_text);
        addUser_pass_text.setForeground(app.colors(darkTheme,6));
        addUser_pass_text.setFont(app.fonts(1,16));
        addUser_pass_text.setBackground(app.colors(darkTheme,8));
        addUser_pass_text.setColumns(10);
        addUser_pass_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
        JPanel addUser_level = new JPanel();
        addUser_level.setBounds(269,223,336,69);
        addUser_level.setBackground(app.colors(darkTheme,8));
        panelAddUser.add(addUser_level);
        addUser_level.setLayout(null);
        
        JLabel addUser_level_label = new JLabel("Level");
        addUser_level_label.setBounds(10,5,316,23);
        addUser_level.add(addUser_level_label);
        addUser_level_label.setForeground(app.colors(darkTheme,6));
        addUser_level_label.setFont(app.fonts(1,16));
        
        addUser_level_box = new JComboBox();
        addUser_level_box.setFocusable(false);
        addUser_level_box.setModel(new DefaultComboBoxModel(priv));
        addUser_level_box.setBackground(app.colors(darkTheme,8));
        addUser_level_box.setForeground(app.colors(darkTheme,6));
        addUser_level_box.setFont(app.fonts(1,16));
        addUser_level_box.setBounds(10,24,316,37);
        addUser_level.add(addUser_level_box);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void editUser(Boolean darkTheme,String id) throws FontFormatException,IOException{
        panelEditUser = new JPanel();
        panelEditUser.setBackground(app.colors(darkTheme,9));
        panelEditUser.setBounds(10,11,1214,364);
        panelEditUser.setLayout(null);
        panelMain.add(panelEditUser);
        
        JLabel editUser_title = new JLabel("Edit");
        editUser_title.setHorizontalAlignment(SwingConstants.CENTER);
        editUser_title.setBounds(10,0,1214,55);
        editUser_title.setForeground(app.colors(darkTheme,5));
        editUser_title.setFont(app.fonts(3,36));
        panelEditUser.add(editUser_title);
        
        JLabel editUser_subtitle = new JLabel("User");
        editUser_subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        editUser_subtitle.setBounds(10,51,1214,21);
        editUser_subtitle.setForeground(app.colors(darkTheme,6));
        editUser_subtitle.setFont(app.fonts(1,14));
        panelEditUser.add(editUser_subtitle);
        
        JButton editUser_button = new JButton("Edit");
        editUser_button.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                editUser_button.setBackground(app.colors(darkTheme,3));
            }
            @Override
            public void mouseExited(MouseEvent e){
                editUser_button.setBackground(app.colors(darkTheme,1));
            }
        });
        editUser_button.setBounds(629,223,336,69);
        editUser_button.setFont(app.fonts(2,16));
        editUser_button.setBackground(app.colors(darkTheme,1));
        editUser_button.setForeground(Color.WHITE);
        editUser_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Boolean addF=true;
                if(editUser_level_box.getSelectedIndex()==3){
                    addF=false;
                    if(JOptionPane.showConfirmDialog(null,"Are you sure you want to give this user SuperUser access?\n"+"SuperUsers cannot be edited","C O N F I R M",0)==0){
                        addF=true;
                    }
                }else if(editUser_level_box.getSelectedIndex()==0){
                    editUser_level_box.setSelectedIndex(1);
                }

                if(addF){
                    String[] args={id,editUser_name_text.getText()
                        ,editUser_pass_text.getText()
                        ,String.valueOf(editUser_level_box.getSelectedIndex())};
                    updUsers(args);
                    panelEditUser.setVisible(false);
                    panelUser.setVisible(true);
                }
    
            }
        });
        panelEditUser.add(editUser_button);

        JPanel editUser_name = new JPanel();
        editUser_name.setBounds(269,130,336,69);
        editUser_name.setBackground(app.colors(darkTheme,8));
        panelEditUser.add(editUser_name);
        editUser_name.setLayout(null);
        
        JLabel editUser_name_label = new JLabel("Username");
        editUser_name_label.setBounds(10,5,316,23);
        editUser_name.add(editUser_name_label);
        editUser_name_label.setForeground(app.colors(darkTheme,6));
        editUser_name_label.setFont(app.fonts(1,16));
        
        editUser_name_text = new JTextField();
        editUser_name_text.setBounds(10,24,316,37);
        editUser_name.add(editUser_name_text);
        editUser_name_text.setFont(app.fonts(1,16));
        editUser_name_text.setBackground(app.colors(darkTheme,8));
        editUser_name_text.setForeground(app.colors(darkTheme,6));
        editUser_name_text.setColumns(10);
        editUser_name_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
        JPanel editUser_pass = new JPanel();
        editUser_pass.setBounds(629,130,336,69);
        editUser_pass.setBackground(app.colors(darkTheme,8));
        panelEditUser.add(editUser_pass);
        editUser_pass.setLayout(null);
        
        JLabel editUser_pass_label = new JLabel("Password");
        editUser_pass_label.setBounds(10,5,316,23);
        editUser_pass.add(editUser_pass_label);
        editUser_pass_label.setForeground(app.colors(darkTheme,6));
        editUser_pass_label.setFont(app.fonts(1,16));
        
        editUser_pass_text = new JTextField();
        editUser_pass_text.setBounds(10,24,316,37);
        editUser_pass.add(editUser_pass_text);
        editUser_pass_text.setForeground(app.colors(darkTheme,6));
        editUser_pass_text.setFont(app.fonts(1,16));
        editUser_pass_text.setBackground(app.colors(darkTheme,8));
        editUser_pass_text.setColumns(10);
        editUser_pass_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
        JPanel editUser_level = new JPanel();
        editUser_level.setBounds(269,223,336,69);
        editUser_level.setBackground(app.colors(darkTheme,8));
        panelEditUser.add(editUser_level);
        editUser_level.setLayout(null);
        
        JLabel editUser_level_label = new JLabel("Level");
        editUser_level_label.setBounds(10,5,316,23);
        editUser_level.add(editUser_level_label);
        editUser_level_label.setForeground(app.colors(darkTheme,6));
        editUser_level_label.setFont(app.fonts(1,16));
        
        editUser_level_box = new JComboBox();
        editUser_level_box.setFocusable(false);
        editUser_level_box.setModel(new DefaultComboBoxModel(priv));
        editUser_level_box.setBackground(app.colors(darkTheme,8));
        editUser_level_box.setForeground(app.colors(darkTheme,6));
        editUser_level_box.setFont(app.fonts(1,16));
        editUser_level_box.setBounds(10,24,316,37);
        editUser_level.add(editUser_level_box);
    
        updateUsers(id);
    }

    public void docs(Boolean darkTheme) throws FontFormatException, IOException{
        navLinks(darkTheme);
        
        panelDocs = new JPanel();
        panelDocs.setBackground(app.colors(darkTheme,9));
        panelDocs.setBounds(10, 11, 1214, 364);
        panelMain.add(panelDocs);
        panelDocs.setLayout(null);
        
        JLabel docs_title = new JLabel("Inventory");
        docs_title.setBounds(258, 81, 270, 72);
        docs_title.setForeground(app.colors(darkTheme,5));
        docs_title.setFont(app.fonts(3,48));
        panelDocs.add(docs_title);
        
        JLabel docs_subtitle = new JLabel("JAVA");
        docs_subtitle.setBounds(258, 152, 270, 30);
        docs_subtitle.setForeground(app.colors(darkTheme,6));
        docs_subtitle.setFont(app.fonts(2,20));
        panelDocs.add(docs_subtitle);
        
        JLabel docs_description = new JLabel("An app to manage your inventory");
        docs_description.setBounds(258, 193, 270, 25);
        docs_description.setForeground(app.colors(darkTheme,6));
        docs_description.setFont(app.fonts(1,16));
        panelDocs.add(docs_description);
        
        JButton docs_button = new JButton("GitHub");
        docs_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.rahcode.com/inventory.java"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        docs_button.setBounds(258, 251, 103, 57);
        docs_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                docs_button.setBackground(app.colors(darkTheme,3));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                docs_button.setBackground(app.colors(darkTheme,1));
            }
        });
        docs_button.setBackground(app.colors(darkTheme,1));
        docs_button.setForeground(Color.WHITE);
        docs_button.setFont(app.fonts(2,16));
        panelDocs.add(docs_button);
        
        JLabel docs_img = new JLabel("");
        docs_img.setHorizontalAlignment(SwingConstants.CENTER);
        docs_img.setIcon(new ImageIcon("assets\\img\\perfil.png"));
        docs_img.setBounds(587, 49, 289, 259);
        panelDocs.add(docs_img);
        
        JLabel docs_blob = new JLabel("");
        docs_blob.setHorizontalAlignment(SwingConstants.CENTER);
        docs_blob.setIcon(new ImageIcon("assets\\img\\blob.png"));
        docs_blob.setBounds(538, 24, 387, 340);
        panelDocs.add(docs_blob);
    }

    public void navLinks(Boolean darkTheme) throws FontFormatException,IOException{
        panelNav.setVisible(true);
        
        JLabel nav_link = new JLabel("Hello \""+app.config()[0]+"\"");
        nav_link.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                nav_link.setForeground(app.colors(darkTheme,1));
            }
            @Override
            public void mouseExited(MouseEvent e){
                nav_link.setForeground(app.colors(darkTheme,5));
            }
        });
        nav_link.setBounds(0,0,300,21);
        nav_link.setHorizontalAlignment(SwingConstants.TRAILING);
        nav_link.setForeground(app.colors(darkTheme,5));
        nav_link.setFont(app.fonts(2,14));
        panelNav.add(nav_link);
    }

    public void products(Boolean darkTheme){
        try{
            navLinks(darkTheme);
            panelMain.add(products.index(darkTheme));
        } catch (FontFormatException | IOException e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
    public void rFile(Boolean darkTheme){
        String user=register_user_input.getText();
        String password=register_password_input.getText();
        String confirm=register_confirm_input.getText();
        if(!user.equals("")&&!password.equals("")&&!confirm.equals("")){
            if(password.equals(confirm)){
                if(!user.equals("null")&&!password.equals("null")){
                    try{
                        app.usersDB.createNewFile();
                        app.wri=new FileWriter(app.usersDB);
                    } catch (IOException e){
                        e.printStackTrace();
                    }
    
                    app.pri=new PrintWriter(app.wri);
                    app.pri.println("1\n"+user+"\n"+password+"\n"+"3");
                    app.pri.close();
                    
                    try{
                        app.wri.close();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
    
                    app.createConfig(user,password,darkTheme,"1");
                    panelRegister.setVisible(false);
                    products(darkTheme);
                }else{
                    JOptionPane.showMessageDialog(null,"The username or password 'null' is not valid","E R R O R",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null,"The passwords you entered do not match","E R R O R",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"All fields are required","E R R O R",JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("deprecation")
    public void lFile(Boolean darkTheme){
        String user=login_user_input.getText();
        String password=login_password_input.getText();
        int exist=app.session(user,password,1);
        if(!user.equals("")&&!password.equals("")){
                if(exist==2){
                    app.createConfig(user,password,darkTheme,"1");
                    panelLogin.setVisible(false);
                    products(darkTheme);
                }else{
                    JOptionPane.showMessageDialog(null,"The username or password you entered is incorrect","E R R O R",JOptionPane.ERROR_MESSAGE);
                }
        }else{
            JOptionPane.showMessageDialog(null,"All fields are required","E R R O R",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void fillTableUsers(DefaultTableModel model){
        String i=null,u=null,p=null,l=null;

        if(!app.usersDB.exists()){
            try{
                app.usersDB.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        try{
            app.rea=new FileReader(app.usersDB);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        app.buf=new BufferedReader(app.rea);

        do{
            try{
                i=app.buf.readLine();
                u=app.buf.readLine();
                p=app.buf.readLine();
                l=app.buf.readLine();
            } catch (IOException e){
                e.printStackTrace();
            }
            if(i!=null&&!l.equals("3")){
                model.addRow(new Object[]{i,u,p,l});
            }
        }while(i!=null);

        try{
            app.buf.close();
            app.rea.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void updateUsers(String idUpd){
        if(searchUsers(idUpd,1)==1){
            updateTextUsers(idUpd);
        }else{
            JOptionPane.showMessageDialog(null,"There is not a user with that ID","M E S S A G E",JOptionPane.ERROR_MESSAGE);
            panelEditUser.setVisible(false);
            panelTableUsers.setVisible(true);
        }
    }

    public int searchUsers(String sea,int op){
        String id=null,u=null,p=null,l=null;
        int found=0;

        try{
            app.rea=new FileReader(app.usersDB);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        app.buf=new BufferedReader(app.rea);

        do{
            try{
                id=app.buf.readLine();
                u=app.buf.readLine();
                p=app.buf.readLine();
                l=app.buf.readLine();
            } catch (IOException e){
                e.printStackTrace();
            }
            if(id!=null){
                if(op==1&&id.equals(sea)&&!l.equals("3")){
                    JOptionPane.showMessageDialog(null,
                    "User info:\n"
                    +"\nID: "+id
                    +"\nUSER: "+u
                    +"\nPASSWORD: "+p
                    +"\nLEVEL: "+l,
                    "U S E R",JOptionPane.INFORMATION_MESSAGE);
                    found=1;
                }
                if(op==2&&(u.contains(sea)&&!l.equals("3"))){
                    JOptionPane.showMessageDialog(null,
                    "User info:\n"
                    +"\nID: "+id
                    +"\nUSER: "+u
                    +"\nPASSWORD: "+p
                    +"\nLEVEL: "+l,
                    "U S E R",JOptionPane.INFORMATION_MESSAGE);
                    found=1;
                }
            }
        }while(id!=null);

        try{
            app.buf.close();
            app.rea.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        return(found);
    }

    public void updateTextUsers(String idSea){
        String id=null,u=null,p=null,l=null;

        try{
            app.rea=new FileReader(app.usersDB);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        app.buf=new BufferedReader(app.rea);

        do{
            try{
                id=app.buf.readLine();
                u=app.buf.readLine();
                p=app.buf.readLine();
                l=app.buf.readLine();
            } catch (IOException e){
                e.printStackTrace();
            }
            if(id!=null&&id.equals(idSea)){
                editUser_name_text.setText(u);
                editUser_pass_text.setText(p);
                editUser_level_box.setSelectedIndex(Integer.parseInt(l));
            }
        }while(id!=null);

        try{
            app.buf.close();
            app.rea.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void updUsers(String[] args){
        String id=null,u=null,p=null,l=null;

        try{
            app.rea=new FileReader(app.usersDB);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        app.buf=new BufferedReader(app.rea);

        do{
            try{
                id=app.buf.readLine();
                u=app.buf.readLine();
                p=app.buf.readLine();
                l=app.buf.readLine();
            } catch (IOException e){
                e.printStackTrace();
            }
            if(id!=null&&!id.equals(args[0])){
                try{
                    newUser(id,u,p,l,app.usersTEMP);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }else if(id!=null){
                int ok=1;
                try{
                    ok=newUser(args[0],args[1],args[2],args[3],app.usersTEMP);
                } catch (IOException e){
                    e.printStackTrace();
                }
                if(ok==0){
                    try{
                        newUser(id,u,p,l,app.usersTEMP);
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }while(id!=null);

        try{
            app.buf.close();
            app.rea.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null,"The user has been edited","M E S S A G E",JOptionPane.INFORMATION_MESSAGE);
        app.usersDB.delete();
        app.usersTEMP.renameTo(app.usersDB);
    }

    public int newUser(String id,String user,String pass,String level,File file) throws IOException{        
        if(!file.exists()){
            file.createNewFile();
        }
        
        app.wri=new FileWriter(file,true);
        app.pri=new PrintWriter(app.wri);
        
        app.pri.println(id+"\n"+user+"\n"+pass+"\n"+level);
        
        app.pri.close();
        app.wri.close();
        return(1);
    }

    public String id(File file){
        String id=null,newId="1";
        
        if(!file.exists()){
            try{
                file.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        try{
            app.rea=new FileReader(file);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        app.buf=new BufferedReader(app.rea);
        
        do{
            try{
                id=app.buf.readLine();
                app.buf.readLine();
                app.buf.readLine();
                app.buf.readLine();
            } catch (IOException e){
                e.printStackTrace();
            }
            if(id!=null){
                newId=String.valueOf(Integer.parseInt(id)+1);
            }
        }while(id!=null);

        try{
            app.buf.close();
            app.rea.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        return(newId);
    }

    public void deleteUsers(){
        String idDel=JOptionPane.showInputDialog(null,"Insert the ID of the user to delete","I N P U T",JOptionPane.QUESTION_MESSAGE);
        
        if(searchUsers(idDel,1)==1){
            if(JOptionPane.showConfirmDialog(null,"Do you want to delete this user?","C O N F I R M",0)==0){
                delUsers(idDel);
                JOptionPane.showMessageDialog(null,"The user has been deleted","M E S S A G E",JOptionPane.INFORMATION_MESSAGE);
                app.usersDB.delete();
                app.usersTEMP.renameTo(app.usersDB);
                panelTableUsers.setVisible(false);
                panelUser.setVisible(true);
            }
        }else{
            JOptionPane.showMessageDialog(null,"There is not a user with that ID","M E S S A G E",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void delUsers(String idDel){
        String id=null,u=null,p=null,l=null;

        try{
            app.rea=new FileReader(app.usersDB);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        app.buf=new BufferedReader(app.rea);

        do{
            try{
                id=app.buf.readLine();
                u=app.buf.readLine();
                p=app.buf.readLine();
                l=app.buf.readLine();
            } catch (IOException e){
                e.printStackTrace();
            }
            if(id!=null&&!id.equals(idDel)){
                try{
                    newUser(id,u,p,l,app.usersTEMP);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }while(id!=null);

        try{
            app.buf.close();
            app.rea.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void refresh(Boolean darkTheme){
        app.window(darkTheme);
        this.setVisible(false);
        this.dispose();
    }
}
