package ru.sber.weather.repository;

import org.springframework.stereotype.Repository;
import ru.sber.weather.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserInfoRepository {
    private static final List<UserInfo> USERS = new ArrayList<>();
    private static int ID = 0;

    static {
        USERS.add(new UserInfo(ID++, "Valera", "mail@mail.ru", "456", "USER"));
        USERS.add(new UserInfo(ID++, "Antoxa", "mail@mail.by", "789", "USER"));
    }

    public void create(UserInfo userInfo) {
        USERS.add(userInfo);
    }

    public Optional<UserInfo> getById(int id) {
        return USERS.stream().filter(x -> x.getId() == id).findFirst();
    }

    public List<UserInfo> fetchAll() {
        return new ArrayList<>(USERS);
    }

}
