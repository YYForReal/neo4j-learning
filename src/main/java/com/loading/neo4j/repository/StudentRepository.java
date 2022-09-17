package com.loading.neo4j.repository;

import com.loading.neo4j.entity.StudentNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface StudentRepository extends Neo4jRepository<StudentNode,Long> {
}