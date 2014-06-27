package com.proginy.base.service;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.proginy.base.domain.User;
import com.proginy.base.repository.UserRepository;
import com.proginy.base.service.exception.UserAlreadyExistsException;

@Service
@Validated
public class UserServiceImpl implements UserService
{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    @Inject
    public UserServiceImpl(final UserRepository repository)
    {
        this.userRepository = repository;
    }

    @Override
    @Transactional
    public User save(@NotNull @Valid final User user)
    {
        LOGGER.debug("Creating {}", user);
        User existing = userRepository.findOne(user.getId());
        if (existing != null)
        {
            throw new UserAlreadyExistsException(
                    String.format("There already exists a user with id=%s", user.getId()));
        }
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getList()
    {
        LOGGER.debug("Retrieving the list of all users");
        return userRepository.findAll();
    }

}
