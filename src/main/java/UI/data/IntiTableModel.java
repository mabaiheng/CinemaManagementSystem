package UI.data;

import javax.swing.table.DefaultTableModel;

public class IntiTableModel extends DefaultTableModel {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
