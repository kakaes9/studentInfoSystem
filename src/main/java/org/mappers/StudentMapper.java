package org.mappers;

import org.apache.ibatis.annotations.Param;
import org.bean.Student;

import java.util.List;

/**
 * @author yjt
 * @create 2022-05-08-14:47
 */
public interface StudentMapper {

    //查询学生列表
    public List<Student> selectStudent();

    //添加学生
    public void addStudent(Student student);

    //根据id查询学生信息
    public Student selectId(@Param("id")Integer id);

    //修改用户信息
    void update(Student student);

    //根据id删除学生
    void deleteStuById(@Param("id")Integer id);
}
