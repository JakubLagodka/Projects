package pl.polsl.hotelapplication.hotel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Informations {
    @RequestMapping("/informations")
    @ResponseBody
    public String implicitTransfer(HttpServletRequest request){
  String browserName = request.getHeader("User-Agent");
  String ipAddress = request.getRemoteAddr();
  return "Browser name: " + browserName + System.lineSeparator() + "IP adress: " +ipAddress;
    }
}
