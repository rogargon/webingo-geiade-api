package cat.udl.eps.entsoftarch.webingogeiadeapi.domain;

import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Card {
    @Id
    private int id;
    private int [][] nums;
    private int price;
}
