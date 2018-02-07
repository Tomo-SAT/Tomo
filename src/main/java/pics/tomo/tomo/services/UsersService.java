package pics.tomo.tomo.services;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pics.tomo.tomo.models.User;
import pics.tomo.tomo.services.UserWithRoles;

import java.util.Collections;

@Service("usersSvc")
public class UsersService {

    public boolean isLoggedIn() {
        boolean isAnonymousUser = //starts with an anonymous user...gets authenticated:
                SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken;
        return !isAnonymousUser; // now is not an anonymous user!
    }

    public User loggedInUser() {
        if (!isLoggedIn()) {// if you are an anonymous user...return null.
            return null;
        } // otherwise return a User who has authentication!
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    // Automatically logs in User:
    public void authenticate(User user) {
        // I'm not using roles so I'm using an empty list for the roles
        UserDetails userDetails = new UserWithRoles(user);
        Authentication auth = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(auth);
    }
}