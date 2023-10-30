package UI.jDialog;

import UI.data.MovieDataUI;
import UI.data.MovieLayoutDataUI;
import data.packagingData.AdminData;
import data.packagingData.MovieInformation;
import data.packagingData.MovieLayoutData;
import data.packagingData.UserData;
import data.readAndWriteFun.AdminReadAndWrite;
import data.readAndWriteFun.MovieLayoutReadAndWrite;
import data.readAndWriteFun.MovieReadAndWrite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class ChangeJDialog extends IntiJDialog{
    JButton sureJbt = new JButton("确定");
    JButton returnJbt = new JButton("返回");
    public ChangeJDialog(Vector<?> vector) {
        jDialog.getContentPane().setLayout(null);
        sureJbt.setFont(new Font("楷体",Font.BOLD,12));
        returnJbt.setFont(new Font("楷体",Font.BOLD,12));
        sureJbt.setBounds(230,320,60,30);
        returnJbt.setBounds(300,320,60,30);
        jDialog.getContentPane().add(sureJbt);
        jDialog.getContentPane().add(returnJbt);

        Class<?> aClass = vector.elementAt(0).getClass();
        if(aClass.equals(UserData.class)){
            System.out.println(1);
        }else if (aClass.equals(MovieLayoutData.class)) {
            JLabel jLabel = new JLabel("你要修改的信息为:");
            jLabel.setFont(new Font("华文楷体",Font.BOLD,20));
            jLabel.setBounds(30,100,200,50);
            movieLayoutChange((Vector<MovieLayoutData>) vector);
        }else if (aClass.equals(AdminData.class)) {
            adminDataChange((Vector<AdminData>) vector);
        }else if(aClass.equals(MovieInformation.class)){
            JLabel jLabel = new JLabel("你要修改的信息为:");
            jLabel.setFont(new Font("华文楷体",Font.BOLD,20));
            jLabel.setBounds(30,100,200,50);
            movieInformationChange((Vector<MovieInformation>) vector);
        }

        jDialog.setVisible(true);
    }


    private void movieInformationChange(Vector<MovieInformation> vector) {
        movieVector = vector;
        //初始化界面，元件大小，事件，位置
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
                int tempi = 0;
                //获取用户输入
                String movieName = movieNameJText.getText();
                String director =  directorNameJText.getText();
                String leadingRole = leadingRoleJText.getText();
                //数据匹配
                Boolean bl = true;
                for(int i = 0; i < movieVector.size(); i++){
                    String tempMovieName = movieVector.elementAt(i).getMovieName();
                    String tempdirector = movieVector.elementAt(i).getDirector();
                    String tempLeadingRole = movieVector.elementAt(i).getLeadingRole();
                    if(movieName.equals(tempMovieName)&&director.equals(tempdirector)&&leadingRole.equals(tempLeadingRole)){
                        bl = false;
                        tempi = i;
                        secondLayout(tempi);
                    }
                }
                if(bl){new LoginJDialog(4);}

            }

            private void secondLayout(int i) {
                //初始化界面
                JLabel newjLabel = new JLabel("将信息修改为:");
                newjLabel.setFont(new Font("华文楷体",Font.BOLD,20));
                newjLabel.setBounds(30,100,200,50);
                jDialog.getContentPane().repaint();
                jDialog.getContentPane().removeAll();
                JLabel movieNameJLabel = new JLabel("片名:");
                JLabel directorJLabel = new JLabel("导演:");
                JLabel leadingRoleJLabel = new JLabel("主演:");
                JLabel synopsisJLabel = new JLabel("剧情简介:");
                JLabel durationJLabel = new JLabel("时长:");
                JTextField movieNameJText = new JTextField();
                JTextField directorNameJText = new JTextField();
                JTextField leadingRoleJText = new JTextField();
                JTextField synopsisJText = new JTextField();
                JTextField durationJText = new JTextField();
                movieNameJLabel.setFont(new Font("楷体",Font.PLAIN,14));
                directorJLabel.setFont(new Font("楷体",Font.PLAIN,14));
                leadingRoleJLabel.setFont(new Font("楷体",Font.PLAIN,14));
                synopsisJLabel.setFont(new Font("楷体",Font.PLAIN,14));
                durationJLabel.setFont(new Font("楷体",Font.PLAIN,14));
                movieNameJLabel.setBounds(300,30,40,30);
                directorJLabel.setBounds(300,90,40,30);
                leadingRoleJLabel.setBounds(300,150,40,30);
                synopsisJLabel.setBounds(270,210,80,30);
                durationJLabel.setBounds(300,270,40,30);
                movieNameJText.setBounds(360,30,200,30);
                directorNameJText.setBounds(360,90,200,30);
                leadingRoleJText.setBounds(360,150,200,30);
                synopsisJText.setBounds(360,210,200,30);
                durationJText.setBounds(360,270,200,30);
                JButton sureJbt = new JButton("确定");
                JButton returnJbt = new JButton("返回");
                sureJbt.setFont(new Font("楷体",Font.BOLD,12));
                returnJbt.setFont(new Font("楷体",Font.BOLD,12));
                sureJbt.setBounds(230,320,60,30);
                returnJbt.setBounds(300,320,60,30);
                jDialog.getContentPane().add(movieNameJLabel);
                jDialog.getContentPane().add(directorJLabel);
                jDialog.getContentPane().add(leadingRoleJLabel);
                jDialog.getContentPane().add(synopsisJLabel);
                jDialog.getContentPane().add(durationJLabel);
                jDialog.getContentPane().add(movieNameJText);
                jDialog.getContentPane().add(synopsisJText);
                jDialog.getContentPane().add(directorNameJText);
                jDialog.getContentPane().add(leadingRoleJText);
                jDialog.getContentPane().add(durationJText);
                jDialog.getContentPane().add(sureJbt);
                jDialog.getContentPane().add(returnJbt);
                jDialog.getContentPane().add(newjLabel);

                sureJbt.addActionListener(new ActionListener() {@Override
                public void actionPerformed(ActionEvent e) {
                    //用户输入
                    String movieName = movieNameJText.getText();
                    String director = directorNameJText.getText();
                    String leadingRole = leadingRoleJText.getText();
                    String synopsis = synopsisJText.getText();
                    String duration = durationJText.getText();
                    int tempDuration = new Integer(duration);
                    if(movieName.isEmpty()&&director.isEmpty()&&leadingRole.isEmpty()&&synopsis.isEmpty()&&duration.isEmpty()){
                       //输入为空
                        new LoginJDialog(4);
                    }else {
                        if(!movieName.isEmpty()){
                            movieVector.elementAt(i).setMovieName(movieName);
                        }
                        if(!director.isEmpty()){
                            movieVector.elementAt(i).setDirector(director);
                        }
                        if(!leadingRole.isEmpty()){
                            movieVector.elementAt(i).setLeadingRole(leadingRole);
                        }
                        if(!synopsis.isEmpty()){
                            movieVector.elementAt(i).setSynopsis(synopsis);
                        }
                        if(!duration.isEmpty()){
                            movieVector.elementAt(i).setDuration(tempDuration);
                        }
                        new MovieReadAndWrite().write(movieVector);
                        jDialog.dispose();
                        new LoginJDialog(5);
                        new MovieDataUI();
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
        });
        returnJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();
                new MovieDataUI();
            }
        });
    }
    private void adminDataChange(Vector<AdminData> vector) {
        adminVector = vector;
        //初始化界面，元件
        JLabel passwordJLabel = new JLabel("修改后密码：");
        passwordJLabel.setFont(new Font("华文楷体",Font.BOLD,20));
        passwordJLabel.setBounds(160,100,200,50);
        JTextField passwordFiled = new JTextField();
        passwordFiled.setBounds(300,100,200,50);
        jDialog.getContentPane().add(passwordJLabel);
        jDialog.getContentPane().add(passwordFiled);
        //添加按钮时间
        sureJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取输入
                String temp = passwordFiled.getText();
                //更新数据
                adminVector.elementAt(0).setPassword(temp);
                new AdminReadAndWrite().adminWrite(adminVector);
                jDialog.dispose();
            }

        });
        returnJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();
            }
        });
    }
    private void movieLayoutChange(Vector<MovieLayoutData> vector) {
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
        //按钮事件
        sureJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tempi = 0;
                //用户输入
                String movieName = movieNameText.getText();
                String projectionRoom =  projectionRoomText.getText();
                String startTime = startTimeText.getText();
                //数据匹配
                if (!startTime.matches("^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})" +
                "-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)" +
                        "(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$")){
                    //时间输入不合法
                    new LoginJDialog(15);
                }else {
                    //数据匹配
                    Boolean bl = true;
                    for(int i = 0; i < movieLayoutVector.size(); i++){
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh：mm：ss");

                    String tempMovieName = movieLayoutVector.elementAt(i).getMovieName();
                    int  tempProjectionRoom  = movieLayoutVector.elementAt(i).getProjectionRoom();
                    String tempStartTime  = movieLayoutVector.elementAt(i).getStartTime();
                    //标准化格式
                    int intProjectionRoom = new Integer(projectionRoom);
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

                    if(movieName.equals(tempMovieName)&&(tempProjectionRoom == intProjectionRoom)&&startDate.equals(tempStartDate)){
                       //匹配成功，进入修改界面
                        bl = false;
                        tempi = i;
                        secondLayout(tempi);
                    }
                }
                //匹配失败
                    if(bl){new LoginJDialog(4);}
                }
            }

            private void secondLayout(int i) {
                jDialog.getContentPane().repaint();
                jDialog.getContentPane().removeAll();
                //初始化界面
                JLabel movieNameJLabel = new JLabel("电影名:");
                JLabel projectionRoomJLabel = new JLabel("播放室:");
                JLabel startTimeJLabel = new JLabel("开始播放时间：");
                JLabel priceJLabel = new JLabel("价格：");
                JLabel addJLabel = new JLabel("修改排场信息");
                JButton newSure = new JButton("确定");
                JButton newReturn = new JButton("返回");
                JTextField movieNameText = new JTextField();
                JTextField projectionRoomText = new JTextField();
                JTextField startTimeText = new JTextField();
                JTextField priceText = new JTextField();
                newSure.setFont(new Font("楷体",Font.BOLD,12));
                newReturn.setFont(new Font("楷体",Font.BOLD,12));
                movieNameJLabel.setFont(new Font("楷体",Font.PLAIN,14));
                projectionRoomJLabel.setFont(new Font("楷体",Font.PLAIN,14));
                startTimeJLabel.setFont(new Font("楷体",Font.PLAIN,14));
                priceJLabel.setFont(new Font("楷体",Font.PLAIN,14));
                addJLabel.setFont(new Font("华文楷体",Font.PLAIN,17));
                newSure.setBounds(230,320,60,30);
                newReturn.setBounds(300,320,60,30);
                movieNameJLabel.setBounds(200,30,100,30);
                projectionRoomJLabel.setBounds(200,90,100,30);
                startTimeJLabel.setBounds(200,150,100,30);
                priceJLabel.setBounds(200,210,100,30);
                movieNameText.setBounds(300,30,200,30);
                projectionRoomText.setBounds(300,90,200,30);
                startTimeText.setBounds(300,150,200,30);
                priceText.setBounds(300,210,200,30);
                addJLabel.setBounds(50,90,200,30);
                jDialog.getContentPane().add(movieNameText);
                jDialog.getContentPane().add(movieNameJLabel);
                jDialog.getContentPane().add(priceText);
                jDialog.getContentPane().add(projectionRoomText);
                jDialog.getContentPane().add(startTimeJLabel);
                jDialog.getContentPane().add(priceJLabel);
                jDialog.getContentPane().add(projectionRoomJLabel);
                jDialog.getContentPane().add(startTimeText);
                jDialog.getContentPane().add(addJLabel);
                jDialog.getContentPane().add(newSure);
                jDialog.getContentPane().add(newReturn);
                //添事件
                newSure.addActionListener(new ActionListener() {@Override
                public void actionPerformed(ActionEvent e) {
                    //用户输入
                    String movieName = movieNameText.getText();
                    String startTime = startTimeText.getText();
                    String price = priceText.getText();
                    String projectionRoom = projectionRoomText.getText();

                    if(movieName.isEmpty()&&startTime.isEmpty()&&price.isEmpty()&&projectionRoom.isEmpty()){
                        //输入为空
                        new LoginJDialog(4);
                    }else {
                        if(!movieName.isEmpty()){
                            movieLayoutVector.elementAt(i).setMovieName(movieName);
                        }
                        if(!price.isEmpty()){
                            movieLayoutVector.elementAt(i).setPrice(new Integer(price).floatValue());
                        }
                        if(!startTime.isEmpty()){
                            movieLayoutVector.elementAt(i).setStartTime(startTime);
                            Date endDate = new Date();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh：mm：ss");
                            Date parseStartTime = new Date();
                            try {
                                parseStartTime = simpleDateFormat.parse(startTime);
                            } catch (ParseException ex) {
                                try {
                                    parseStartTime = simpleDateFormat1.parse(startTime);
                                } catch (ParseException exc) {

                                }
                            }
                            Vector<MovieInformation> temp = new MovieReadAndWrite().read();
                            for(int i = 0; i < temp.size(); i++){
                                if(temp.elementAt(i).getMovieName().equals(movieName)){
                                    //修改结束时间
                                    endDate.setTime(parseStartTime.getTime()+temp.elementAt(i).getDuration()*60*1000);
                                }
                            }
                            movieLayoutVector.elementAt(i).setEndTime(simpleDateFormat.format(endDate));
                        }
                        if(!projectionRoom.isEmpty()){
                            movieLayoutVector.elementAt(i).setProjectionRoom(new Integer(projectionRoom));

                        }

                        new MovieLayoutReadAndWrite().write(movieLayoutVector);
                        jDialog.dispose();
                        new LoginJDialog(5);
                        new MovieLayoutDataUI();
                    }
                }
                });
                newReturn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jDialog.dispose();
                        new MovieLayoutDataUI();
                    }
                });
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
    public ChangeJDialog(String admin,Vector<AdminData> vector){
        adminVector = vector;
        //初始化弹窗界面
        jDialog.getContentPane().setBackground(Color.ORANGE);
        jDialog.setIconImage(new ImageIcon("image//屏幕截图 2023-09-10 173516.png").getImage());
        jDialog.setSize(600,400);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.setModal(true);
        jDialog.getContentPane().setLayout(null);
        sureJbt.setFont(new Font("楷体",Font.BOLD,12));
        returnJbt.setFont(new Font("楷体",Font.BOLD,12));
        sureJbt.setBounds(230,320,60,30);
        returnJbt.setBounds(300,320,60,30);
        JLabel passwordJLabel = new JLabel("修改后密码：");
        passwordJLabel.setFont(new Font("华文楷体",Font.BOLD,20));
        passwordJLabel.setBounds(160,100,200,50);
        JTextField passwordFiled = new JTextField();
        passwordFiled.setBounds(300,100,200,50);
        jDialog.getContentPane().add(sureJbt);
        jDialog.getContentPane().add(returnJbt);
        jDialog.getContentPane().add(passwordJLabel);
        jDialog.getContentPane().add(passwordFiled);
        //添加事件
        sureJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取用户输入
                String temp = passwordFiled.getText();
                //密码输入是否符合规则
                if(temp.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\w\\s]).{8,16}$"))
                {       //查找对应账户，并修改密码
                    for (int i = 0; i < adminVector.size(); i++) {
                        String name = adminVector.elementAt(i).getName();
                        if(admin.equals(name)){
                            adminVector.elementAt(i).setPassword(temp);
                        }
                    }

                    new AdminReadAndWrite().write(adminVector);
                    jDialog.dispose();
                }else {
                    //密码输入不符合规则
                    new LoginJDialog(13);
                }
            }

        });
        returnJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();
            }
        });

        jDialog.setVisible(true);
    }

}
