package com.bootcamp.quizapp.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Setter
@Getter
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name="Users")
public class User implements UserDetails {

    @Id
    //changed from IDENTITY TO AUTO
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="username")
    private String username;
    @Column(name = "email")
    private String email;
//    @Column(name = "role")
//    private String role;
    @Column(name = "password")
    private String password;
    @Column(name = "avatar")
    private String avatar;
    @OneToMany(targetEntity = Statistic.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_FK", referencedColumnName = "id")
    private List<Statistic> statisticList;

    public User (String username, String email, String password, String avatar){
        this.username=username;
        this.email=email;
        this.password=password;
        this.avatar=avatar;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getEmail() {
        return email;

    }

    public void setPassword(String password) {
        this.password = password;
    }
}
