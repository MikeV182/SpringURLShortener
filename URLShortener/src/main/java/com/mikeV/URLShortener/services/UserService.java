package com.mikeV.URLShortener.services;

import com.mikeV.URLShortener.model.UserInput;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<UserInput> urls = new ArrayList<>();
    private Long ID = 0L;

    {
        urls.add(new UserInput(ID++, "https://www.google.com/", ""));
        urls.add(new UserInput(ID++, "https://www.youtube.com/", ""));
    }

    public List<UserInput> listUsers() {
        return urls;
    }

    public void addURL(UserInput newURL) {
        newURL.setId(ID++);
        urls.add(newURL);
    }

    public void deleteURL(Long id) {
        urls.removeIf(url -> url.getId().equals(id));
    }

}
