package cn.y.java.jul;

import java.util.logging.Logger;

public class UserService {

    private static final Logger log = Logger.getLogger(UserService.class.getName());

    public void addUser(){
        // 添加逻辑
        log.info("add user");
    }

    public void deleteUser(){
        try {
            // 删除逻辑
            log.severe("delete user succeed!");
        }catch (Exception e){
            log.severe("delete user error");
        }
    }
}
