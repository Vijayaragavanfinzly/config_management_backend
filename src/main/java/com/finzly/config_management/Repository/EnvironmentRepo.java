package com.finzly.config_management.Repository;

import com.finzly.config_management.model.Environment;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvironmentRepo extends JpaRepository<Environment,String> {
}
