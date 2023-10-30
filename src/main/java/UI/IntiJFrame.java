package UI;

import UI.Login.Login;
import UI.identitySelection.IdentitySelection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IntiJFrame extends JFrame{
    public JMenuBar jMenuBar = new JMenuBar();
    public JMenu jMenu = new JMenu("功能");
    JMenuItem quitJMenuItem = new JMenuItem("退出");
    public JMenuItem returnJMenuItem = new JMenuItem("返回");
    SystemTray systemTray;
    TrayIcon trayIcon;
    public IntiJFrame() {
        super("影院管理系统");
        quitJMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new IdentitySelection();
            }
        });


    }

    public void intijFrame() {
        jMenu.add(quitJMenuItem);
        jMenu.add(returnJMenuItem);
        jMenuBar.add(jMenu);
        this.setJMenuBar(jMenuBar);
        setSize(1000,800);
        this.getContentPane().setBackground(Color.ORANGE);
        this.setIconImage(new ImageIcon("image//屏幕截图 2023-09-10 173516.png").getImage());
        this.setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(3);
        setVisible(true);
    }

    public void intiSystemTray() {
        if(SystemTray.isSupported()){
            systemTray = SystemTray.getSystemTray();
            trayIcon = new TrayIcon(new ImageIcon("image/屏幕截图 2023-09-10 173516.png").getImage());
            trayIcon.setImageAutoSize(true);
            try {
                systemTray.add(trayIcon);
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int clickCount = e.getClickCount();
                    if(clickCount == 1){
                        IntiJFrame.this.setExtendedState(JFrame.NORMAL);
                    }
                    IntiJFrame.this.setVisible(true);
                }
            });
        }
    }
}
