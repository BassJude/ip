package pl.pierzchala.ip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class HomeController {

    private final HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/ip")
    public String getIp(HttpServletRequest request) {
        return homeService.getIp(request);
    }

    @GetMapping("/ip-map")
    public Map<String, String> getHeaders(HttpServletRequest request) {
        return homeService.getHeaders(request);
    }
}
