package com.alberto.tupequenabiblioteca.seguridad;

import com.alberto.tupequenabiblioteca.entidades.Usuarios;
import com.alberto.tupequenabiblioteca.repositorios.UsuariosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuariosRepository repositorio;

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        Usuarios usuario = repositorio.findFirstByUsername(nombre);

        User.UserBuilder builder = null;

        if (usuario != null) {
            builder = User.withUsername(nombre);
            builder.disabled(false);
            builder.password(usuario.getPassword());
            builder.authorities(new SimpleGrantedAuthority(usuario.getRole()));
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return builder.build();
    }

}
