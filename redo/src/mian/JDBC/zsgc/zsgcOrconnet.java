package mian.JDBC.zsgc;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class zsgcOrconnet {
    @Test
    public void  connet(){

        String sql = "update student set name =? where id = ?";
        update(sql,"DD","2");
    }

    @Test
    public void  connet2(){

        String sql = "update student set name =? where id = ?";
        int dd = update2(sql, "DjjjD", "2");
        if (dd>0){
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
    }


    public void update(String sql,Object ...args){
        Connection conn=null;
        PreparedStatement ps =null;
        try {
            conn=JUITcon.getConnection();

            ps=conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JUITcon.closeRES(conn,ps);
        }
    }

    public int update2(String sql,Object ...args){
        Connection conn=null;
        PreparedStatement ps =null;
        try {
            conn=JUITcon.getConnection();

            ps=conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
           /*ps.execute();
           * 如果执行的是查询操作，有返回结果，则此方法返回为true
           * 如果执行的是增删改操作，有返回结果，则此方法返回为false
           * */
           //返回sql影响的行数
          return ps.executeUpdate();
        } catch (Exception
                e) {
            e.printStackTrace();
        } finally {
            JUITcon.closeRES(conn,ps);
        }
        return 0;
    }

    @Test
    public void test1() throws Exception{
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            //1读取配置文件的4个信息
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties pros = new Properties();
            pros.load(is);

            String user=pros.getProperty("user");
            String password=pros.getProperty("password");
            String url=pros.getProperty("url");
            String driverClass=pros.getProperty("driverClass");
            // 2加载驱动
            Class.forName(driverClass);
            //3获取连接
            conn = DriverManager.getConnection(url, user, password);

            //4预编译sql，返回PreparedStatement实例
           /* //添加
            String sql="insert into student value (?,?,?)";
            pre = conn.prepareStatement(sql);
            //5填充占位符
            pre.setObject(1,4);
            pre.setObject(2,"sad");
            pre.setObject(3,14566);*/
           /*//修改
            String sql="update student set name=? where id=?";
            pre = conn.prepareStatement(sql);
            //5填充占位符
            pre.setObject(1,"sss");
            pre.setObject(2,4);*/
           //删除
            String sql="delete from student where id=?";
            pre = conn.prepareStatement(sql);
            //5填充占位符
            pre.setObject(1,4);



            //6执行操作
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //7关闭资源
            try {
                if (pre!=null){
                    pre.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
