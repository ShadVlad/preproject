package utils;

import model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Util {
    public static boolean idIsNumber(HttpServletRequest request) {
        final String id = request.getParameter("id");
        return id != null &&
                (id.length() > 0) &&
                id.matches("[+]?\\d+");
    }

    public static boolean requestIsValid(HttpServletRequest request) {
        final String name = request.getParameter("name");
        final String age = request.getParameter("age");
        final String surName = request.getParameter("surname");
        final String email = request.getParameter("email");

        return name != null && name.length() > 0 &&
                surName != null && surName.length() > 0
                && age != null && age.length() > 0 &&
                email != null && email.length() > 0 &&
                age.matches("[+]?\\d+")
                ;
    }

}
