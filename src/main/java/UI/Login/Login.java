package UI.Login;

import UI.IntiJFrame;
import UI.identitySelection.IdentitySelection;
import data.readAndWriteFun.AdminReadAndWrite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends IntiJFrame implements ActionListener {
    
    //所用登录界面的父类，
    SpringLayout springLayout = new SpringLayout();
    JPanel centerJPanel = new JPanel(springLayout);
    JLabel titleJLabel = new JLabel();
    JLabel adminJLabel = new JLabel("账号:");
    JLabel passwordJLabel = new JLabel("密码:");
    JButton loginJButton = new JButton("登录");
    JButton quitJButton = new JButton();
    AdminReadAndWrite excelData =  new AdminReadAndWrite();
    JTextField adminJTextField = new JTextField();
    JPasswordField passwordJTextField = new JPasswordField();

    String admin = new String();
    String password = new String();


    public void setQuitJButton() {
      quitJButton = new JButton("退出");
    }

    public Login(){
        //设置不同的标题
        setTitlejLable();
        //设置不同的退出按键
        setQuitJButton();
        //初始化界面
        intijFrame();
        //初始化各元件的样式
        intiFormat();
        //初始化布局
        intiSetContentpaneAndCenterJPanel();
        //初始化系统托盘
        intiSystemTray();
        //设置菜单退出选项的对应事件
        intiReturnJMenuItem();
    }

    private void intiReturnJMenuItem() {
        returnJMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new IdentitySelection();
            }
        });
    }

    private void intiSetContentpaneAndCenterJPanel() {

        //为contentpane设置边界布局
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(titleJLabel,BorderLayout.NORTH);
        this.getContentPane().add(centerJPanel,BorderLayout.CENTER);

        //获得adminJLabel和adminJTextField的中心位置，为下面的居中设置做准备
        Spring adminWidth = Spring.width(adminJLabel);
        Spring textWidth = Spring.width(adminJTextField);
        Spring spaceWidth = Spring.constant(20);
        Spring adminSumWidth = Spring.sum(Spring.sum(adminWidth,textWidth),spaceWidth);
        int adminMiddle = adminSumWidth.getValue()/2;
        //设置adminJlable和adminJTextField的位置
        SpringLayout.Constraints adminCon = springLayout.getConstraints(adminJLabel);
        adminCon.setY(Spring.constant(50));
        springLayout.putConstraint(SpringLayout.WEST,adminJLabel,-adminMiddle,
                SpringLayout.HORIZONTAL_CENTER,centerJPanel);
        springLayout.putConstraint(SpringLayout.WEST,adminJTextField,20,SpringLayout.EAST,adminJLabel);
        springLayout.putConstraint(SpringLayout.NORTH,adminJTextField,0,SpringLayout.NORTH,adminJLabel);

        //获得passwordJLabel和PasswordJTextField的中心位置
        Spring passwordWidth = Spring.width(passwordJLabel);
        Spring passwordTextWidth = Spring.width(passwordJTextField);
        Spring passwordSumWidth = Spring.sum(Spring.sum(passwordWidth,passwordTextWidth),spaceWidth);
        int passwordMiddle = passwordSumWidth.getValue()/2;
        //设置passwordJLabel和PasswordJTextField的位置
        springLayout.putConstraint(SpringLayout.NORTH,passwordJLabel,30,SpringLayout.SOUTH,adminJLabel);
        springLayout.putConstraint(SpringLayout.WEST,passwordJLabel,-passwordMiddle,
                SpringLayout.HORIZONTAL_CENTER,centerJPanel);
        springLayout.putConstraint(SpringLayout.NORTH,passwordJTextField,0,SpringLayout.NORTH,passwordJLabel);
        springLayout.putConstraint(SpringLayout.WEST,passwordJTextField,20,SpringLayout.EAST,passwordJLabel);


        Spring loginJBtWidth = Spring.width(loginJButton);
        Spring quitJBtWidth = Spring.width(quitJButton);
        Spring jBtSumWidth = Spring.sum(Spring.sum(passwordWidth,passwordTextWidth),spaceWidth);
        int jBtMiddle = passwordSumWidth.getValue()/2;
        springLayout.putConstraint(SpringLayout.NORTH,quitJButton,30,SpringLayout.SOUTH,passwordJLabel);
        springLayout.putConstraint(SpringLayout.WEST,quitJButton,-jBtMiddle,
                SpringLayout.HORIZONTAL_CENTER,centerJPanel);
        springLayout.putConstraint(SpringLayout.NORTH,loginJButton,0,SpringLayout.NORTH,quitJButton);
        springLayout.putConstraint(SpringLayout.WEST,loginJButton,20,SpringLayout.EAST,quitJButton);

        //添加组件到centerJPanel中
        centerJPanel.add(adminJLabel);
        centerJPanel.add(adminJTextField);
        centerJPanel.add(passwordJLabel);
        centerJPanel.add(passwordJTextField);
        centerJPanel.add(loginJButton);
        centerJPanel.add(quitJButton);
    }

    private void intiFormat() {
        titleJLabel.setFont(new Font("华文楷体",Font.PLAIN,40));
        adminJLabel.setFont(new Font("楷体",Font.PLAIN,20));
        passwordJLabel.setFont(new Font("楷体",Font.PLAIN,20));
        loginJButton.setFont(new Font("楷体",Font.PLAIN,20));
        quitJButton.setFont(new Font("楷体",Font.PLAIN,20));
        passwordJTextField.setPreferredSize(new Dimension(200,30));
        adminJTextField.setPreferredSize(new Dimension(200,30));

        centerJPanel.setBackground(Color.ORANGE);
        loginJButton.addActionListener(this);
        quitJButton.addActionListener(this);
        
    }

    public void setTitlejLable() {
        titleJLabel =  new JLabel("test",SwingConstants.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         Object source = e.getSource();
         if(source == loginJButton){
             System.out.println(admin);
             System.out.println(password); ;
         }else if(source == quitJButton){
             ;
         }
    }
}



















//


