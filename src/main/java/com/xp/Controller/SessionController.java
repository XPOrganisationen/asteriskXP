package com.xp.Controller;

import com.xp.Service.EmployeeServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SessionController {
    private final EmployeeServiceImpl adminServiceImpl;

    public SessionController(EmployeeServiceImpl adminServiceImpl) {
        this.adminServiceImpl = adminServiceImpl;
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login_page";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        HttpSession session,
                        Model model) {

        if (adminServiceImpl.login(username, password)) {
            session.setAttribute("username", username);

            model.addAttribute("admin", adminServiceImpl.findEmployeeByUsername(username));
            model.addAttribute("username", username);

            return "admin-page";
        }

        model.addAttribute("wrongCredentials", true);
        return "login_page";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login_page";
    }
}
