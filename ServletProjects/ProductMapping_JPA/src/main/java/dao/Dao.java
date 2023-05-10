package dao;

import java.io.IOException;

public interface Dao {
    void insertData() throws IOException;
    void updateData() throws IOException;
    void deleteData() throws IOException;

}
