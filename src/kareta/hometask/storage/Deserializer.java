package kareta.hometask.storage;


import java.io.File;

public interface Deserializer {
    Object Deserialize(String path);
}
