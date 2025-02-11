package com.casestudy1.webapp.security;

import com.casestudy1.webapp.database.entity.UserRole;
import com.casestudy1.webapp.database.entity.Users;
import com.casestudy1.webapp.services.UserRoleService;
import com.casestudy1.webapp.services.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UserRoleService userRoleService;

    // incoming to this method is the username that the person typed into the login form
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // first we load the user from the database
        Users user = usersService.geUsersByEmail(username);

        // if the user was not found then we get out of here immediately because it's a bad login
        if (user == null) {
            // this is not good practice to log off usernames
            throw new UsernameNotFoundException("Username '" + username + "' not found in database");
        }

        // spring security configs for account management
        boolean accountIsEnabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        // load the user roles from our database
        List<UserRole> userRoles = userRoleService.findAllUser();

        // convert our user roles into spring granted authorities
        List<GrantedAuthority> springRoles = buildGrantAuthorities(userRoles);

        // the person logged into the application is called the principal
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                accountIsEnabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                springRoles);
    }

    public List<GrantedAuthority> buildGrantAuthorities(List<UserRole> userRoles) {
        // first we create an empty list of spring granted authorities
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        // loop over our user roles from the database
        for (UserRole role : userRoles) {
            // create a new simple granted authority for each user role in the databse
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRolename());
            authorities.add(authority);
        }

        return authorities;
    }
}
