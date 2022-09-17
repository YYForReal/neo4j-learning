package com.loading.neo4j.controller;

import com.loading.neo4j.entity.*;
import com.loading.neo4j.repository.GroupRepository;
import com.loading.neo4j.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/node")
@Slf4j
public class GroupController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GroupRepository groupRepository;

    @GetMapping(value = "/create")
    public String createNodeRelation() {
        StudentNode studentNode1 = new StudentNode();
        studentNode1.setName("Alen");
        studentNode1.setSex("男");
        StudentNode studentNode2 = new StudentNode();
        studentNode2.setName("Kai");
        studentNode2.setSex("女");
        studentRepository.save(studentNode1);
        studentRepository.save(studentNode2);

        GroupNode groupNode = new GroupNode();
        groupNode.setName("火箭班");
        groupNode.setNum("298");
        // 增加关系
        groupNode.addRelation(studentNode1, "includes");
        groupNode.addRelation(studentNode2, "includes");
        groupRepository.save(groupNode);

        return "节点增加成功";
    }
}

