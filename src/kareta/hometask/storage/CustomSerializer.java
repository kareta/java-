package kareta.hometask.storage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CustomSerializer implements Serializer, Runnable {

    private Object object;
    private String path;

    public CustomSerializer(Object object, String path) {
        this.object = object;
        this.path = path;
    }

    @Override
    public void Serialize(Object object, String path) {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(path, true)) {
            @Override
            protected void writeStreamHeader() throws IOException {
                reset();
            }
        }) {
            writer.writeObject(object);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void run() {
        Serialize(object, path);
    }
}
