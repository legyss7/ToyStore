import java.io.FileWriter;

public class FileDrawToys {
    private String fileName;
    private String info;

    public FileDrawToys(String fileName, String info) {
        this.fileName = fileName;
        this.info = info;
    }

    public void writeFile() {
        try (var fw = new FileWriter(fileName)) {
            fw.write(info);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
