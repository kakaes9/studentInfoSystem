package org.test;

import org.apache.ibatis.io.Resources;
import java.sql.Statement;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.bean.Student;
import org.bean.User;
import org.mappers.StudentMapper;
import org.mappers.UserDaoMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author yjt
 * @create 2022-05-05-20:47
 */
public class Test {
//    public static void main(String[] args) throws IOException {
//        //读取MyBatis的核心配置文件
//        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
////
//////        //获取SqlSessionFactoryBuilder对象
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
////
////        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
////
//        //获取sqlSession，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
////        SqlSession sqlSession = sqlSessionFactory.openSession();
////        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//
//        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);
//
//        User admin = mapper.selectUser("admin", "123456");
//        System.out.println(admin);
//
//
//
//        //        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//////        sqlSession.
////        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);
////        User admin = mapper.selectUser("admin", "123456");
////        System.out.println(admin.toString());
////        sqlSession.close();
//    }

    public static void main(String[] args) {
        ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDaoMapper userDaoMapper= (UserDaoMapper) act.getBean("userDaoMapper");
        System.err.println(userDaoMapper);
//        User admin = userDaoMapper.selectUser("admin", "123456");
//        System.out.println(admin);
         StudentMapper studentMapper= (StudentMapper)act.getBean("studentMapper");
        List<Student> students = studentMapper.selectStudent();
        for (Student stu:students         ) {
            System.out.println(stu);
        }

    }



}
