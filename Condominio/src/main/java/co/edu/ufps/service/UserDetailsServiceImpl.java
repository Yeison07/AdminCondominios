package co.edu.ufps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.edu.ufps.model.Authority;
import co.edu.ufps.model.Miembro;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private MiembroService miembroService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Miembro miembro= miembroService.findByCorreo(username).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
	    
	    List grantList = new ArrayList();
	    for (Authority authority: miembro.getAuthority()) {
	        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
	            grantList.add(grantedAuthority);
	    }
			
	    UserDetails user = (UserDetails) new User(miembro.getUser(), miembro.getPassword(), grantList);
	         return user;
	}

}
