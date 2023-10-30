package UI.identitySelection;

import UI.IntiJFrame;
import UI.Login.AdministratorLogin;
import UI.Login.ManagerLogin;
import UI.Login.ReceptionLogin;
import UI.Login.UserLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class IdentitySelection extends IntiJFrame implements ActionListener {

    //用户身份选择界面
    JButton userJbt = new JButton("用户");
    JButton administratorJbt = new JButton("管理员");
    JButton managerJbt = new JButton("经理");
    JButton receptionJbt = new JButton("前台");
    JLabel tempJLabel = new JLabel("请问您的身份是:");
    JPanel centerJPanel = new JPanel(new FlowLayout(0, 150, 30));


    public IdentitySelection() {
        //初始化界面的大小，背景
        intijFrame();
        //初始化界面原件的布局，并为按钮添加对应的事件
        intiFormat();
        //添加系统托盘
        intiSystemTray();
    }

    private void intiFormat() {
        centerJPanel.setBackground(Color.ORANGE);

        tempJLabel.setFont(new Font("华文楷体", Font.PLAIN, 40));
        administratorJbt.setFont(new Font("楷体", Font.PLAIN, 20));
        managerJbt.setFont(new Font("楷体", Font.PLAIN, 20));
        receptionJbt.setFont(new Font("楷体", Font.PLAIN, 20));
        userJbt.setFont(new Font("楷体", Font.PLAIN, 20));

        administratorJbt.setPreferredSize(new Dimension(100, 40));
        managerJbt.setPreferredSize(new Dimension(100, 40));
        receptionJbt.setPreferredSize(new Dimension(100, 40));
        userJbt.setPreferredSize(new Dimension(100, 40));

        userJbt.addActionListener(this);
        managerJbt.addActionListener(this);
        administratorJbt.addActionListener(this);
        receptionJbt.addActionListener(this);

        centerJPanel.add(administratorJbt);
        centerJPanel.add(managerJbt);
        centerJPanel.add(receptionJbt);
        centerJPanel.add(userJbt);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(tempJLabel, BorderLayout.NORTH);
        this.getContentPane().add(centerJPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == userJbt) {
            IdentitySelection.this.dispose();
            new UserLogin();
        } else if (source == managerJbt) {
            IdentitySelection.this.dispose();
            new ManagerLogin();
        } else if (source == receptionJbt) {
            IdentitySelection.this.dispose();
            new ReceptionLogin();
        } else if (source == administratorJbt) {
            IdentitySelection.this.dispose();
            new AdministratorLogin();

        }
    }
}
