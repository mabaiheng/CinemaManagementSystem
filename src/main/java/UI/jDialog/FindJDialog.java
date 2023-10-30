package UI.jDialog;

import UI.data.MovieDataUI;
import UI.data.MovieLayoutDataUI;
import UI.data.UserDataUI;
import UI.work.ReceptionWork;
import data.packagingData.*;
import data.readAndWriteFun.AdminReadAndWrite;
import data.readAndWriteFun.HistoryReadAndWrite;
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

public class FindJDialog extends IntiJDialog{
    JButton sureJbt = new JButton("确定");
    JButton returnJbt = new JButton("返回");

    public FindJDialog(Vector<?> vector) {
        //初始化都有的元件
        JLabel jLabel = new JLabel("你要查找的信息为:");
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

        //判断输入的vector中的数据的类型，以实现后续的操作
        Class<?> aClass = vector.elementAt(0).getClass();
        if(aClass.equals(UserData.class)){
            userDataFind((Vector<UserData>) vector);
        }else if (aClass.equals(MovieLayoutData.class)) {
            movieLayoutDataFind((Vector<MovieLayoutData>) vector);
        }else if (aClass.equals(AdminData.class)) {
            adminDataFind((Vector<AdminData>) vector);
        }else if(aClass.equals(MovieInformation.class)){
            movieInformationFind((Vector<MovieInformation>) vector);
        }else if(aClass.equals(UserBuyHistory.class)){
            userBuyHistoryFind((Vector<UserBuyHistory>) vector);
        }

        jDialog.setVisible(true);
    }

    private void movieInformationFind(Vector<MovieInformation> vector) {
        movieVector = vector;
        //初始化界面，元件大小，位置，事件
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
                        new LoginJDialog(4);
                    }else {
                        Vector<MovieInformation> tempMovieVector = new Vector<>();
                        for (int i = 0; i < movieVector.size(); i++) {
                            String tempMovieName = movieVector.elementAt(i).getMovieName();
                            String tempDirector = movieVector.elementAt(i).getDirector();
                            String tempLeadingRole = movieVector.elementAt(i).getLeadingRole();
                            if (tempMovieName.equals(movieName) && tempDirector.equals(director) && tempLeadingRole.equals(leadingRole)) {
                                //匹配成功
                                tempMovieVector.add(movieVector.elementAt(i));
                            }
                        }
                        jDialog.dispose();
                        new MovieDataUI(tempMovieVector);
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
    private void adminDataFind(Vector<AdminData> vector) {
        adminVector = vector;
        JLabel userAdmin = new JLabel("账户:");
        JTextField adminJText = new JTextField();
        userAdmin.setFont(new Font("楷体",Font.PLAIN,14));

        userAdmin.setBounds(300,30,40,30);
        adminJText.setBounds(360,30,200,30);

        jDialog.getContentPane().add(adminJText);
        jDialog.getContentPane().add(userAdmin);

        sureJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tempi = 0;
                String admin = adminJText.getText();
                for(int i = 0; i < adminVector.size(); i++){
                    String tempAdmin = adminVector.elementAt(i).getName();
                    if(tempAdmin.equals(admin)){
                        tempi = i;
                    }
                }
                secondLayout(tempi);
            }
            private void secondLayout(int i) {
                jDialog.getContentPane().repaint();
                jDialog.getContentPane().removeAll();

                JButton newSure = new JButton("确定");
                JButton newReturn = new JButton("返回");
                newSure.setFont(new Font("楷体",Font.BOLD,12));
                newReturn.setFont(new Font("楷体",Font.BOLD,12));
                newSure.setBounds(230,320,60,30);
                newReturn.setBounds(300,320,60,30);

                JLabel passwordJLabel = new JLabel("修改后密码：");
                passwordJLabel.setFont(new Font("华文楷体",Font.BOLD,20));
                passwordJLabel.setBounds(160,100,200,50);
                JTextField passwordFiled = new JTextField();
                passwordFiled.setBounds(300,100,200,50);

                jDialog.getContentPane().add(passwordJLabel);
                jDialog.getContentPane().add(passwordFiled);
                jDialog.getContentPane().add(newSure);
                jDialog.getContentPane().add(newReturn);

                newSure.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String temp = passwordFiled.getText();
                        adminVector.elementAt(i).setPassword(temp);
                        new AdminReadAndWrite().write(adminVector);
                        jDialog.dispose();
                    }


                });
                newReturn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jDialog.dispose();
                    }
                });
            }
        });
        returnJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();
            }
        });
    }
    private void userDataFind(Vector<UserData> vector){
        userVector = vector;
        //初始化界面，元件
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
        //添加按钮事件
        sureJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //用户输入
                String movieName = movieNameJText.getText();
                String director = directorNameJText.getText();
                //数据匹配
                Vector<UserData> temp = new Vector<>();
                for(int i = 0; i < userVector.size(); i++){
                    String tempMovieName = userVector.elementAt(i).getUserID();
                    String tempDirector = userVector.elementAt(i).getUserName();
                    if(tempMovieName.equals(movieName)&&tempDirector.equals(director)){
                       //匹配成功
                        temp.add(userVector.elementAt(i));
                    }
                }

                jDialog.dispose();
                new UserDataUI(temp);

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
    private void userBuyHistoryFind(Vector<UserBuyHistory> vector){
        userBuyHistoryVector = vector;
        //设置元件的属性
        JLabel ticketCode = new JLabel("取票码:");
        JTextField ticketCodeJText = new JTextField();
        ticketCode.setFont(new Font("楷体",Font.PLAIN,14));
        ticketCode.setBounds(260,30,80,30);
        ticketCodeJText.setBounds(360,30,200,30);
        jDialog.getContentPane().add(ticketCodeJText);
        jDialog.getContentPane().add(ticketCode);

        sureJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();
                //获得用户输入
                String ticketCode = ticketCodeJText.getText();
                //匹配合适的数据。
                Vector<UserBuyHistory> temp = new Vector<>();
                for(int i = 0; i < userBuyHistoryVector.size(); i++){
                    String tempTicketCode = userBuyHistoryVector.elementAt(i).getTicketCode();
                    if(tempTicketCode.equals(ticketCode)&&userBuyHistoryVector.elementAt(i).getContent() != 0){
                        new LoginJDialog(8);
                        userBuyHistoryVector.elementAt(i).setContent(0);
                        new HistoryReadAndWrite().write(userBuyHistoryVector);
                    }else if (tempTicketCode.equals(ticketCode)&&userBuyHistoryVector.elementAt(i).getContent() == 0){
                        new LoginJDialog(9);
                    }
                }




            }
        });
        returnJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();
            }
        });
    }
   private void movieLayoutDataFind(Vector<MovieLayoutData> vector) {
        movieLayoutVector = vector;
        //初始化界面，元件大小，位置，事件
        JLabel movieName = new JLabel("电影名:");
        JLabel movieProjectionRoom = new JLabel("放映室:");
        JLabel movieStartTime = new JLabel("开始时间:");
        JTextField nameJText = new JTextField();
        JTextField roomJText = new JTextField();
        JTextField timeJText = new JTextField();
        movieName.setFont(new Font("楷体",Font.PLAIN,14));
        movieProjectionRoom.setFont(new Font("楷体",Font.PLAIN,14));
        movieStartTime.setFont(new Font("楷体",Font.PLAIN,14));
        movieName.setBounds(240,30,100,30);
        movieProjectionRoom.setBounds(240,100,100,30);
        movieStartTime.setBounds(240,170,100,30);
        nameJText.setBounds(360,30,200,30);
        roomJText.setBounds(360,100,200,30);
        timeJText.setBounds(360,170,200,30);
        jDialog.getContentPane().add(movieName);
        jDialog.getContentPane().add(movieStartTime);
        jDialog.getContentPane().add(movieProjectionRoom);
        jDialog.getContentPane().add(nameJText);
        jDialog.getContentPane().add(roomJText);
        jDialog.getContentPane().add(timeJText);
        //添加按钮事件
        sureJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<MovieLayoutData> temp = new Vector<>();
                //获得用户输入
                String movieName = nameJText.getText();
                String projectionRoom =  roomJText.getText();
                String startTime = timeJText.getText();

                if(movieName.isEmpty()&&projectionRoom.isEmpty()&&startTime.isEmpty()){
                   //输入为空
                    new LoginJDialog(4);
                } else{
                    //取出excel中的数据，并于用户输入先配对
                    for(int i = 0; i < movieLayoutVector.size(); i++){
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh：mm：ss");

                        String tempMovieName = movieLayoutVector.elementAt(i).getMovieName();
                        int  tempProjectionRoom  = movieLayoutVector.elementAt(i).getProjectionRoom();
                        String tempStartTime  = movieLayoutVector.elementAt(i).getStartTime();
                        if(projectionRoom.isEmpty())projectionRoom="0";
                        int intProjectionRoom = new Integer(projectionRoom);
                        //标准化格式
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

                        boolean bl1 = false;
                        boolean bl2 = false;
                        boolean bl3 = false;
                        if(movieName.isEmpty()||movieName.equals(tempMovieName)){bl1 = true;}
                        if(projectionRoom.isEmpty()||intProjectionRoom==tempProjectionRoom){bl2 = true;}
                        if(startTime.isEmpty()||startDate.equals(tempStartDate)){bl3 = true;}
                        if(bl1&&bl2&&bl3){
                            //匹配成功
                            temp.add(movieLayoutVector.elementAt(i));
                        }

                    }

                    jDialog.dispose();
                    new MovieLayoutDataUI(temp);
                }

            }

        });
        returnJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();
            }
        });
    }

    public FindJDialog(Vector<MovieLayoutData> vector,String admin){
        movieLayoutVector = vector;
        //设置弹窗界面
        jDialog.getContentPane().setBackground(Color.ORANGE);
        jDialog.setIconImage(new ImageIcon("image//屏幕截图 2023-09-10 173516.png").getImage());
        jDialog.setSize(600,400);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.setModal(true);
        jDialog.setDefaultCloseOperation(NORMAL);
        JLabel jLabel = new JLabel("你要查找的信息为:");
        jLabel.setFont(new Font("华文楷体",Font.BOLD,20));
        jLabel.setBounds(30,100,200,50);
        jDialog.getContentPane().setLayout(null);
        sureJbt.setFont(new Font("楷体",Font.BOLD,12));
        returnJbt.setFont(new Font("楷体",Font.BOLD,12));
        sureJbt.setBounds(230,320,60,30);
        returnJbt.setBounds(300,320,60,30);
        JLabel movieName = new JLabel("电影名:");
        JLabel movieProjectionRoom = new JLabel("放映室:");
        JLabel movieStartTime = new JLabel("开始时间:");
        JTextField nameJText = new JTextField();
        JTextField roomJText = new JTextField();
        JTextField timeJText = new JTextField();
        movieName.setFont(new Font("楷体",Font.PLAIN,14));
        movieProjectionRoom.setFont(new Font("楷体",Font.PLAIN,14));
        movieStartTime.setFont(new Font("楷体",Font.PLAIN,14));
        movieName.setBounds(240,30,100,30);
        movieProjectionRoom.setBounds(240,100,100,30);
        movieStartTime.setBounds(240,170,100,30);
        nameJText.setBounds(360,30,200,30);
        roomJText.setBounds(360,100,200,30);
        timeJText.setBounds(360,170,200,30);
        jDialog.getContentPane().add(sureJbt);
        jDialog.getContentPane().add(returnJbt);
        jDialog.getContentPane().add(jLabel);
        jDialog.getContentPane().add(movieName);
        jDialog.getContentPane().add(movieStartTime);
        jDialog.getContentPane().add(movieProjectionRoom);
        jDialog.getContentPane().add(nameJText);
        jDialog.getContentPane().add(roomJText);
        jDialog.getContentPane().add(timeJText);

        //添加按钮事件
        sureJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<MovieLayoutData> temp = new Vector<>();
                //获得用户输入
                String movieName = nameJText.getText();
                String projectionRoom =  roomJText.getText();
                String startTime = timeJText.getText();

                if(movieName.isEmpty()&&projectionRoom.isEmpty()&&startTime.isEmpty()){
                    //输入为空
                    new LoginJDialog(4);
                } else {
                    //遍历数据，匹配合适的输入
                    for (int i = 0; i < movieLayoutVector.size(); i++) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh：mm：ss");
                        String tempMovieName = movieLayoutVector.elementAt(i).getMovieName();
                        int tempProjectionRoom = movieLayoutVector.elementAt(i).getProjectionRoom();
                        String tempStartTime = movieLayoutVector.elementAt(i).getStartTime();
                        if (projectionRoom.isEmpty()) projectionRoom = "0";
                        int intProjectionRoom = new Integer(projectionRoom);
                        //格式化时间数据
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

                        boolean bl1 = false;
                        boolean bl2 = false;
                        boolean bl3 = false;
                        if (movieName.isEmpty() || movieName.equals(tempMovieName)) {
                            bl1 = true;
                        }
                        if (intProjectionRoom == 0 || intProjectionRoom == tempProjectionRoom) {
                            bl2 = true;
                        }
                        if (startTime.isEmpty() || startDate.equals(tempStartDate)) {
                            bl3 = true;
                        }
                        if (bl1 && bl2 && bl3) {
                            //找到合适输入
                            temp.add(movieLayoutVector.elementAt(i));
                        }

                    }
                    jDialog.dispose();
                    new MovieLayoutDataUI(temp, admin);
                }
            }
        });
        returnJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();
                new MovieLayoutDataUI(movieLayoutVector,admin);
            }
        });

        jDialog.setVisible(true);
    }
    public FindJDialog(Vector<UserBuyHistory> vector,int i){
        userBuyHistoryVector = vector;
        //初始化界面，以及个元件位置，大小，事件
        jDialog.getContentPane().setBackground(Color.ORANGE);
        jDialog.setIconImage(new ImageIcon("image//屏幕截图 2023-09-10 173516.png").getImage());
        jDialog.setSize(600,400);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.setModal(true);
        jDialog.setDefaultCloseOperation(NORMAL);
        JLabel jLabel = new JLabel("你要查找的信息为:");
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
        JLabel movieName = new JLabel("电影名:");
        JLabel movieProjectionRoom = new JLabel("放映室:");
        JLabel userName = new JLabel("用户名:");
        JLabel allprice = new JLabel("支付金额:");
        JTextField movieNameJText = new JTextField();
        JTextField userNameJText = new JTextField();
        JTextField roomJText = new JTextField();
        JTextField priceJText = new JTextField();
        movieName.setFont(new Font("楷体",Font.PLAIN,14));
        movieProjectionRoom.setFont(new Font("楷体",Font.PLAIN,14));
        userName.setFont(new Font("楷体",Font.PLAIN,14));
        allprice.setFont(new Font("楷体",Font.PLAIN,14));
        movieName.setBounds(240,30,100,30);
        movieProjectionRoom.setBounds(240,100,100,30);
        userName.setBounds(240,170,100,30);
        allprice.setBounds(240,240,200,30);
        movieNameJText.setBounds(360,30,200,30);
        roomJText.setBounds(360,100,200,30);
        userNameJText.setBounds(360,170,200,30);
        priceJText.setBounds(360,240,200,30);
        jDialog.getContentPane().add(movieName);
        jDialog.getContentPane().add(movieProjectionRoom);
        jDialog.getContentPane().add(userName);
        jDialog.getContentPane().add(allprice);
        jDialog.getContentPane().add(roomJText);
        jDialog.getContentPane().add(priceJText);
        jDialog.getContentPane().add(movieNameJText);
        jDialog.getContentPane().add(userNameJText);
        //添加按钮事件
        sureJbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<UserBuyHistory> temp = new Vector<>();
                //获得用户输入
                String movieName = movieNameJText.getText();
                String projectionRoom =  roomJText.getText();
                String userName = userNameJText.getText();
                String allPrice = priceJText.getText();

                if(movieName.isEmpty()||projectionRoom.isEmpty()||userName.isEmpty()||allPrice.isEmpty()){
                    //输入为空
                    new LoginJDialog(4);
                } else{
                    //获得excel中的数据，并于输入数据进行匹配
                    for(int i = 0; i < userBuyHistoryVector.size(); i++){
                        String tempMovieName = userBuyHistoryVector.elementAt(i).getMovieName();
                        int  tempProjectionRoom  = userBuyHistoryVector.elementAt(i).getProjectionRoom();
                        String tempUserName  = userBuyHistoryVector.elementAt(i).getUserName();
                        float tempPrice  = userBuyHistoryVector.elementAt(i).getPrice();
                        //标准化格式
                        int intProjectionRoom = new Integer(projectionRoom);
                        float floatAllPrice = new Float(allPrice);

                        if(tempUserName.equals(userName)&&tempMovieName.equals(movieName)&&tempProjectionRoom==intProjectionRoom&&
                        tempPrice == floatAllPrice&&userBuyHistoryVector.elementAt(i).getContent()!=0){
                            //匹配成功后，输出电影票数据
                            new LoginJDialog(userBuyHistoryVector.elementAt(i));
                        }

                    }
                    jDialog.dispose();
                    new ReceptionWork();
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
