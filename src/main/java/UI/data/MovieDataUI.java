package UI.data;

import UI.jDialog.AddJDialog;
import UI.jDialog.ChangeJDialog;
import UI.jDialog.DeleteJDialog;
import UI.jDialog.FindJDialog;
import UI.work.MangerWork;
import UI.work.ReceptionWork;
import data.packagingData.MovieInformation;
import data.readAndWriteFun.MovieReadAndWrite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public  class  MovieDataUI extends AdminDataUI implements ActionListener {
    //片名、导演、主演、剧情简介、时长
    Vector<MovieInformation> movieInformationVector = new Vector<>();
    JMenuItem findItem = new JMenuItem("查找");
    JMenuItem deleteItem = new JMenuItem("删除");
    JMenuItem addItem = new JMenuItem("添加");
    JMenuItem changeItem = new JMenuItem("修改");

    //经理所用界面
    public MovieDataUI() {
        IntiJMenu();
        returnJMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MangerWork();
            }
        });
    }

    //用户及前台查看电影信息时所用界面
    public MovieDataUI(int i){
        returnJMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MovieDataUI.this.dispose();
            }
        });
    }
    public MovieDataUI(Vector<MovieInformation> tempVector){
        IntiVectorsAgain(tempVector);
        returnJMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MangerWork();
            }
        });
    }

    //以下个方法的用途与MovieLayoutDataUI中一致
    @Override
    public void setColumns() {
        columns.add("片名");
        columns.add("导演");
        columns.add("主演");
        columns.add("剧情简介");
        columns.add("时长（min）");
    }
    @Override
    public void IntiVectors() {
        movieInformationVector = new MovieReadAndWrite().read();
        for (int i = 0 ; i  < movieInformationVector.size() ; i++) {
            Vector<Object> vector1 = new Vector<>();
            vector1.add(movieInformationVector.elementAt(i).getMovieName());
            vector1.add(movieInformationVector.elementAt(i).getDirector());
            vector1.add(movieInformationVector.elementAt(i).getLeadingRole());
            vector1.add(movieInformationVector.elementAt(i).getSynopsis());
            vector1.add(movieInformationVector.elementAt(i).getDuration());
            vectors.add(vector1);
        }
    }
    public void IntiVectorsAgain(Vector<MovieInformation> tempVector){

        vectors.removeAllElements();
        for (int i = 0 ; i  < tempVector.size() ; i++) {
            Vector<Object> vector1 = new Vector<>();
            vector1.add(tempVector.elementAt(i).getMovieName());
            vector1.add(tempVector.elementAt(i).getDirector());
            vector1.add(tempVector.elementAt(i).getLeadingRole());
            vector1.add(tempVector.elementAt(i).getSynopsis());
            vector1.add(tempVector.elementAt(i).getDuration());
            vectors.add(vector1);
        }
    }

    public void IntiJMenu() {
            jMenu.add(findItem);
            jMenu.add(deleteItem);
            jMenu.add(addItem);
            jMenu.add(changeItem);
            findItem.addActionListener(this);
            deleteItem.addActionListener(this);
            addItem.addActionListener(this);
            changeItem.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         Object source = e.getSource();
         if(source == findItem){
             IntiVectors();
             new FindJDialog(movieInformationVector);
             MovieDataUI.this.dispose();
         } else if (source == deleteItem) {
             IntiVectors();
             new DeleteJDialog(movieInformationVector);
             MovieDataUI.this.dispose();
         }else if(source == addItem){
             IntiVectors();
             new AddJDialog(movieInformationVector);
             MovieDataUI.this.dispose();
         } else if (source == changeItem) {
             IntiVectors();
             new ChangeJDialog(movieInformationVector);
             MovieDataUI.this.dispose();
         }
    }
}
