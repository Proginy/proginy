package com.proginy.base.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "USER")
public class User
{

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name", unique = false, nullable = true, length = 60)
    private String firstName;

    @Column(name = "last_name", unique = false, nullable = true, length = 60)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false, length = 60)
    private String email;

    @Size(max = 64)
    @Column(name = "password", nullable = false)
    private String password;

    public User()
    {
    }

    public static class Builder
    {
        private String firstName;
        private String lastName;
        private String email;
        private String password;

        public Builder firstName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName)
        {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email)
        {
            this.email = email;
            return this;
        }

        public Builder password(String password)
        {
            this.password = password;
            return this;
        }

        public User build()
        {
            return new User(this);
        }
    }

    private User(Builder builder)
    {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
    }
}
