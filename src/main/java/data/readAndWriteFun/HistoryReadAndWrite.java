package data.readAndWriteFun;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import data.packagingData.MovieLayoutData;
import data.packagingData.UserBuyHistory;

import java.util.Vector;

public class HistoryReadAndWrite {
    String fileName = "src/main/java/data/excel/UserBuyHistory.xlsx";
    Vector<UserBuyHistory> readVector = new Vector<>();
    public void write(Vector<UserBuyHistory> vector) {
        EasyExcel.write(fileName, data.packagingData.UserBuyHistory.class).sheet().doWrite(vector);
    }

    public Vector<UserBuyHistory> read() {
        EasyExcel.read(fileName, UserBuyHistory.class, new AnalysisEventListener<UserBuyHistory>() {
            @Override
            public void invoke(UserBuyHistory userBuyHistory , AnalysisContext analysisContext) {
                readVector.add(userBuyHistory);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).sheet().doRead();
        return readVector;
    }
}
