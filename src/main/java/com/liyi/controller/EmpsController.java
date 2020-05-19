package com.liyi.controller;

import com.liyi.dao.DepartmentDao;
import com.liyi.dao.EmployeeDao;
import com.liyi.entities.Department;
import com.liyi.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * @author 李毅
 * @version V1.0
 * @Package com.liyi.controller
 * @date 2020/5/7 9:38
 * @Copyright © liyi
 */
@CrossOrigin(origins = "*")
@Controller
public class EmpsController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    //    查询所有员工返回列表页面
    @GetMapping(value = "emps")
    public ModelAndView list(ModelAndView modelAndView) {
        Collection<Employee> all = employeeDao.getAll();
//        放在请求中
        modelAndView.addObject("emps", all);
        modelAndView.setViewName("emp/list"); //SpringBoot会自动拼接 calsspath：/enp/list.html
        return modelAndView;
    }

    @GetMapping("emp")
    public ModelAndView toAddPage(ModelAndView modelAndView) {
//        动态获取部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        modelAndView.addObject("depts", departments);
        modelAndView.setViewName("emp/addandedit");
//        来到添加页面
        return modelAndView;
    }

    //    员工添加
//    SpringMvc底层将请求参数和入参对象的属性会进行一一绑定；要求:请求参数的名字要和javaBean入参属性名一致;否则SpringMvc匹配不到
    @PostMapping("emp")
    public String addEmp(Employee employee) {
        System.out.println(employee);
//        保存员工
        employeeDao.save(employee);
//        来到员工列表
//        redirect:重定向到一个新地址 /代表当前项目路径
//        forward:转发到一个地址
        return "redirect:emps";
    }

    //    员工修改页面
    @GetMapping("emp/{id}")
    public ModelAndView toEditPage(ModelAndView modelAndView, @PathVariable("id") Integer id) {
        Employee employee = employeeDao.get(id);
        //        动态获取部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        modelAndView.addObject("depts", departments);
        modelAndView.addObject("emp", employee);
        modelAndView.setViewName("emp/addandedit");
        return modelAndView;
    }

    @PutMapping("emp")
    public String EditEmp(Employee employee) {
        System.out.println(employee);
//        调用修改方法此处使用map模拟数据所以只需要重新调用一次save覆盖原来的数据即可
        employeeDao.save(employee);
        return "redirect:emps";
    }

    @DeleteMapping("emp/{id}")
    public String DelEmp(@PathVariable("id") Integer id) {
        System.out.println(id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
