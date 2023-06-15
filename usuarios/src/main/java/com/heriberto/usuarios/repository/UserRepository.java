package com.heriberto.usuarios.repository;

import com.heriberto.usuarios.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="users")
public interface UserRepository extends CrudRepository<User, Long> {

    public User findByUsername(String username);

    @Query("select u from User u where u.username=?1")
    public User getByUsername(String username);

}
