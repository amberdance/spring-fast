package ru.hard2code.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.hard2code.model.Purchase;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class PurchaseRepositoryImpl
        implements PurchaseRepository {

    private final JdbcTemplate jdbcTemplate;


    @Override
    public void storePurchase(Purchase purchase) {
        var sql = "INSERT INTO purchase ( product, price ) VALUES (?, ?)";
        jdbcTemplate.update(sql, purchase.getProduct(),
                purchase.getPrice());
    }

    @Override
    public List<Purchase> findAll() {
        var sql = "select * from purchase";

        RowMapper<Purchase> rowMapper = (rs, i) -> {
            var purchase = new Purchase();
            purchase.setId(rs.getLong("id"));
            purchase.setProduct(rs.getString("product"));
            purchase.setPrice(rs.getBigDecimal("price"));

            return purchase;
        };

        return jdbcTemplate.query(sql, rowMapper);
    }


}
