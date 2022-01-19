package com.authentication.session.controller.model;


import com.authentication.session.controller.constant.MemberStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "member")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @JsonIgnore
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

    @JsonIgnore
    @Column(name = "status", columnDefinition = "int2")
    private MemberStatus status;

    @Column(name = "created_on", updatable = false)
    @CreationTimestamp
    private Date createdOn;

    @Column(name = "updated_on")
    @UpdateTimestamp
    private Date updatedOn;

}
