package br.edu.infnet.GymSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TokenService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public String gerarToken(Long alunoId){

        String token = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(
                token,
                alunoId.toString(),
                5,
                TimeUnit.MINUTES
        );

        return token;
    }

    public boolean validarToken(String token){
        return redisTemplate.hasKey(token);

    }
}