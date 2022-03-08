package ru.job4j.forum.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;

@Controller
public class LoginControl {

    private final PostService service;

    public LoginControl(PostService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String loginPage(@ModelAttribute User user) {
        User userSearch = service.findByName(user.getUsername());
        if (userSearch == null) {
            return "login";
        }
        return "index";
    }
}
