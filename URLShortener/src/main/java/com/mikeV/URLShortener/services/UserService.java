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
        urls.add(new UserInput(ID++, "https://www.google.com/", "http://shrtRL/tst1"));
        urls.add(new UserInput(ID++, "https://www.youtube.com/", "http://shrtRL/tst2"));
    }

    public List<UserInput> listUrls() {
        return urls;
    }

    public UserInput getUserInputById(Long id) {
        for (UserInput url : urls) {
            if (url.getId().equals(id)) return url;
        }
        return null;
    }

    public void addURL(UserInput newURL) {
        newURL.setId(ID++);
        urls.add(newURL);
    }

    public void deleteURL(Long id) {
        urls.removeIf(url -> url.getId().equals(id));
    }
}
