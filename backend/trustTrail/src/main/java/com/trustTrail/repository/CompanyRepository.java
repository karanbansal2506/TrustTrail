package com.trustTrail.repository;

import com.falkordb.Driver;
import com.falkordb.Graph;
import com.falkordb.ResultSet;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CompanyRepository {

    private final Driver driver;

    public CompanyRepository(Driver driver) {
        this.driver = driver;
    }

    public ResultSet createCompany(
            String graphName,
            String id,
            String name,
            String title) {

        Graph graph = driver.graph(graphName);

        String query = """
        CREATE (c:Company {
            id: $id,
            name: $name,
            title: $title
        })
        RETURN c.id AS id, c.name AS name, c.title AS title
        """;

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("name", name);
        params.put("title", title);

        return graph.query(query, params);
    }
}

