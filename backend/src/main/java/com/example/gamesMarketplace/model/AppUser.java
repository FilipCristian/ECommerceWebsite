
package com.example.gamesMarketplace.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Builder
public class AppUser{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String appUserRole = "USER";
    private Boolean locked = false;
    private Boolean enabled = false;

    public AppUser(Long userId, String userName, String firstName, String lastName, String email, String password, String appUserRole, Boolean locked, Boolean enabled) {
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
        this.locked = locked;
        this.enabled = enabled;
    }
}
