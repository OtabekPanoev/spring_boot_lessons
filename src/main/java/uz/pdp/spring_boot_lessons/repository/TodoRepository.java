package uz.pdp.spring_boot_lessons.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import uz.pdp.spring_boot_lessons.model.Todo;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    final BeanPropertyRowMapper<Todo> rowMapper = BeanPropertyRowMapper.newInstance(Todo.class);

    public Optional<Todo> findById(UUID id) {
        String sql = "SELECT * FROM todo WHERE id = :id";
        var params = new MapSqlParameterSource()
                .addValue("id", id);

        try {
            Todo todo = jdbcTemplate.queryForObject(sql, params, rowMapper);
            return Optional.ofNullable(todo);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }

    }

}
