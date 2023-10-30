package UI.data;

import UI.jDialog.AddJDialog;
import UI.jDialog.ChangeJDialog;
import UI.jDialog.DeleteJDialog;
import UI.jDialog.FindJDialog;
import UI.work.MangerWork;
import UI.work.ReceptionWork;
import UI.work.UserWork;
import data.packagingData.MovieInformation;
import data.packagingData.MovieLayoutData;
import data.readAndWriteFun.MovieLayoutReadAndWrite;
import data.readAndWriteFun.MovieReadAndWrite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MovieLayoutDataUI extends AdminDataUI implements ActionListener {
    private Vector<MovieLayoutData> movieLayoutDataVector = new Vector<>();
    String admin;
    JMenuItem deleteItem = new JMenuItem("删除场次");
    JMenuItem addItem = new JMenuItem("添加场次");
    JMenuItem changeItem = new JMenuItem("修改场次");
    JMenuItem findItem = new JMenuItem("查找场次");
    JMenuItem lookItem = new JMenuItem("场次信息");

    //添加头标
    @Override
    public void setColumns() {
        columns.add("片名");
        columns.add("放映室");
        columns.add("开始时间");
        columns.add("结束时间");
        columns.add("价格（元）");
    }

    //为Vectors获取excel中的数据，并用来呈现
    @Override
    public void IntiVectors() {
        movieLayoutDataVector = new MovieLayoutReadAndWrite().read();
        for (int i = 0 ; i  < movieLayoutDataVector.size() ; i++) {
            Vector<Object> vector1 = new Vector<>();
            vector1.add(movieLayoutDataVector.elementAt(i).getMovieName());
            vector1.add(movieLayoutDataVector.elementAt(i).getProjectionRoom());
            vector1.add(movieLayoutDataVector.elementAt(i).getStartTime());
            vector1.add(movieLayoutDataVector.elementAt(i).getEndTime());
            vector1.add(movieLayoutDataVector.elementAt(i).getPrice());
            vectors.add(vector1);
        }
    }

    //更新Vectors中的数据，用于查找数据后的呈现
    public void IntiVectorsAgain(Vector<MovieLayoutData> tempVector){
        vectors.removeAllElements();
        for (int i = 0 ; i  < tempVector.size() ; i++) {
            Vector<Object> vector1 = new Vector<>();
            vector1.add(tempVector.elementAt(i).getMovieName());
            vector1.add(tempVector.elementAt(i).getProjectionRoom());
            vector1.add(tempVector.elementAt(i).getStartTime());
            vector1.add(tempVector.elementAt(i).getEndTime());
            vector1.add(tempVector.elementAt(i).getPrice());
            vectors.add(vector1);
        }
    }

    //初始界面
    public MovieLayoutDataUI() {
        IntiJMenu();
        returnJMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MangerWork();
            }
        });
    }

    //获得更新数据后的界面
    public MovieLayoutDataUI(Vector<MovieLayoutData> tempVector){
        IntiVectorsAgain(tempVector);
        IntiUserJMenu();}

    //用户购票是显示界面
    public MovieLayoutDataUI(Vector<MovieLayoutData> tempVector,String admin){
        this.admin = admin;
        IntiVectorsAgain(tempVector);
        IntiUserJMenu();
        //查找到精确的数据后，打开其座位显示
        if(tempVector.size()==1&&!admin.equals("0")){
            //出座位按钮，失去查找按钮
            findItem.setVisible(false);
            jMenu.add(lookItem);
            //为按钮添加事件
            lookItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MovieLayoutDataUI.this.dispose();
                    new SeatDataUI(admin,tempVector.elementAt(0));
                }
            });
        } else if (tempVector.size()==1&&admin.equals("0")) {
            findItem.setVisible(false);
            jMenu.add(lookItem);
            lookItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MovieLayoutDataUI.this.dispose();
                    new SeatDataUI(tempVector.elementAt(0));
                }
            });
        }

        findItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FindJDialog(tempVector,admin);
                MovieLayoutDataUI.this.dispose();
            }
        });
        if(admin.equals("0")){returnJMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new ReceptionWork();
                }
            });
        }else {returnJMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new UserWork(admin);
            }
        });}
    }

    //添加经理菜单
    public void IntiJMenu() {
        jMenu.add(deleteItem);
        jMenu.add(addItem);
        jMenu.add(changeItem);
        deleteItem.addActionListener(this);
        addItem.addActionListener(this);
        changeItem.addActionListener(this);
    }

    //用户菜单
    public void IntiUserJMenu(){
        jMenu.add(findItem);
        findItem.addActionListener(this);
    }

    //经理菜单添加事件
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == addItem){
            IntiVectors();
            new AddJDialog(movieLayoutDataVector);
            MovieLayoutDataUI.this.dispose();
        } else if (source == deleteItem) {
            IntiVectors();
            new DeleteJDialog(movieLayoutDataVector);
            MovieLayoutDataUI.this.dispose();
        } else if (source == changeItem) {
            IntiVectors();
            new ChangeJDialog(movieLayoutDataVector);
            MovieLayoutDataUI.this.dispose();
        } else if (source == lookItem) {

        }
    }
}
