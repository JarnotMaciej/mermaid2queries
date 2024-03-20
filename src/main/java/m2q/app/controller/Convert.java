package m2q.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Convert {

    @PostMapping("/convert")
    public String convert(@RequestParam("input") String input, Model model) {
        m2q.app.model.Model converter = new m2q.app.model.Model(input);
        converter.cleanUp();
        converter.createTables();
        converter.toSQL();
        String output = converter.getQueries();

        model.addAttribute("sourceCode", output);
        return "convert";
    }
}
