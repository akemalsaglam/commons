package com.aks.commons.redis;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfiguration {

 /*   @Bean
    public JedisConnectionFactory jedisConnectionFactoryForStandAlone(
            @Value("${redis.hostName}") String hostName,
            @Value("${redis.port}") int port,
            @Value("${redis.database}") int database) {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(hostName);
        redisStandaloneConfiguration.setPort(port);
        redisStandaloneConfiguration.setDatabase(database);
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }*/

   /* @Bean
    public JedisConnectionFactory jedisConnectionFactoryForCluster(
            @Value("#{'${my.list.of.strings}'.split(',')}")List<String>,
            @Value("${redis.port}") int port,
            @Value("${redis.database}") int database) {
        final RedisClusterConfiguration redisClusterConfiguration=new RedisClusterConfiguration();
        redisClusterConfiguration.setClusterNodes();
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle();
    }*/

}
