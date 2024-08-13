package uz.pdp.spring_boot_lessons;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "Hello World";
    }

    @GetMapping("/admin")
    public String admin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        System.out.println("userDetails.getUsername() = " + userDetails.getUsername());

        return userDetails.getUsername();
    }

    @GetMapping("/manager")
    @PreAuthorize("hasAnyRole('MANAGER')")
    public String manager() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        System.out.println("userDetails.getUsername() = " + userDetails.getUsername());

        return userDetails.getUsername();
    }

    @PutMapping("/admin")
    public String adminPut() {
        return "Hello World";
    }

}
