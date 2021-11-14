import java.io.*;
import java.net.URLConnection;
import java.nio.file.Files;

public class Util {

    static String OutputPath = "C:\\Users\\pc\\Desktop\\IMG\\";

    public static void printAll(File file) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.isDirectory())
                printAll(file1);
            if(file1.isFile()){
                try {
                    String type = Files.probeContentType(file1.toPath());
                    if (type == null) continue;
                    if (type.equals("image/jpeg") || type.equals("image/png")){

                        InputStreamReader isr = new InputStreamReader(new FileInputStream(file1));
                        BufferedReader br = new BufferedReader(isr);

                        System.out.println(file1);
                        String fileName = file1.getName();
                        File tempFile = new File(OutputPath+fileName);
                        tempFile.createNewFile();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
