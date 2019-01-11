package springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springmvc.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@SessionAttributes({"user"})//把请求域里面的user放到session域里面,可以指定键名或者使用类型来确定哪些会存到session
@Controller
@RequestMapping("/a")
public class HelloWorld {
    private final static String SUCCESS = "success";

    /**
     * 1、映射请求
     * 2、返回值会通过视图解析器解析为实际的物理视图，对InternalResourceViewResolver，会做如下解析：
     * prefix+返回值+sufix(后缀)，得到实际的物理视图，然后做转发操作
     *
     * @return
     */
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello world!");
        return "success";
    }

    @RequestMapping(value = "/helloPost", method = RequestMethod.POST)
    public String hellopost() {
        System.out.println("hello world!");
        return "successpost";
    }

    @RequestMapping("/hello/{id}")
    public String helloPathvar(@PathVariable("id") Integer id) {
        System.out.println("hello world!" + id);
        return "success";
    }

    /**
     * 用HiddenHttpMethodFilter来转换请求类型（post转成delete和put）
     * 这样就能实现REST风格的URL
     * 如何发送PUT和Delete请求：
     * 1、在web.xml配置HiddenHttpMethodFilter
     * 2、发送post请求的时候携带一个name="_name",value=put后者delete的隐藏域
     */

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
    public String testRest(@PathVariable("id") Integer id) {
        System.out.println("这是一个get请求");
        return "success";
    }

    @RequestMapping(value = "/testRest", method = RequestMethod.POST)
    public String testRest1() {
        System.out.println("这是一个post请求");
        return "success";
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
    public String testRest2(@PathVariable("id") Integer id) {
        System.out.println("这是一个delete请求");
        return "success";
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
    public String testRest3(@PathVariable("id") Integer id) {
        System.out.println("这是一个put请求");
        return "success";
    }

    /**
     * 由@RequestParam获取请求参数
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(value = "username") String un,
                                   @RequestParam(value = "age") Integer age) {
        System.out.println("testRequestParam" + "用户名：" + un + "年龄：" + age);
        return "success";
    }

    /**
     * POJO类作为参数
     * pringMVC会根据请求参数名和POJO类的属性自动匹配，支持级联
     */
    @RequestMapping("/testPojo")
    public String testPojo(User user) {
        System.out.println("test POJO" + user);
        return "success";
    }

    /**
     * 可以接受Servlet原生的API的参数
     */
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("testServletAPI" + request + "\n" + response);
        return "success";
    }

    /**
     * springmvc传模型数据有4种方法
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView test() {
        String viewname = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewname);
        //添加模型数据到modelAndView中
        modelAndView.addObject("time", new Date());
        return modelAndView;
    }

    @RequestMapping("/testMap")
    public String test1(Map<String, Object> map) {
        map.put("names", Arrays.asList("Tom", "Jerry"));
        return SUCCESS;
    }

    @RequestMapping("/testSessionAtribute")
    public String test2(Map<String, Object> map) {
        User user = new User("Tom", "123456", "123@qq.com", 13);
        map.put("user", user);
        System.out.println("haha");
        return SUCCESS;
    }
}
