import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ListenerUSB extends Thread{
    FileSystemView systemView = FileSystemView.getFileSystemView();
    Map<File,Boolean> map = new HashMap<>();
    @Override
    public void run() {
        for(int i=0;i<File.listRoots().length;i++)
            map.put(File.listRoots()[i],true);
        int n = 0;
        while (true) {
            File[] files = File.listRoots();
            if (n == 0) {
                n = files.length;
            } else {
                if(n == files.length) continue;
                else {
                    if(files.length>n) {
                        for (File file : files)
                            if(map.get(file) == null){  // 检测到插入
                                Util.printAll(file);
                            }
                        n = files.length;
                    } else {  //检测到拔出
                        n = files.length;
                    }
                }
            }
        }
    }
}
