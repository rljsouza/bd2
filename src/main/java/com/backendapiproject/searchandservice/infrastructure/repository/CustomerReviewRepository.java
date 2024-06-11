package com.backendapiproject.searchandservice.infrastructure.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
@RequiredArgsConstructor
public class CustomerReviewRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void deleteCustomerById(Integer customerId) {
        String sql = "DELETE FROM tb_customer WHERE id = ?";
        jdbcTemplate.update(sql, customerId);
    }
}
