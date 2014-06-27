package com.proginy.base.util;

import java.util.ArrayList;
import java.util.List;

import com.proginy.base.domain.User;

public class UserUtil
{

    private static final String FIRST_NAME = "Joe";
    private static final String LAST_NAME = "Smith";
    private static final String EMAIL = "joe@smith.com";
    private static final String PASSWORD = "password2352";

    private UserUtil()
    {
    }

    public static User createUser()
    {
        return new User.Builder().firstName(FIRST_NAME).lastName(LAST_NAME).email(EMAIL).password(PASSWORD).build();
    }

    public static List<User> createUserList(int howMany)
    {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < howMany; i++)
        {
            userList.add(createUser());
        }
        return userList;
    }
}
