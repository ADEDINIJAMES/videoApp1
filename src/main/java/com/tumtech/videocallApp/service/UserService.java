package com.tumtech.videocallApp.service;

import com.tumtech.videocallApp.users.Users;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserService {
    private static final List<Users> USERS_LIST = new ArrayList<>();

    public  void register (Users users){
        users.setStatus("online");
        USERS_LIST.add(users);
    }

    public Users login (Users users){
        var userIndex= IntStream.range(0,USERS_LIST.size())
                .filter(i->USERS_LIST.get(i).getEmail().equals(users.getEmail()))
                .findAny()
                .orElseThrow(()-> new RuntimeException("User not found"));
        var cUser = USERS_LIST.get(userIndex);
        if (!cUser.getPassword().equals(users.getPassword())){
            throw  new RuntimeException("Password not found");
        }
        cUser.setStatus("online");
        return cUser;
    }

    public void logout (String email){
        var userIndex= IntStream.range(0,USERS_LIST.size())
                .filter(i->USERS_LIST.get(i).getEmail().equals(email))
                .findAny()
                .orElseThrow(()-> new RuntimeException("User not found"));
        USERS_LIST.get(userIndex).setStatus("offline");
    }

    public List<Users> findAll(){
        return USERS_LIST;
    }
}
