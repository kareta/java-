package kareta.hometask.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CustomDeserializer implements Deserializer, Runnable {

    private String path;
    private boolean done;
    private Object result;

    public CustomDeserializer(String path) {
        this.path = path;
    }

    public Object getResult() {
        return result;
    }

    public boolean isDone() {
        return done;
    }

    @Override
    public Object Deserialize(String path) {
        File file = new File(path);
        try {
            FileInputStream f = new FileInputStream(file);
            ObjectInputStream reader = new ObjectInputStream(f);
            Object object = reader.readObject();
            f.close();
            return object;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void run() {
        result = Deserialize(path);
        done = true;
    }
}
