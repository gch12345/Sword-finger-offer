package libraryManage.operation;

import java.sql.SQLException;

public class ExitOperation implements IOperation{
    @Override
    public void work() throws SQLException {
        System.out.println("再见");
        System.exit(0);
    }
}
