package com.heriberto.oauth.serviciooatuh.services;


import com.heriberto.usuariocommons.entity.User;

public interface IUserService {

    public User findByUsername(String username);

}