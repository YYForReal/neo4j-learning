package com.loading.neo4j.repository;


import com.loading.neo4j.entity.GroupNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface GroupRepository extends Neo4jRepository<GroupNode,Long> {
}
