package poly.com.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("poly/login")
public class AuthController {

    @Autowired
    HttpServletRequest request;

    @RequestMapping("/form")
    public String form() {
        return "poly/login"; // trả về login.html trong /templates
    }

    @RequestMapping("/check")
    public String login(Model model) {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        if ("poly".equals(user) && "123".equals(pass)) {
            model.addAttribute("message", "Đăng nhập thành công!");
        } else {
            model.addAttribute("message", "Sai username hoặc password!");
        }
        return "poly/login";
    }
}
