package com.blog.api.restfull.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "t_user")
public class TUser  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String firstname;
    private String lastname;
    private Date inscription;
    private Date age;

    @ManyToOne
    @JoinColumn(name = "fk_pays")
    private TPays fk_pays;

}
