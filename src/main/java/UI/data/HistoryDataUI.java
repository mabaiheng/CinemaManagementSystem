package UI.data;

import UI.jDialog.AddJDialog;
import UI.jDialog.ChangeJDialog;
import UI.jDialog.DeleteJDialog;
import UI.jDialog.FindJDialog;
import data.packagingData.MovieInformation;
import data.packagingData.UserBuyHistory;
import data.readAndWriteFun.HistoryReadAndWrite;
import data.readAndWriteFun.MovieReadAndWrite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class HistoryDataUI extends AdminDataUI{
    Vector<UserBuyHistory> userBuyHistoryVector = new Vector<>();

    String admin = new String();
    public HistoryDataUI(Vector<UserBuyHistory> tempVector){
        IntiVectorsAgain(tempVector);
        returnJMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });
    }

    @Override
    public void setColumns() {
        columns.add("用户名");
        columns.add("片名");
        columns.add("购买时间");
        columns.add("开始时间");
        columns.add("场次");
        columns.add("取票码");
        columns.add("票含量（个）");
    }

    @Override
    public void IntiVectors() {
        userBuyHistoryVector = new HistoryReadAndWrite().read();
        for (int i = 0; i < userBuyHistoryVector.size(); i++) {
                Vector<Object> vector1 = new Vector<>();
                vector1.add(userBuyHistoryVector.elementAt(i).getUserName());
                vector1.add(userBuyHistoryVector.elementAt(i).getMovieName());
                vector1.add(userBuyHistoryVector.elementAt(i).getBuyTime());
                vector1.add(userBuyHistoryVector.elementAt(i).getStartTime());
                vector1.add(userBuyHistoryVector.elementAt(i).getProjectionRoom());
                vector1.add(userBuyHistoryVector.elementAt(i).getTicketCode());
                vector1.add(userBuyHistoryVector.elementAt(i).getContent());

                vectors.add(vector1);

        }
    }

    public void IntiVectorsAgain(Vector<UserBuyHistory> tempVector){

        vectors.removeAllElements();
        for (int i = 0 ; i  < tempVector.size() ; i++) {
            Vector<Object> vector1 = new Vector<>();
            vector1.add(tempVector.elementAt(i).getUserName());
            vector1.add(tempVector.elementAt(i).getMovieName());
            vector1.add(tempVector.elementAt(i).getBuyTime());
            vector1.add(tempVector.elementAt(i).getStartTime());
            vector1.add(tempVector.elementAt(i).getProjectionRoom());
            vector1.add(tempVector.elementAt(i).getTicketCode());
            vector1.add(tempVector.elementAt(i).getContent());
            vectors.add(vector1);
        }
    }

}
