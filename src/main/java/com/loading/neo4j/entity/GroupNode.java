package com.loading.neo4j.entity;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;
@NodeEntity("group")
@Data
public class GroupNode {
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 班级名称
     */
    @Property(name = "name")
    private String name;

    /**
     * 编号
     */
    private String num;

    @Relationship(type = "RelationEdge")
    private Set<RelationEdge> sets = new HashSet<>();

    public void addRelation(StudentNode sonNode, String name) {
        try{
            RelationEdge relationNode = new RelationEdge(this, sonNode, name);
            sets.add(relationNode);
            sonNode.getSets().add(relationNode);
        }catch (Exception e){
            System.out.println("Error:" + e);
        }

    }
}
