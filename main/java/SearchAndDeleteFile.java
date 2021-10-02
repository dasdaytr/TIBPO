import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class SearchAndDeleteFile {
    private final File file;
    private final InitBytes initBytes;
    private static File p;

    public SearchAndDeleteFile(File file){
        this.file = file;
        initBytes = new InitBytes();
    }
    public SearchAndDeleteFile(String stringPath){
        file = new File(stringPath);
        initBytes = new InitBytes();
    }

    private  boolean init(){
        p = file.getParentFile();
        if(file.isDirectory()){
            searchFileAndDelete(file);
        }else{
            return file.delete();
        }
        return file.delete();
    }
    public boolean startDeleteFiles(){

        return init();
    }
    private File searchFileAndDelete(File files){
        File parent = files.getParentFile();
        System.out.println(p.getPath());
        System.out.println(files.getPath());
        if(p.getPath().equals(files.getPath())){
            return null;
        }
        for(File item: Objects.requireNonNull(files.listFiles())){
            if(item.isDirectory()){
                return searchFileAndDelete(item);
            }
            else{
                overwritingFile(item);
                item.delete();
            }
        }
        files.delete();
        return searchFileAndDelete(parent);
    }
    private void overwritingFile(File file){
        byte[] buffer = new byte[0];
        try(FileInputStream fis = new FileInputStream(file)) {
            buffer = fis.readAllBytes();
            for(int i=0; i<buffer.length;i++){
                System.out.println(buffer[i]);
                buffer[i] = initBytes.getOnes();
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }


        for(int i = 0; i < 7;i++){
            try(FileOutputStream fos = new FileOutputStream(file)) {
                if(i==0) fos.write(buffer);
                else if(i==1){
                    Arrays.fill(buffer, initBytes.getZeros());
                }
                else {
                    for(int j = 0; j < buffer.length;j++){
                        buffer[j] = initBytes.getRandomBytes();
                    }
                }
                fos.write(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
