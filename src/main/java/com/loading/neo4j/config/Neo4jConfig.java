package com.loading.neo4j.config;


import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories("com.loading.neo4j.repository")
@EnableTransactionManagement
public class Neo4jConfig {
    @Value("${spring.data.neo4j.url}")
    private String url;
    @Value("${spring.data.neo4j.username}")
    private String userName;
    @Value("${spring.data.neo4j.password}")
    private String password;

    @Bean(name = "session")
    public Session neo4jSession() {
        Driver driver = GraphDatabase.driver(url, AuthTokens.basic(userName, password));
        return driver.session();
    }
}