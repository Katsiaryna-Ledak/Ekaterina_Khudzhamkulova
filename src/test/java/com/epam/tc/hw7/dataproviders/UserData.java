package com.epam.tc.hw7.dataproviders;

import com.epam.tc.hw7.entities.User;

public class UserData {

    public static User DEFAULT_USER = new User().set(
        u -> {
            u.userName = "Roman";
            u.password = "Jdi1234";
        });
}
