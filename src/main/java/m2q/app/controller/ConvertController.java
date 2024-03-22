package m2q.app.controller;

import m2q.app.services.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @Autowired
    private ConvertService cs;


    @PostMapping("/convert")
    public String convert(@RequestParam("input") String input, Model model) {
        model.addAttribute("sourceCode", cs.myService(input));
        return "convert";
    }
}
