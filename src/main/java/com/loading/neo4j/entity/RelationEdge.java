package com.loading.neo4j.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "RelationEdge")
@Setter
@Getter
public class RelationEdge {
    @Id
    @GeneratedValue
    private Long id;

    // 关系名
    private String name;

    @StartNode
    private GroupNode groupNode;

    @EndNode
    private StudentNode studentNode;

    public RelationEdge(GroupNode parentNode, StudentNode sonNode, String name) {
        this.groupNode = parentNode;
        this.studentNode = sonNode;
        this.name = name;
    }
}
