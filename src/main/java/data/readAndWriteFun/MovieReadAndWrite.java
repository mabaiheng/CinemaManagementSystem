package data.readAndWriteFun;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import data.packagingData.AdminData;
import data.packagingData.MovieInformation;

import java.util.Vector;

public class MovieReadAndWrite {
    String fileName = "src/main/java/data/excel/movieData.xlsx";
    Vector<MovieInformation> vector = new Vector<>();

    public void write(Vector<MovieInformation> vector) {
        EasyExcel.write(fileName, data.packagingData.MovieInformation.class).sheet().doWrite(vector);
    }

    public Vector<MovieInformation> read() {
        EasyExcel.read(fileName, MovieInformation.class, new AnalysisEventListener<MovieInformation>() {
            @Override
            public void invoke(MovieInformation movieInformation, AnalysisContext analysisContext) {
                vector.add(movieInformation);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).sheet().doRead();
    return vector;
    }
}