package dataDriven;

import java.io.IOException;
import java.util.ArrayList;

public class TestSample {
    public static void main(String[] args) throws IOException {
        DataDriven dataDriven = new DataDriven();
        ArrayList<String> data = dataDriven.getData("Login");
        System.out.println(data.get(0));
        System.out.println(data.get(1));
        System.out.println(data.get(2));
    }

}
