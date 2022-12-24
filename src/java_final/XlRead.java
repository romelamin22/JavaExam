package java_final;

import java.io.IOException;

public class XlRead {

    public static void main(String[] args) throws IOException {

        Reader obj = new Reader();

        String[][] data = obj.readXl("D:\\_Class\\my Files\\Excel Files\\test.xlsx","Sheet1");

        for (String[] row : data){

            for (String cell: row){
                System.out.println(cell);
            }
        }

    }
}
