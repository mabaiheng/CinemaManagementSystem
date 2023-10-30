package UI.jDialog;

import UI.data.MovieDataUI;
import UI.work.UserWork;
import data.packagingData.AdminData;
import data.packagingData.UserBuyHistory;
import data.packagingData.UserData;
import data.readAndWriteFun.AdminReadAndWrite;
import data.readAndWriteFun.UserReadAndWrite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

public class LoginJDialog extends IntiJDialog{

    private JButton jButton = new JButton("确定");
    private JLabel jLabel = new JLabel();

    Boolean yesBl = false;

    public Boolean getYesBl() {
        return yesBl;
    }

    public LoginJDialog(int x) {
        if(x == 0){
            jLabel = new JLabel("您输入的账户和密码不匹配");
        } else if (x == 1) {
            jLabel = new JLabel("添加成功");
        } else if (x == 2) {
            jLabel = new JLabel("添加失败");
        }else if(x == 3){
            JButton noJBt = new JButton("返回");
            noJBt.setFont(new Font("楷体", Font.PLAIN, 20));
            noJBt.setPreferredSize(new Dimension(30,30));
            noJBt.setBounds(150,240,100,50);
            jDialog.getContentPane().add(noJBt);
            jLabel = new JLabel("你确定删除吗");
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    yesBl = true;jDialog.dispose();
                }
            });
            noJBt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    jDialog.dispose();
                }
            });
        }else if(x == 4){
            jLabel = new JLabel("查找失败,未找到数据");
        } else if (x == 5) {
            jLabel = new JLabel("修改完成");
        } else if (x == 6) {
            jLabel = new JLabel("登录超过五次，已锁定");
        } else if(x == 7) {

            JButton noJBt = new JButton("返回");
            noJBt.setFont(new Font("楷体", Font.PLAIN, 20));
            noJBt.setPreferredSize(new Dimension(30,30));
            noJBt.setBounds(150,240,100,50);
            jDialog.getContentPane().add(noJBt);
            jLabel = new JLabel("你确定要买吗？");
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    yesBl = true;
                    jDialog.dispose();
                }
            });
            noJBt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    jDialog.dispose();
                }
            });
        } else if (x == 8) {
            jLabel = new JLabel("你的票成功取出");
        } else if (x == 9) {
            jLabel = new JLabel("取出失败，你的票已经取过了");

        } else if (x == 10) {
            jLabel = new JLabel("你输入的密码或用户名不符合规则" );
        } else if (x == 11) {
            jLabel = new JLabel("账号以及被注册了");
        } else if (x == 12) {
            jLabel = new JLabel("你输入的手机号或邮箱不符合规则");
        } else if (x == 13) {
            jLabel = new JLabel("你输入的密码不符合规则");
        }else if(x == 14){
            jLabel = new JLabel("放映室只有1到5");
        } else if (x == 15) {
         jLabel = new JLabel("时间输入：YYYY-MM-DD hh:mm:ss");
        } else if (x == 16) {
            jLabel = new JLabel("你还没买票");
        }else if(x == 17){
            jLabel = new JLabel("无该电影信息");
        }
        jDialog.getContentPane().setLayout(null);
        jButton.setBounds(250,240,100,50);
        jLabel.setBounds(150,50,400,50);

        jLabel.setFont(new Font("楷体", Font.PLAIN, 24));
        jButton.setFont(new Font("楷体", Font.PLAIN, 20));
        jButton.setPreferredSize(new Dimension(30,30));
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();

            }
        });

        jDialog.getContentPane().add(jLabel);
        jDialog.getContentPane().add(jButton);
        jDialog.setVisible(true);

    }
    public LoginJDialog(String s){
        jLabel = new JLabel("您的取票码为:"+s);
        jDialog.getContentPane().setLayout(null);
        jButton.setBounds(250,240,100,50);
        jLabel.setBounds(100,50,500,50);

        jLabel.setFont(new Font("楷体", Font.PLAIN, 20));
        jButton.setFont(new Font("楷体", Font.PLAIN, 20));
        jButton.setPreferredSize(new Dimension(30,30));
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();

            }
        });
        jDialog.getContentPane().add(jLabel);
        jDialog.getContentPane().add(jButton);
        jDialog.setVisible(true);
    }
    public LoginJDialog(UserBuyHistory userBuyHistory){
        jLabel = new JLabel("您的取票码为:"+userBuyHistory.getTicketCode());
        JLabel userNameJlb = new JLabel("用户名:"+userBuyHistory.getUserName());
        JLabel movieNameJlb = new JLabel("电影名:"+userBuyHistory.getMovieName());
        JLabel projectionRoomJlb = new JLabel("播放室:"+userBuyHistory.getProjectionRoom());
        JLabel startTimeJlb = new JLabel("开始时间:"+userBuyHistory.getStartTime());
        JLabel contentJlb = new JLabel("票含量:"+userBuyHistory.getContent());
        JLabel baseJlb = new JLabel("电影票信息如上");

        jDialog.getContentPane().setLayout(null);
        jButton.setBounds(300,320,100,50);
        jLabel.setBounds(100,30,500,50);
        userNameJlb.setBounds(100,70,500,50);
        movieNameJlb.setBounds(100,110,500,50);
        projectionRoomJlb.setBounds(100,150,500,50);
        startTimeJlb.setBounds(100,190,500,50);
        contentJlb.setBounds(100,230,500,50);
        baseJlb.setBounds(100,270,500,50);


        jLabel.setFont(new Font("楷体", Font.PLAIN, 20));
        userNameJlb.setFont(new Font("楷体", Font.PLAIN, 20));
        movieNameJlb.setFont(new Font("楷体", Font.PLAIN, 20));
        projectionRoomJlb.setFont(new Font("楷体", Font.PLAIN, 20));
        startTimeJlb.setFont(new Font("楷体", Font.PLAIN, 20));
        contentJlb.setFont(new Font("楷体", Font.PLAIN, 20));
        baseJlb.setFont(new Font("楷体", Font.PLAIN, 20));


        jButton.setFont(new Font("楷体", Font.PLAIN, 20));
        jButton.setPreferredSize(new Dimension(30,30));
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();

            }
        });
        jDialog.getContentPane().add(jLabel);
        jDialog.getContentPane().add(jButton);
        jDialog.getContentPane().add(userNameJlb);
        jDialog.getContentPane().add(movieNameJlb);
        jDialog.getContentPane().add(projectionRoomJlb);
        jDialog.getContentPane().add(contentJlb);
        jDialog.getContentPane().add(baseJlb);
        jDialog.getContentPane().add(startTimeJlb);

        jDialog.setVisible(true);
    }

    public LoginJDialog(String admin,int a){
        Vector<AdminData> adminData = new AdminReadAndWrite().read();
        Vector<UserData> userData = new UserReadAndWrite().read();

        jLabel = new JLabel("已经向你的邮箱："+userData.elementAt(a).getUserMail()+"\n"+"发送信息.");
        //获取随机密码
        Random random = new Random();
        int[] randomArr = new int[10];
        for (int i = 0; i < 10; i++) {
            randomArr[i] = random.nextInt(10);
        }
        String randomString = Arrays.toString(randomArr);
        String resultA = randomString.replaceAll(",", "");
        String resultB = resultA.replaceAll("]", "");
        String resultC = resultB.replaceAll("\\[", "");
        String resultD = resultC.replaceAll("\\s", "");
        //更新用户密码数据
        adminData.elementAt(a).setPassword(resultD);
        new AdminReadAndWrite().write(adminData);
        JLabel newJLabel = new JLabel("已经将你的密码改为："+resultD);
        //初始化界面
        jDialog.getContentPane().setLayout(null);
        jButton.setBounds(200,300,100,50);
        jLabel.setBounds(50,50,500,50);
        newJLabel.setBounds(50,150,500,50);
        jLabel.setFont(new Font("楷体", Font.PLAIN, 20));
        newJLabel.setFont(new Font("楷体", Font.PLAIN, 20));
        jButton.setFont(new Font("楷体", Font.PLAIN, 20));
        jDialog.getContentPane().add(jButton);
        jDialog.getContentPane().add(jLabel);
        jDialog.getContentPane().add(newJLabel);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();

            }
        });
        jDialog.setVisible(true);
    }


}
