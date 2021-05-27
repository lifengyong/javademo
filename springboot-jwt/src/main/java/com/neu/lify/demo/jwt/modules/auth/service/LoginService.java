package com.neu.lify.demo.jwt.modules.auth.service;

import java.util.Map;

public interface LoginService {

    Map<String, Object> login(String username, String password);
}
