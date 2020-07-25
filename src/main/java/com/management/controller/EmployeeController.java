package com.management.controller;

import com.management.config.MyException;
import com.management.config.MyExceptionHandler;
import com.management.model.Employee;
import com.management.model.Result;
import com.management.model.StatusCode;
import com.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Contended;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 查询所有员工
     * @return
     */
    @GetMapping("/Employees")
    @ResponseBody
    public Result findAll(){
        System.out.println("controller");
        List<Employee> employees =employeeService.findAll();
        for (int i=0;i<employees.size();i++){
            Employee employee = employees.get(i);
            if (employee.getGender().equals("男")){
                employee.setGender("1");
            }else {
                employee.setGender("2");
            }
        }
        if (employees!=null){
            Result result = new Result(true,StatusCode.OK,"查询成功",employees);
            return  result;
        }else {
            Result result = new Result(false,StatusCode.ERROR,"查询失败",employees);
            return  result;
        }
        }

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    @GetMapping("/Employee/{id}")
    @ResponseBody
     public Result findById(@PathVariable("id") Integer id){
        Employee employee =employeeService.findById(id);

        if (employee.getGender().equals("男")){
            employee.setGender("1");
        }else {
            employee.setGender("2");
        }

        if (employee!=null){
            Result result = new Result(true,StatusCode.OK,"查询成功",employee);
            return  result;
        }else {
            Result result = new Result(false,StatusCode.ERROR,"查询失败",employee);
            return  result;
        }

    }

    /**
     * 新增员工成功
     * @param employee
     * @return
     */
    @PostMapping("/Employee")
    public String Employee(@Valid Employee employee, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            System.out.println("客户端的请求数据异常，所有的异常如下：");
            // 取出所有的异常对象
            HashMap<String, String> fieldErrorStringHashMap = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                // 打印异常的字段以及异常信息
                System.out.println(fieldError.getField() + " : " + fieldError.getDefaultMessage());
                fieldErrorStringHashMap.put(fieldError.getField(),fieldError.getDefaultMessage());
            }

           model.addAttribute("employee",fieldErrorStringHashMap);
            return  "/add";
        }
        if (employee.getGender().equals("1")){
            employee.setGender("男");
        }else{
            employee.setGender("女");
        }
           Integer start= employeeService.addEmployee(employee);
        if (start!=0){
            return "/index";
        }return "/add";
        }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @DeleteMapping("/Employee/{id}")
    @ResponseBody
    public Result  deleteEmployee(@PathVariable("id")Integer id){
            Integer start= employeeService.deleteEmployee(id);
            if (start!=0){
                Result result = new Result(true,StatusCode.OK,"删除成功");
                return  result;
            }else {
                Result result = new Result(false, StatusCode.ERROR,"删除失败");
                return  result;
            }

        }

    /**
     * 修改员工
     * @param employee
     * @return
     */
    @RequestMapping("/Employeesss")

    public String updateEmployee(@Valid Employee employee, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            System.out.println("客户端的请求数据异常，所有的异常如下：");
            // 取出所有的异常对象
            HashMap<String, String> fieldErrorStringHashMap = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                // 打印异常的字段以及异常信息
                System.out.println(fieldError.getField() + " : " + fieldError.getDefaultMessage());
                fieldErrorStringHashMap.put(fieldError.getField(),fieldError.getDefaultMessage());
            }

            model.addAttribute("employee",fieldErrorStringHashMap);
            return  "/update";
        }
        if (employee.getGender().equals("1")){
            employee.setGender("男");
        }else{
            employee.setGender("女");
        }
            Integer start =employeeService.updateEmployee(employee);

        if (start!=0){
            return "/index";
        }
        return "/update";
        }

}
