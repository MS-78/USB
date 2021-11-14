import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.nio.file.FileSystem;

public class ReadUSB {
    public static void main(String[] args) {
        FileSystemView systemView = FileSystemView.getFileSystemView();
        File[] files = File.listRoots();
        for (File file : files) {
            System.out.println(file);
        }

        File file = null;
        String path = null;
        for (File file1 : files) {
            System.out.println(systemView.getSystemDisplayName(file1));
        }

        ListenerUSB listenerUSB = new ListenerUSB();
        listenerUSB.start();
    }
}
