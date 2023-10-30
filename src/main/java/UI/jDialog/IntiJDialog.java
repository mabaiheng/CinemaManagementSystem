package UI.jDialog;

import UI.IntiJFrame;
import data.packagingData.*;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class IntiJDialog extends IntiJFrame {
    public Vector<AdminData> adminVector = new Vector<>();
    public Vector<MovieInformation> movieVector = new Vector<>();
    public Vector<MovieLayoutData> movieLayoutVector = new Vector<>();

    public Vector<UserBuyHistory> getUserBuyHistoryVector() {
        return userBuyHistoryVector;
    }

    public void setUserBuyHistoryVector(Vector<UserBuyHistory> userBuyHistoryVector) {
        this.userBuyHistoryVector = userBuyHistoryVector;
    }

    public Vector<UserBuyHistory> userBuyHistoryVector = new Vector<>();
    public Vector<AdminData> getAdminVector() {
        return adminVector;
    }

    public void setAdminVector(Vector<AdminData> adminVector) {
        this.adminVector = adminVector;
    }

    public Vector<MovieInformation> getMovieVector() {
        return movieVector;
    }

    public void setMovieVector(Vector<MovieInformation> movieVector) {
        this.movieVector = movieVector;
    }

    public Vector<MovieLayoutData> getMovieLayoutVector() {
        return movieLayoutVector;
    }

    public void setMovieLayoutVector(Vector<MovieLayoutData> movieLayoutVector) {
        this.movieLayoutVector = movieLayoutVector;
    }

    public Vector<UserData> getUserVector() {
        return userVector;
    }

    public void setUserVector(Vector<UserData> userVector) {
        this.userVector = userVector;
    }

    public Vector<UserData> userVector = new Vector<>();
    JDialog jDialog = new JDialog();
    public IntiJDialog(){


        jDialog.getContentPane().setBackground(Color.ORANGE);
        jDialog.setIconImage(new ImageIcon("image//屏幕截图 2023-09-10 173516.png").getImage());
        jDialog.setSize(600,400);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.setModal(true);
        jDialog.setDefaultCloseOperation(NORMAL);

    }



    public IntiJDialog(Vector<?> Vector) {
        jDialog.getContentPane().setBackground(Color.ORANGE);
        jDialog.setIconImage(new ImageIcon("image//屏幕截图 2023-09-10 173516.png").getImage());
        jDialog.setSize(600,400);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.setModal(true);

    }


}
