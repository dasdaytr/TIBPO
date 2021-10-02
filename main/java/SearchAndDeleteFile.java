import java.io.File;

public class SearchAndDeleteFile {
    private File file;
    private String stringPath;

    public SearchAndDeleteFile(File file){
        this.file = file;
    }
    public SearchAndDeleteFile(String stringPath){
        this.stringPath = stringPath;
        file = new File(stringPath);
    }
    private static boolean init(){
        return false;
    }
    public boolean startDeleteFiles(){
        return init();
    }
}
