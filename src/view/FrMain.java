package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import utils.gui.TabbedPane;
import utils.gui.ToolBar;

@SuppressWarnings("all")
public class FrMain extends JFrame implements MouseListener,ActionListener{

	private JPanel contentPane;

	private JMenu jmSystem;
    private JMenu jmActivity;
    private JMenu jmWarehouse;
    private JMenu jmPrecious;
    private JMenu jmPersonel;
    private JMenu jmManager;
    private JMenu jmHelp;
    
    private ToolBar standart;
    private JTabbedPane tabHome;
    private TabbedPane tabRoom;
    private TabbedPane tabUser;
    private TabbedPane tabBooking;
    private TabbedPane tabService;
    
    private JMenuBar mb;
    
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    
    private JLabel txtWelcome;
    private JLabel txtAdmin;
    
    private Panel bottom;
    
    private JPanel Center;
    private JPanel Top;
    private JPanel Bottom;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		/* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FrMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FrMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FrMain.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrMain frame = new FrMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		// Initial component when you drag and drop
		initComponents();
		
		this.setTitle("PHẦN MỀM TIỆM INTERNET CÔNG CỘNG");
        this.setLocationRelativeTo(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Center = new JPanel();
		contentPane.add(Center, BorderLayout.CENTER);
		
		Top = new JPanel();
		contentPane.add(Top, BorderLayout.NORTH);
		
		Bottom = new JPanel();
		FlowLayout flowLayout = (FlowLayout) Bottom.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(Bottom, BorderLayout.SOUTH);
		
		initMenu();
        initMenuItem();
        initToolbar();
        initCenter();
        initBottom();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		
	}

	private void initBottom() {
		// TODO Auto-generated method stub
		bottom = new Panel();
        bottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        txtWelcome = new JLabel();
        txtWelcome.setFont(new Font("Tahoma", Font.BOLD, 12)); 
        txtWelcome.setText("Tài khoản: ");
        bottom.add(txtWelcome);
        
        txtAdmin = new JLabel();
        txtAdmin.setFont(new Font("Tahoma", Font.BOLD, 12)); 
        txtAdmin.setText("Admin");
        bottom.add(txtAdmin);

        Bottom.add(bottom, BorderLayout.CENTER);
	}

	private void initCenter() {
		// TODO Auto-generated method stub
		tabHome = new JTabbedPane();
        tabHome.setFont(new Font("Tahoma", Font.BOLD, 12));
        tabHome.setBorder(BorderFactory.createEmptyBorder());
        Center.setLayout(new BorderLayout());
        Center.add(tabHome,BorderLayout.CENTER);
        initTabJpanelBar(tabHome,1);
	}

	private void initTabJpanelBar(JTabbedPane tab, int select) {
		// TODO Auto-generated method stub
		if(select==1){
            tab.add("<html><p style=\"color:#88551a\">Sử dụng dịch vụ</p></html>",new PnHome());
        }else if(select==2){
            tab.add("<html><p style=\"color:#88551a\">Quản lý phiên người dùng&nbsp;&nbsp;&nbsp;&nbsp;</p></html>",new PnUser());
        }else if(select==3){
            tab.add("<html><p style=\"color:#88551a\">Quản lý máy&nbsp;&nbsp;&nbsp;&nbsp;</p></html>",new PnMay());
        }else if(select==4){
            tab.add("<html><p style=\"color:#88551a\">Quản lý dịch vụ&nbsp;&nbsp;&nbsp;&nbsp;</p></html>",new PnDichVu());
        }else if(select==5){
            tab.add("<html><p style=\"color:#88551a\">Quản lý quản trị viên&nbsp;&nbsp;&nbsp;&nbsp;</p></html>",new PnQTV());
        }
	}

	private void initToolbar() {
		// TODO Auto-generated method stub
		Top.setLayout(new BorderLayout());
        standart = new ToolBar();
        standart.setRollover(true);
        standart.setFloatable(true);
        initCompnentToolBar(standart);
        Top.add(standart);
	}

	private void initCompnentToolBar(ToolBar standart2) {
		// TODO Auto-generated method stub
		btn1 = new JButton("Sử dụng dịch vụ");
        btn1.setFont(new Font("Tahoma",Font.BOLD,12));
        btn1.setForeground(Color.decode("#132c4c"));
        btn1.setFocusable(false);
        btn1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/service.png")));
        btn1.setContentAreaFilled(false);
        btn1.setForeground(Color.red);
        btn1.setEnabled(false);
        standart.add(btn1);
        
        btn2 = new JButton("Quản lý phiên người dùng");
        btn2.setFont(new Font("Tahoma",Font.BOLD,12));
        btn2.setForeground(Color.decode("#132c4c"));
        btn2.setFocusable(false);
        btn2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/room1.png")));
        btn2.setContentAreaFilled(false);
        standart.add(btn2);
        
        btn3 = new JButton("Quản lý máy");
        btn3.setFont(new Font("Tahoma",Font.BOLD,12));
        btn3.setForeground(Color.decode("#132c4c"));
        btn3.setFocusable(false);
        btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer1.png")));
        btn3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn3.setContentAreaFilled(false);
        standart.add(btn3);
        
        btn4 = new JButton("Quản lý dịch vụ");
        btn4.setFont(new Font("Tahoma",Font.BOLD,12));
        btn4.setForeground(Color.decode("#132c4c"));
        btn4.setFocusable(false);
        btn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bed.png")));
        btn4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn4.setContentAreaFilled(false);
        standart.add(btn4);
        
        btn5 = new JButton("Quản lý quản trị viên");
        btn5.setFont(new Font("Tahoma",Font.BOLD,12));
        btn5.setForeground(Color.decode("#132c4c"));
        btn5.setFocusable(false);
        btn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/service.png")));
        btn5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn5.setContentAreaFilled(false);
        standart.add(btn5);
        
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn1.setForeground(Color.red);
                btn1.setEnabled(false);
                
                btn2.setEnabled(true);
                btn2.setForeground(Color.decode("#132c4c"));
                btn3.setEnabled(true);
                btn3.setForeground(Color.decode("#132c4c"));
                btn4.setEnabled(true);
                btn4.setForeground(Color.decode("#132c4c"));
                btn5.setEnabled(true);
                btn5.setForeground(Color.decode("#132c4c"));
                
                tabHome = new JTabbedPane();
                tabHome.setFont(new Font("Tahoma", Font.BOLD, 12));
                tabHome.setBorder(BorderFactory.createEmptyBorder());
                Center.removeAll();
                Center.setLayout(new BorderLayout());
                Center.add(tabHome,BorderLayout.CENTER);
                initTabJpanelBar(tabHome,1);
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn2.setForeground(Color.red);
                btn2.setEnabled(false);
                
                btn1.setEnabled(true);
                btn1.setForeground(Color.decode("#132c4c"));
                btn3.setEnabled(true);
                btn3.setForeground(Color.decode("#132c4c"));
                btn4.setEnabled(true);
                btn4.setForeground(Color.decode("#132c4c"));
                btn5.setEnabled(true);
                btn5.setForeground(Color.decode("#132c4c"));
                
                // comment
                tabRoom = new TabbedPane();
                tabRoom.setFont(new Font("Tahoma", Font.BOLD, 12));
                tabRoom.setBorder(BorderFactory.createEmptyBorder());
                Center.removeAll();
                Center.setLayout(new BorderLayout());
                Center.add(tabRoom,BorderLayout.CENTER);
                initTabJpanelBar(tabRoom,2);
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn3.setForeground(Color.red);
                btn3.setEnabled(false);
                
                btn1.setEnabled(true);
                btn1.setForeground(Color.decode("#132c4c"));
                btn2.setEnabled(true);
                btn2.setForeground(Color.decode("#132c4c"));
                btn4.setEnabled(true);
                btn4.setForeground(Color.decode("#132c4c"));
                btn5.setEnabled(true);
                btn5.setForeground(Color.decode("#132c4c"));
                
                // comment
                tabUser = new TabbedPane();
                tabUser.setFont(new Font("Tahoma", Font.BOLD, 12));
                tabUser.setBorder(BorderFactory.createEmptyBorder());
                Center.removeAll();
                Center.setLayout(new BorderLayout());
                Center.add(tabUser,BorderLayout.CENTER);
                initTabJpanelBar(tabUser,3);
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn4.setForeground(Color.red);
                btn4.setEnabled(false);
                
                btn1.setEnabled(true);
                btn1.setForeground(Color.decode("#132c4c"));
                btn2.setEnabled(true);
                btn2.setForeground(Color.decode("#132c4c"));
                btn3.setEnabled(true);
                btn3.setForeground(Color.decode("#132c4c"));
                btn5.setEnabled(true);
                btn5.setForeground(Color.decode("#132c4c"));
                
                // comment
                tabBooking = new TabbedPane();
                tabBooking.setFont(new Font("Tahoma", Font.BOLD, 12));
                tabBooking.setBorder(BorderFactory.createEmptyBorder());
                Center.removeAll();
                Center.setLayout(new BorderLayout());
                Center.add(tabBooking,BorderLayout.CENTER);
                initTabJpanelBar(tabBooking,4);
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn5.setForeground(Color.red);
                btn5.setEnabled(false);
                
                btn1.setEnabled(true);
                btn1.setForeground(Color.decode("#132c4c"));
                btn2.setEnabled(true);
                btn2.setForeground(Color.decode("#132c4c"));
                btn3.setEnabled(true);
                btn3.setForeground(Color.decode("#132c4c"));
                btn4.setEnabled(true);
                btn4.setForeground(Color.decode("#132c4c"));
                
                // comment
                tabService = new TabbedPane();
                tabService.setFont(new Font("Tahoma", Font.BOLD, 12));
                tabService.setBorder(BorderFactory.createEmptyBorder());
                Center.removeAll();
                Center.setLayout(new BorderLayout());
                Center.add(tabService,BorderLayout.CENTER);
                initTabJpanelBar(tabService,5);
            }
        });
	}

	private void initMenuItem() {
		// TODO Auto-generated method stub
		// jmSystem => View All Room, Logout and Exit
        JMenuItem jmSys1 = new JMenuItem();
        jmSys1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jmSys1.setText("Danh sách các phòng");
        jmSys1.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, InputEvent.CTRL_MASK));
        jmSys1.setIcon(new ImageIcon(getClass().getResource("/images/room.png"))); 
        jmSystem.add(jmSys1);
        
        JMenuItem jmSys2 = new JMenuItem();
        jmSys2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jmSys2.setText("Đăng xuất");
        jmSys2.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, InputEvent.CTRL_MASK));
        jmSys2.setIcon(new ImageIcon(getClass().getResource("/images/logout.png"))); 
        jmSystem.add(jmSys2);
        
        // http://icons.iconarchive.com + 16bit
        JMenuItem jmSys3 = new JMenuItem();
        jmSys3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jmSys3.setText("Thoát");
        jmSys3.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, InputEvent.CTRL_MASK));
        jmSys3.setIcon(new ImageIcon(getClass().getResource("/images/exit.png"))); 
        jmSystem.add(jmSys3);
        
        // jmActivity => Đăng ký, Đặt phòng, Kiểm tra
        JMenuItem jmAct1 = new JMenuItem();
        jmAct1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jmAct1.setText("Đăng ký");
        jmAct1.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, InputEvent.CTRL_MASK));
        jmAct1.setIcon(new ImageIcon(getClass().getResource("/images/check_in.png"))); 
        jmActivity.add(jmAct1);
        
        JMenuItem jmAct2 = new JMenuItem();
        jmAct2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jmAct2.setText("Đặt phòng");
        jmAct2.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, InputEvent.CTRL_MASK));
        jmAct2.setIcon(new ImageIcon(getClass().getResource("/images/booking.png"))); 
        jmActivity.add(jmAct2);
        
        JMenuItem jmAct3 = new JMenuItem();
        jmAct3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jmAct3.setText("Kiểm tra");
        jmAct3.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, InputEvent.CTRL_MASK));
        jmAct3.setIcon(new ImageIcon(getClass().getResource("/images/checkout.png"))); 
        jmActivity.add(jmAct3);
        
        // jmWarehouse => Checking + Booking
        JMenuItem jmWare1 = new JMenuItem();
        jmWare1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jmWare1.setText("Đăng ký");
        jmWare1.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_7, InputEvent.CTRL_MASK));
        jmWare1.setIcon(new ImageIcon(getClass().getResource("/images/booking.png"))); 
        jmWarehouse.add(jmWare1);
        
        JMenuItem jmWare2 = new JMenuItem();
        jmWare2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jmWare2.setText("Đăng ký");
        jmWare2.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_8, InputEvent.CTRL_MASK));
        jmWare2.setIcon(new ImageIcon(getClass().getResource("/images/checkout.png"))); 
        jmWarehouse.add(jmWare2);
        
        // jmPrecious => Information Customer,Set Room Price, Room Information
        JMenuItem jmPre1 = new JMenuItem();
        jmPre1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jmPre1.setText("Thông tin khách hàng");
        jmPre1.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_9, InputEvent.CTRL_MASK));
        jmPre1.setIcon(new ImageIcon(getClass().getResource("/images/customer.png"))); 
        jmPrecious.add(jmPre1);
        
        JMenuItem jmPre2 = new JMenuItem();
        jmPre2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jmPre2.setText("Thiết lập giá phòng");
        jmPre2.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, InputEvent.CTRL_MASK));
        jmPre2.setIcon(new ImageIcon(getClass().getResource("/images/price.png"))); 
        jmPrecious.add(jmPre2);
        
        JMenuItem jmPre3 = new JMenuItem();
        jmPre3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jmPre3.setText("Thông tin phòng");
        jmPre3.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, InputEvent.CTRL_MASK));
        jmPre3.setIcon(new ImageIcon(getClass().getResource("/images/roomdetail.png"))); 
        jmPrecious.add(jmPre3);
        
        //jmPersonal => Set Up User,Change Username/Password
        JMenuItem jmPer1 = new JMenuItem();
        jmPer1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jmPer1.setText("Thiết lập người dùng");
        jmPer1.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, InputEvent.CTRL_MASK));
        jmPer1.setIcon(new ImageIcon(getClass().getResource("/images/user.png"))); 
        jmPersonel.add(jmPer1);
        
        JMenuItem jmPer2 = new JMenuItem();
        jmPer2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jmPer2.setText("Thay đổi username và password");
        jmPer2.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, InputEvent.CTRL_MASK));
        jmPer2.setIcon(new ImageIcon(getClass().getResource("/images/password.png"))); 
        jmPersonel.add(jmPer2);
        
        //jManager => Check in/Book ing/ Check out
        JMenuItem jmMa1 = new JMenuItem();
        jmMa1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jmMa1.setText("Đăng ký tài khoản");
        jmMa1.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, InputEvent.CTRL_MASK));
        jmMa1.setIcon(new ImageIcon(getClass().getResource("/images/password.png"))); 
        jmManager.add(jmMa1);
        
        JMenuItem jmMa2 = new JMenuItem();
        jmMa2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jmMa2.setText("Đặt phòng");
        jmMa2.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, InputEvent.CTRL_MASK));
        jmMa2.setIcon(new ImageIcon(getClass().getResource("/images/password.png"))); 
        jmManager.add(jmMa2);
        
        JMenuItem jmMa3 = new JMenuItem();
        jmMa3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jmMa3.setText("Kiểm tra phòng");
        jmMa3.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, InputEvent.CTRL_MASK));
        jmMa3.setIcon(new ImageIcon(getClass().getResource("/images/password.png"))); 
        jmManager.add(jmMa3);
	}

	private void initMenu() {
		// TODO Auto-generated method stub
		mb = new JMenuBar();
        
        jmSystem = new JMenu();
        jmSystem.setText("Hệ thống");
        jmSystem.addMouseListener(this);
        mb.add(jmSystem);
        
        jmActivity = new JMenu();
        jmActivity.setText("<html><p style=\"color:#2a4280; font-weight:bold; padding: 4px 4px;\">Giao dịch</p></html>");
        jmActivity.addMouseListener(this);
        mb.add(jmActivity);
        
        jmWarehouse = new JMenu();
        jmWarehouse.setText("<html><p style=\"color:#2a4280; font-weight:bold; padding: 4px 4px;\">Tìm kiếm</p></html>");
        jmWarehouse.addMouseListener(this);
        mb.add(jmWarehouse);
        
        jmPrecious = new JMenu();
        jmPrecious.setText("<html><p style=\"color:#2a4280; font-weight:bold; padding: 4px 4px;\">Tiện ích</p></html>");
        jmPrecious.addMouseListener(this);
        mb.add(jmPrecious);
        
        jmPersonel = new JMenu();
        jmPersonel.setText("<html><p style=\"color:#2a4280; font-weight:bold; padding: 4px 4px;\">Bảo mật</p></html>");
        jmPersonel.addMouseListener(this);
        mb.add(jmPersonel);
        
        jmManager = new JMenu();
        jmManager.setText("<html><p style=\"color:#2a4280; font-weight:bold; padding: 4px 4px;\">Báo cáo</p></html>");
        jmManager.addMouseListener(this);
        mb.add(jmManager);
        
        jmHelp = new JMenu();
        jmHelp.setText("<html><p style=\"color:#2a4280; font-weight:bold; padding: 4px 4px;\">Trợ giúp</p></html>");
        jmHelp.addMouseListener(this);
        mb.add(jmHelp);
        
        this.setJMenuBar(mb);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JMenu jmX = (JMenu)arg0.getSource();
        if(jmX.equals(jmSystem)){
            jmX.setSelected(true);
        }else if(jmX.equals(jmActivity)){
            jmX.setSelected(true);
        }else if(jmX.equals(jmWarehouse)){
            jmX.setSelected(true);
        }else if(jmX.equals(jmPrecious)){
            jmX.setSelected(true);
        }else if(jmX.equals(jmPersonel)){
            jmX.setSelected(true);
        }else if(jmX.equals(jmManager)){
            jmX.setSelected(true);
        }else if(jmX.equals(jmHelp)){
            jmX.setSelected(true);
        }
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JMenu jmX = (JMenu)arg0.getSource();
        if(jmX.equals(jmSystem)){
            jmX.setSelected(false);
        }else if(jmX.equals(jmActivity)){
            jmX.setSelected(false);
        }else if(jmX.equals(jmWarehouse)){
            jmX.setSelected(false);
        }else if(jmX.equals(jmPrecious)){
            jmX.setSelected(false);
        }else if(jmX.equals(jmPersonel)){
            jmX.setSelected(false);
        }else if(jmX.equals(jmManager)){
            jmX.setSelected(false);
        }else if(jmX.equals(jmHelp)){
            jmX.setSelected(false);
        }
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
