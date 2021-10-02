import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("D:\\test\\pr3");
        SearchAndDeleteFile searchAndDeleteFile = new SearchAndDeleteFile(file);
        searchAndDeleteFile.startDeleteFiles();
    }
}
