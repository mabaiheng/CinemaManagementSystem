package UI.jDialog;

import UI.data.MovieDataUI;
import UI.data.MovieLayoutDataUI;
import UI.data.UserDataUI;
import data.packagingData.AdminData;
import data.packagingData.MovieInformation;
import data.packagingData.MovieLayoutData;
import data.packagingData.UserData;
import data.readAndWriteFun.AdminReadAndWrite;
import data.readAndWriteFun.MovieLayoutReadAndWrite;
import data.readAndWriteFun.MovieReadAndWrite;
import data.readAndWriteFun.UserReadAndWrite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;
import java.util.function.LongFunction;

public class DeleteJDialog extends IntiJDialog{
    JButton sureJbt = new JButton("确定");
    JButton returnJbt = new JButton("返回");

    public DeleteJDialog(Vector<?> vector) {
        JLabel jLabel = new JLabel("你要删除的信息为:");
        jLabel.setFont(new Font("华文楷体",Font.BOLD,20));
        jLabel.setBounds(30,100,200,50);
        jDialog.getContentPane().setLayout(null);
        sureJbt.setFont(new Font("楷体",Font.BOLD,12));
        returnJbt.setFont(new Font("楷体",Font.BOLD,12));
        sureJbt.setBounds(230,320,60,30);
        returnJbt.setBounds(300,320,60,30);
        jDialog.getContentPane().add(sureJbt);
        jDialog.getContentPane().add(returnJbt);
        jDialog.getContentPane().add(jLabel);
        Class<?> aClass = vector.elementAt(0).getClass();
        if(aClass.equals(UserData.class)){
            userDataDelete((Vector<UserData>) vector);
        }else if (aClass.equals(MovieLayoutData.class)) {
            movieLayoutDelete((Vector<MovieLayoutData>) vector);
        }else if (aClass.equals(AdminData.class)) {
            System.out.println(3);
        }else if(aClass.equals(MovieInformation.class)){
            movieInformationDelete((Vector<MovieInformation>) vector);
        }

        jDialog.setVisible(true);
    }

    private void movieInformationDelete(Vector<MovieInformation> vector) {
        movieVector = vector;
        //初始化界面，元件位置，大小，事件
        JLabel movieNameJLabel = new JLabel("片名:");
        JLabel directorJLabel = new JLabel("导演:");
        JLabel leadingRoleJLabel = new JLabel("主演:");
        JTextField movieNameJText = new JTextField();
        JTextField directorNameJText = new JTextField();
        JTextField leadingRoleJText = new JTextField();
        movieNameJLabel.setFont(new Font("楷体",Font.PLAIN,14));
        directorJLabel.setFont(new Font("楷体",Font.PLAIN,14));
        leadingRoleJLabel.setFont(new Font("楷体",Font.PLAIN,14));
        movieNameJLabel.setBounds(300,30,40,30);
        directorJLabel.setBounds(300,90,40,30);
        leadingRoleJLabel.setBounds(300,150,40,30);
        movieNameJText.setBounds(360,30,200,30);
        directorNameJText.setBounds(360,90,200,30);
        leadingRoleJText.setBounds(360,150,200,30);
        jDialog.getContentPane().add(movieNameJLabel);
        jDialog.getContentPane().add(directorJLabel);
        jDialog.getContentPane().add(leadingRoleJLabel);
        jDialog.getContentPane().add(movieNameJText);
        jDialog.getContentPane().add(directorNameJText);
        jDialog.getContentPane().add(leadingRoleJText);
        //添加按钮事件
        sureJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获得用户输入
                String movieName = movieNameJText.getText();
                String director = directorNameJText.getText();
                String leadingRole = leadingRoleJText.getText();
                if(movieName.isEmpty()||director.isEmpty()||leadingRole.isEmpty()){
                    //输入为空
                    new LoginJDialog(4);
                } else{
                    //从excel中获取数据，并于用户输入匹配
                    Boolean bl = true;
                    for(int i = 0; i < movieVector.size(); i++){
                        String tempMovieName = movieVector.elementAt(i).getMovieName();
                        String tempDirector = movieVector.elementAt(i).getDirector();
                        String tempLeadingRole = movieVector.elementAt(i).getLeadingRole();
                        if(tempMovieName.equals(movieName)&& tempDirector.equals(director)&&tempLeadingRole.equals(leadingRole)){
                            //匹配成功
                            bl = false;
                            LoginJDialog loginJDialog = new LoginJDialog(3);
                            Boolean tempBl = loginJDialog.getYesBl();
                             if (tempBl){
                                 //选择确定，删除数据
                                 movieVector.removeElementAt(i);
                                 new MovieReadAndWrite().write(movieVector);
                                 jDialog.dispose();
                                 new MovieDataUI();
                             }
                        }

                    }

                    if(bl){new LoginJDialog(4);}
                }

            }
        });
        returnJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();
                new MovieDataUI();
            }
        });
    }
    private void movieLayoutDelete(Vector<MovieLayoutData> vector) {
        movieLayoutVector = vector;
        //初始化界面，元件
        JLabel movieNameJLabel = new JLabel("电影名:");
        JLabel projectionRoomJLabel = new JLabel("播放室:");
        JLabel startTimeJLabel = new JLabel("开始播放时间：");
        JTextField movieNameText = new JTextField();
        JTextField projectionRoomText = new JTextField();
        JTextField startTimeText = new JTextField();
        movieNameJLabel.setFont(new Font("楷体",Font.PLAIN,14));
        projectionRoomJLabel.setFont(new Font("楷体",Font.PLAIN,14));
        startTimeJLabel.setFont(new Font("楷体",Font.PLAIN,14));
        movieNameJLabel.setBounds(200,30,100,30);
        projectionRoomJLabel.setBounds(200,90,100,30);
        startTimeJLabel.setBounds(200,150,100,30);
        movieNameText.setBounds(300,30,200,30);
        projectionRoomText.setBounds(300,90,200,30);
        startTimeText.setBounds(300,150,200,30);
        jDialog.getContentPane().add(movieNameText);
        jDialog.getContentPane().add(movieNameJLabel);
        jDialog.getContentPane().add(projectionRoomText);
        jDialog.getContentPane().add(startTimeJLabel);
        jDialog.getContentPane().add(projectionRoomJLabel);
        jDialog.getContentPane().add(startTimeText);
        //添加按钮事件
        sureJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //用户输入
                String movieName = movieNameText.getText();
                String projectionRoom =  projectionRoomText.getText();
                String startTime = startTimeText.getText();

                if(movieName.isEmpty()||projectionRoom.isEmpty()||startTime.isEmpty()){
                    //输入为空
                   new LoginJDialog(4);
                } else if (!startTime.matches("^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})" +
                "-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)" +
                        "(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$")){
                    //时间输入不合法
                    new LoginJDialog(15);
                } else{
                    //数据匹配
                    Boolean bl = true;
                    for(int i = 0; i < movieLayoutVector.size(); i++){
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh：mm：ss");

                        String tempMovieName = movieLayoutVector.elementAt(i).getMovieName();
                        int  tempProjectionRoom  = movieLayoutVector.elementAt(i).getProjectionRoom();
                        String tempStartTime  = movieLayoutVector.elementAt(i).getStartTime();
                        int intProjectionRoom = new Integer(projectionRoom);
                        //标准化
                        Date startDate = new Date();
                        Date tempStartDate = new Date();
                        try {
                            startDate = simpleDateFormat1.parse(startTime);
                            tempStartDate = simpleDateFormat1.parse(tempStartTime);

                        } catch (ParseException ex) {
                            try {
                                startDate = simpleDateFormat.parse(startTime);
                                tempStartDate = simpleDateFormat.parse(tempStartTime);

                            } catch (ParseException exc) {

                            }
                        }

                        if(movieName.equals(tempMovieName)&& tempProjectionRoom == intProjectionRoom && startDate.equals(tempStartDate)){
                            //匹配成功
                            bl = false;
                            LoginJDialog loginJDialog = new LoginJDialog(3);
                            Boolean tempBl = loginJDialog.getYesBl();
                            if (tempBl){
                                movieLayoutVector.removeElementAt(i);
                                new MovieLayoutReadAndWrite().write(movieLayoutVector);
                                jDialog.dispose();
                                new MovieLayoutDataUI();
                            }
                        }
                    }
                    if(bl){new LoginJDialog(4);}
                }

            }
        });
        returnJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();
                new MovieLayoutDataUI();
            }
        });
    }
    private void userDataDelete(Vector<UserData> vector){
        userVector = vector;
        //初始化界面
        JLabel movieNameJLabel = new JLabel("用户ID:");
        JLabel directorJLabel = new JLabel("用户名:");
        JTextField movieNameJText = new JTextField();
        JTextField directorNameJText = new JTextField();
        movieNameJLabel.setFont(new Font("楷体",Font.PLAIN,14));
        directorJLabel.setFont(new Font("楷体",Font.PLAIN,14));
        movieNameJLabel.setBounds(260,30,80,30);
        directorJLabel.setBounds(260,90,80,30);
        movieNameJText.setBounds(360,30,200,30);
        directorNameJText.setBounds(360,90,200,30);
        jDialog.getContentPane().add(movieNameJLabel);
        jDialog.getContentPane().add(directorJLabel);
        jDialog.getContentPane().add(movieNameJText);
        jDialog.getContentPane().add(directorNameJText);
        //按钮事件
        sureJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //用户输入
                String movieName = movieNameJText.getText();
                String director = directorNameJText.getText();
                if(movieName.isEmpty()||director.isEmpty()){
                    new LoginJDialog(4);
                } else {
                    //数据匹配
                    Boolean bl = true;
                    for (int i = 0; i < userVector.size(); i++) {
                        String tempMovieName = userVector.elementAt(i).getUserID();
                        String tempDirector = userVector.elementAt(i).getUserName();
                        if (tempMovieName.equals(movieName) && tempDirector.equals(director)) {
                            bl = false;
                            LoginJDialog loginJDialog = new LoginJDialog(3);
                            Boolean tempBl = loginJDialog.getYesBl();
                            if (tempBl) {
                                userVector.removeElementAt(i);
                                new UserReadAndWrite().write(userVector);

                                Vector<AdminData> temp = new AdminReadAndWrite().read();
                                temp.removeElementAt(i);
                                new AdminReadAndWrite().write(temp);

                                jDialog.dispose();
                                new UserDataUI();
                            }
                        }
                    }
                    if(bl){new LoginJDialog(4);}
                }
            }
        });
        returnJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();
                new UserDataUI();
            }
        });
    }
}
