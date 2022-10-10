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
@Table(name = "t_article")
public class TArticle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private Date date_publication;

    @ManyToOne
    @JoinColumn(name = "fk_user")
    private TUser fk_user;

    @ManyToOne
    @JoinColumn(name="fk_category")
    private TCategory fk_category;

}
