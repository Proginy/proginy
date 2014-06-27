package com.proginy.base.service;

import java.util.List;

import com.proginy.base.domain.User;

public interface UserService
{
    User save(User user);

    List<User> getList();
}
