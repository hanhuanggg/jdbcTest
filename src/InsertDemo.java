import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDemo {

    public static void main(String[] args) throws SQLException {
        //1.创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/jdbcTest?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("123456");
        //2.建立连接
        Connection connection = dataSource.getConnection();
        //3.构造sql语句
        String sql = "insert into student values(1,'张三');";
        //4.预处理语句,将String转化成sql
        PreparedStatement statement = connection.prepareStatement(sql);
        //5.执行
        statement.executeUpdate();
        //6.断开连接,释放资源
        statement.close();
        connection.close();
    }
}