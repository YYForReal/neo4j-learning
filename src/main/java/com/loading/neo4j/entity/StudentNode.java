package com.loading.neo4j.entity;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * 有点类似于Mysql中的table 映射的对象类，mysql中叫做ORM，neo4j中叫做OGM [object graph mapping]
 */
@NodeEntity("student")
@Data
public class StudentNode {
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 学生名称
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    @Relationship(type = "RelationEdge", direction = "INCOMING")
    private Set<RelationEdge> sets = new HashSet<>();

}
