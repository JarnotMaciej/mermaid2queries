package m2q.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class Index {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
