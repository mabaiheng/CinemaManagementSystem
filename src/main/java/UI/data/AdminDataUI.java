package UI.data;

import UI.IntiJFrame;
import UI.jDialog.DeleteJDialog;
import UI.jDialog.FindJDialog;
import data.packagingData.AdminData;
import data.packagingData.MovieInformation;
import data.readAndWriteFun.AdminReadAndWrite;
import data.readAndWriteFun.MovieReadAndWrite;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AdminDataUI extends IntiJFrame{

    private Vector<AdminData> vector = new Vector<>();
    Vector<String>  columns = new Vector<>();
    Vector<Vector<Object>> vectors = new Vector<>();
    public void setColumns() {
        columns.add("账户");
        columns.add("密码");
    }


    public AdminDataUI(){
        setColumns();
        IntiVectors();
        intiForm();
        intijFrame();
        intiSystemTray();
    }

    public AdminDataUI(Vector<MovieInformation> tempVector){
        IntiVectors();
    }
    public void intiForm() {
        DefaultTableModel defaultTableModel = new IntiTableModel();
        defaultTableModel.setDataVector(vectors,columns);
        JTable jTable = new JTable(defaultTableModel);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        this.getContentPane().add(jScrollPane);
        JTableHeader tableHeader = jTable.getTableHeader();
        tableHeader.setFont(new Font(null,Font.BOLD,16));
        tableHeader.setForeground(Color.red);
        jTable.setFont(new Font(null,Font.PLAIN,14));
        jTable.setForeground(Color.black);
        jTable.setGridColor(Color.black);
        jTable.setRowHeight(30);
        jTable.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

    }

    public void IntiVectors() {
        vector = new AdminReadAndWrite().read();
        for (int i = 0 ; i  < vector.size() ; i++) {
            Vector<Object> vector1 = new Vector<>();
            vector1.add(vector.elementAt(i).getName());
            vector1.add(vector.elementAt(i).getPassword());
            vectors.add(vector1);
        }
    }


}
