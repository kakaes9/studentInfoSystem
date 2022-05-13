package org.controller;

import org.bean.Student;
import org.bean.User;
import org.mappers.StudentMapper;
import org.mappers.UserDaoMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author yjt
 * @create 2022-05-06-16:45
 */
@Controller
public class FirstController {
	//加载配置文件
    ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
    UserDaoMapper userMapper=act.getBean(UserDaoMapper.class);
    StudentMapper studentMapper=act.getBean(StudentMapper.class);

    //登录
    @RequestMapping("/LoginUser")
    public String LoginUser(HttpServletRequest request, HttpServletResponse response,HttpSession session,Model model)throws Exception{
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userMapper.selectUser(username, password);

        //该用户为管理员
        if(user!=null&&user.getUsername().equals("admin")) {
            session.setAttribute("USER", user);
            return"redirect:/IndexStudent";
        }


        if (user==null){
            //不存在此用户
            model.addAttribute("msg","账号未注册或密码错误，请重新输入");
            return "login";
        }else {
            //查到该用户
            session.setAttribute("User",user);
            Student student = studentMapper.selectId(user.getId());
            session.setAttribute("Stu",student);
            return "Studentindex";
        }

    }

    //将查询到的学生存入list集合
    @RequestMapping("/IndexStudent")
    public String IndexStudent(Model model) {
        List<Student> list=studentMapper.selectStudent();
        model.addAttribute("list",list);
        return "Index";
    }

    @RequestMapping("/toaddStudent")
    public String toaddStudent() {
        return "addstudent";
    }

    @RequestMapping("/addStudent")
    public String addStudent(Student student,Model model){
        if(studentMapper.selectId(student.getId())!=null) {
            model.addAttribute("msg","已存在改学生，请重新输入");
            return "addstudent";
        }else {
            studentMapper.addStudent(student);
            model.addAttribute("msg","添加成功");
            return "redirect:/IndexStudent";
        }
    }


    //退出功能
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }
    //获取注册信息并传到success页面
    @RequestMapping("/RegisterUser")
    public String RegisterUser(Student student,User user,Model model) {
        //获取输入的账号数据
        Integer id=user.getId();
        String username=user.getUsername();
        String password=user.getPassword();

        //注册并保存到数据库
        String idpo=id+"";//判断int型id为空
        if(idpo.equals("")||username.equals("")||password.equals("")) {
            System.out.println(String.valueOf(id));
            model.addAttribute("msg","输入为空，请重新输入");
            return "register";
        }
        else if(userMapper.selectId(id)!=null) {
            model.addAttribute("msg","该学号已注册，请重新输入");
            return "register";
        }else {
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            userMapper.addUser(user);
            student.setId(id);
            student.setName(username);
            studentMapper.addStudent(student);
            model.addAttribute("msg","注册成功，请重新登录");
            return "login";
        }
    }
    //跳转到登录框
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    //学生修改自己信息
    @RequestMapping("/update2")
    public String update2(HttpServletRequest request, Student student,HttpSession session,Model model)throws Exception {
        //获取用户
        Integer id=student.getId();
        String name=student.getName();
        String gender = student.getGender();
        Integer age=student.getAge();
        String phone=student.getPhone();
        String cla=student.getCla();
        //修改用户
        student.setId(id);
        student.setName(name);
        student.setGender(gender);
        student.setAge(age);
        student.setPhone(phone);
        student.setCla(cla);
        studentMapper.update(student);//调用方法进行修改
        //再次根据id查找用户，并让查找的信息显示到Studentindex界面
        Student student2=studentMapper.selectId(id);
        session.setAttribute("Stu",student2);
        System.out.println(student2.toString());
        session.setAttribute("msg","修改成功");
        return "Studentindex";
    }

    //获取修改用户的信息
    @RequestMapping("/toupdate")
    public String toupdate(Integer id,Model model) {
        Student student=studentMapper.selectId(id);
        model.addAttribute("Stu",student);
        return "updatestudent";
    }


    @RequestMapping("/toupdate2")
    public String toupdate2(HttpServletRequest request, HttpServletResponse response,HttpSession session,Model model)throws Exception {
        String id = request.getParameter("id");
        Student selectId = studentMapper.selectId(Integer.parseInt(id));
        model.addAttribute("Stu",selectId);
        return "update2";
    }
    @RequestMapping("/update")
    public String update(Student student,Model model){
        studentMapper.update(student);
        model.addAttribute("msg","修改成功");
        return "redirect:/IndexStudent";
    }
    @RequestMapping("delete")
    public String deleteById(Integer id ,Model model){
        System.out.println(id);
        studentMapper.deleteStuById(id);
        model.addAttribute("msg","删除成功");
        return "redirect:/IndexStudent";
    }

}
