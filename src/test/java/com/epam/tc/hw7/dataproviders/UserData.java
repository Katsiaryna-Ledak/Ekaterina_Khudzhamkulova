package com.epam.tc.hw7.dataproviders;

import com.epam.tc.hw7.entities.User;

public class UserData {

    public static User DEFAULT_USER = new User().set(
        u -> {
            u.name = "Roman";
            u.fullName = "ROMAN IOVLEV";
            u.password = "Jdi1234";
        });
}
