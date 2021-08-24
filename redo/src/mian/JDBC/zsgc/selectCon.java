package mian.JDBC.zsgc;

import mian.JDBC.bean.student;
import mian.JDBC.bean.teachar;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class selectCon {

    //对student表的查询
    @Test
    public void student() throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JUITcon.getConnection();
            String sql="select * from student where id =?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,1);

            //执行并返回结果集
            resultSet = ps.executeQuery();

            if (resultSet.next()){
                int id =resultSet.getInt(1);
                String name =resultSet.getString(2);
                String phone =resultSet.getString(3);

                //方式一
                // System.out.println("id ="+id+",name ="+name+",phone ="+phone);

                //方式二
                //Object[] objects = new Object[]{id,name,phone};

                //方式三，建一个类，将数据封装成一个对象 (推荐)
                student student = new student(id, name, phone);
                System.out.println(student);


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        JUITcon.closeRES(conn,ps,resultSet);
        }

    }

    @Test
    public void student1() throws Exception {
        String sql="select * from student where id =?";
        student student = findStudent(sql, 2);
        System.out.println(student);

    }
    @Test
    public void teachar1() throws Exception {
        String sql="select s_id id,s_name name,s_phone phone from teachar where s_id =?";
        teachar teachar = findTeachar(sql, 2);
        System.out.println(teachar);

    }
    @Test
    public void teachar2() throws Exception {
        String sql="select s_id id,s_name name,s_phone phone from teachar where s_id =?";
        teachar teachar = getselectone(teachar.class, sql, 2);
        System.out.println(teachar);

        String sql1="select * from student where id =?";
        student student = getselectone(student.class, sql1, 2);
        System.out.println(student);

    }

    @Test
    public void teachar3() throws Exception {
        String sql="select s_id id,s_name name,s_phone phone from teachar ";
        List<teachar> teachar = getselectmore(teachar.class, sql);
        System.out.println(teachar);

        String sql1="select * from student ";
        List<student> student = getselectmore(student.class, sql1);

        System.out.println(student);

    }
    @Test
    public void teachar4() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查询的学生号:");
        String next = scanner.next();
        String sql="select s_id id,s_name name,s_phone phone from teachar where s_name =?";
        teachar teachar = getselectone(teachar.class, sql, next);
        System.out.println(teachar);


    }


    //查询teachar的数据
    @Test
    public void teachar() throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            conn = JUITcon.getConnection();
            String sql="select * from teachar where s_id =?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,1);

            //执行并返回结果集
            res = ps.executeQuery();

            if (res.next()){
                int id =res.getInt(1);
                String name =res.getString(2);
                String phone =res.getString(3);

                teachar teachar = new teachar(id, name, phone);
                System.out.println(teachar);


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JUITcon.closeRES(conn,ps,res);
        }

    }

    //对student表的通用操作
    public  student findStudent(String sql,Object ...args) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            conn = JUITcon.getConnection();
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }

            res = ps.executeQuery();
            //获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = res.getMetaData();
            //通过ResultSetMetaData获取结果集的中的列数
            int columnCount = rsmd.getColumnCount();
            if (res.next()) {
                student student = new student();
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columValue = res.getObject(i + 1);
                    //获取每个列的列名:getColumnName();
                    //获取每个列的别名:getColumnLabel();
                   // String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //给student对象指定的columnName属性，赋值为columnValue，通过反射
                    Field field = mian.JDBC.bean.student.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(student,columValue);

                }
                return student;
           }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        JUITcon.closeRES(conn,ps,res);
        }
        return null;
    }

    //对Teachar表的通用操作
    public  teachar findTeachar(String sql,Object ...args) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            conn = JUITcon.getConnection();
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }

            res = ps.executeQuery();
            //获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = res.getMetaData();
            //通过ResultSetMetaData获取结果集的中的列数
            int columnCount = rsmd.getColumnCount();
            if (res.next()) {
                teachar teachar = new teachar();
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columValue = res.getObject(i + 1);
                    //获取每个列的列名:getColumnName();
                    //获取每个列的别名:getColumnLabel();
                    //String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //给student对象指定的columnName属性，赋值为columnValue，通过反射
                    Field field = teachar.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(teachar,columValue);

                }
                return teachar;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JUITcon.closeRES(conn,ps,res);
        }
        return null;
    }

    //查询的通用方法，只能查一条数据
    public <T> T getselectone(Class<T> clazz, String sql, Object ...args) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            conn = JUITcon.getConnection();
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            res = ps.executeQuery();
            //获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = res.getMetaData();
            //通过ResultSetMetaData获取结果集的中的列数
            int columnCount = rsmd.getColumnCount();
            if (res.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columValue = res.getObject(i + 1);
                    //获取每个列的列名:getColumnName();
                    //获取每个列的别名:getColumnLabel();
                    //String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //给student对象指定的columnName属性，赋值为columnValue，通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columValue);

                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JUITcon.closeRES(conn, ps, res);
        }
        return null;
    }

    //查询的通用方法，能查多条数据
    public <T> List<T> getselectmore(Class<T> clazz, String sql, Object ...args) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            conn = JUITcon.getConnection();
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            res = ps.executeQuery();
            //获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = res.getMetaData();
            //通过ResultSetMetaData获取结果集的中的列数
            int columnCount = rsmd.getColumnCount();

            //创建集合
            ArrayList<T> lists = new ArrayList<>();
            while (res.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columValue = res.getObject(i + 1);
                    //获取每个列的列名:getColumnName();
                    //获取每个列的别名:getColumnLabel();
                    //String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //给student对象指定的columnName属性，赋值为columnValue，通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columValue);

                }
                lists.add(t);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JUITcon.closeRES(conn, ps, res);
        }
        return null;
    }
}
