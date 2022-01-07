package academy.nestorkammer.microservices.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationUser implements  AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull(message="The field 'username' must not be empty.")
    @Column(nullable = false)
    private String username;

    @NotNull(message="The field 'password' must not be empty.")
    @Column(nullable = false)
    @ToString.Exclude
    private String password;

    @NotNull(message="The field 'role' must not be empty.")
    @Column(nullable = false)
    @Builder.Default
    private String role = "USER";

    @NotNull(message="The field 'enabled' must not be empty.")
    @Column(nullable = false)
    private boolean enabled;

    public ApplicationUser(@NotNull ApplicationUser applicationUser) {
        this.id = applicationUser.getId();
        this.username = applicationUser.getUsername();
        this.password = applicationUser.getPassword();
        this.role = applicationUser.getRole();
        if (applicationUser.isEnabled()) this.enabled = true;
        else this.enabled = false;
    }

}
