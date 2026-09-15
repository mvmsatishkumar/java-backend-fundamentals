package springjdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import springjdbc.dao.Laptop;

import java.util.List;

public class LaptopDao {

    private final JdbcTemplate jdbcTemplate;

    public LaptopDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Laptop> findAll() {

        String sql = "SELECT l_id, brand, ram FROM laptop";

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Laptop.class)
        );
    }

    public Laptop findById(int id) {

        String sql =
                "SELECT l_id, brand, ram FROM laptop WHERE l_id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Laptop.class),
                id
        );
    }

    public int save(Laptop laptop) {

        String sql =
                "INSERT INTO laptop (l_id, brand, ram) VALUES (?, ?, ?)";

        return jdbcTemplate.update(
                sql,
                laptop.getLId(),
                laptop.getBrand(),
                laptop.getRam()
        );
    }

    public int updateRam(int id, int ram) {

        String sql =
                "UPDATE laptop SET ram = ? WHERE l_id = ?";

        return jdbcTemplate.update(sql, ram, id);
    }

    public int delete(int id) {

        String sql =
                "DELETE FROM laptop WHERE l_id = ?";

        return jdbcTemplate.update(sql, id);
    }
}