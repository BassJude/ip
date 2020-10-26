package pl.pierzchala.ip;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Service
public class HomeService {

    private Logger LOGGER = LoggerFactory.getLogger("Logger");


    public String getIp(HttpServletRequest request) {
        String ip = "";

        if (request != null) {
            ip = request.getHeader("X-FORWARDED-FOR");
            if (ip == null || "".equals(ip)) {
                ip = request.getRemoteAddr();
            }
        }
        LOGGER.info(ip);
        return ip;
    }

    public Map<String, String> getHeaders(HttpServletRequest request) {
        Map<String, String> result = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            result.put(key, value);
        }
        LOGGER.info(toJson(result));
        return result;
    }

    private String toJson(Map<String, String> map) {
        return new Gson().toJson(map);
    }
}
