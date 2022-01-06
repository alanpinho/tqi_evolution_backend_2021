package com.evolution.tqi.app.loan_application.repository;


import com.evolution.tqi.app.loan_application.model.LoanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<LoanModel, Long> {
}
