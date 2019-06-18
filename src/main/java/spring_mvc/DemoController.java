package spring_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author lizhen
 * @CreateAt 2019/6/6 000617:18
 */
@Controller
@RequestMapping
public class DemoController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "testing";
    }
}
