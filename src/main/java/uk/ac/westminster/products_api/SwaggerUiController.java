package uk.ac.westminster.products_api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SwaggerUiController {

    @GetMapping("/swagger-ui.htm")
    public RedirectView swaggerUi() {
        return new RedirectView("/swagger-ui/index.html", true);
    }
}
