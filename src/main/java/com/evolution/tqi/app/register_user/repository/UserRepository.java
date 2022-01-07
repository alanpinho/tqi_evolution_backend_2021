package com.evolution.tqi.app.register_user.repository;

import com.evolution.tqi.app.register_user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    List<UserModel> findByCpf(String cpf);
    List<UserModel> findByEmail(String email);
}
