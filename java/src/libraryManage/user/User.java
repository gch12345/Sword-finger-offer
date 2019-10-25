package libraryManage.user;

import libraryManage.operation.IOperation;

import java.sql.SQLException;

abstract public class User {
    protected String name;
    protected IOperation[] operations;

    public User(String name) {
        this.name = name;
    }

    abstract public int menu();

    public void doOprition(int choice) throws SQLException {
        operations[choice].work();
    }
}
