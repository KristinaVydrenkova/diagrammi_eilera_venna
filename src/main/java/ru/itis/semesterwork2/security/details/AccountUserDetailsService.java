package ru.itis.semesterwork2.security.details;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.semesterwork2.repositories.UsersRepository;

@RequiredArgsConstructor
@Service
public class AccountUserDetailsService implements UserDetailsService {
    private final UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new AccountUserDetails(
                usersRepository.findByEmail(email)
                        .orElseThrow(
                                () -> new UsernameNotFoundException("User not found")));

    }
}
