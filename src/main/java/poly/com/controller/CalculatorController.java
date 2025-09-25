package poly.com.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ca")
public class CalculatorController {

    @Autowired
    HttpServletRequest request; // để lấy dữ liệu từ form

    // Hiển thị form
    @RequestMapping("/form")
    public String form() {
        // nằm trong /templates/poly/calculator.html
        return "poly/calculator";
    }

    // Xử lý tính toán
    @RequestMapping("/compute")
    public String compute(Model model) {
        String w = request.getParameter("width");
        String h = request.getParameter("height");

        if (w != null && h != null && !w.isEmpty() && !h.isEmpty()) {
            double width = Double.parseDouble(w);
            double height = Double.parseDouble(h);

            double area = width * height;
            double perimeter = 2 * (width + height);

            model.addAttribute("width", width);
            model.addAttribute("height", height);
            model.addAttribute("area", area);
            model.addAttribute("perimeter", perimeter);
        } else {
            model.addAttribute("message", "Vui lòng nhập đầy đủ chiều rộng và chiều dài!");
        }

        // trả về file /templates/poly/calculator.html
        return "poly/calculator";
    }
}
