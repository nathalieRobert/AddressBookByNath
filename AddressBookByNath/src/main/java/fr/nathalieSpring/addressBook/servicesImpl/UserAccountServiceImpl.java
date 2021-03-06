package fr.nathalieSpring.addressBook.servicesImpl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.nathalieSpring.addressBook.dtos.UserAccountCreateDto;
import fr.nathalieSpring.addressBook.entities.UserAccount;
import fr.nathalieSpring.addressBook.repository.UserAccountRepository;
import fr.nathalieSpring.addressBook.services.UserAccountService;

@Service
public class UserAccountServiceImpl
	implements UserAccountService, UserDetailsService {

    private final UserAccountRepository repo;

    private final PasswordEncoder encoder;

    public UserAccountServiceImpl(UserAccountRepository repo,
	    PasswordEncoder encoder) {
	super();
	this.repo = repo;
	this.encoder = encoder;
    }

    @Override
    public void create(UserAccountCreateDto dto) {
	UserAccount account = new UserAccount();
	account.setUsername(dto.getUsername());
	String password = dto.getPassword();
	String encodedPassword = encoder.encode(password);
	account.setPassword(encodedPassword);
	account.setRole(dto.getRole());
	account.setAccountNonExpired(dto.isAccountNonExpired());
	account.setAccountNonLocked(dto.isAccountNonLocked());
	account.setCredentialsNonExpired(dto.isCredentialsNonExpired());
	account.setEnabled(dto.isEnabled());
	repo.save(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username)
	    throws UsernameNotFoundException {
	UserAccount account = repo.findByUsername(username);
	if (account == null) {
	    throw new UsernameNotFoundException(username);
	}
	UserBuilder builder = User.builder();
	builder.password(account.getPassword());
	builder.username(account.getUsername());
	builder.accountExpired(!account.isAccountNonExpired());
	builder.accountLocked(!account.isAccountNonLocked());
	builder.disabled(!account.isEnabled());
	builder.credentialsExpired(!account.isCredentialsNonExpired());
	// Role
	builder.authorities(account.getRole().name());
	return builder.build();
    }

    @Override
    public void deleteById(Long id) {
	repo.deleteById(id);
    }
    
}