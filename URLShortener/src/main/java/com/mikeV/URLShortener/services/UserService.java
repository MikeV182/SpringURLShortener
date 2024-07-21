package com.mikeV.URLShortener.services;

import com.mikeV.URLShortener.model.UserInput;
import com.mikeV.URLShortener.repositories.ClientRepository;
import com.mikeV.URLShortener.repositories.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements Constants {
    private final ClientRepository clientRepository;

    public void add(UserInput newUrl) {
        log.info("Added new URL");
        newUrl.setUsersUsed(0L);
        clientRepository.save(newUrl);
    }

    public void update(UserInput savedUrl) {
        UserInput input = clientRepository.findById(savedUrl.getId()).orElse(null);
        if (input != null) {
            log.info("Updated existing URL {}", input);
            input.setShortURL(savedUrl.getShortURL());
            input.setOriginURL(savedUrl.getOriginURL());
            input.setUsersUsed(savedUrl.getUsersUsed());
        } else {
            input = new UserInput();
            input.setOriginURL(savedUrl.getOriginURL());
            input.setShortURL(savedUrl.getShortURL());
            input.setUsersUsed(savedUrl.getUsersUsed());
            log.info("Created new URL {}", input);
        }
        clientRepository.save(input);
    }

    public UserInput getUserByToken(String token) {
        return clientRepository.findByShortURL(DOMAIN_NAME+token);
    }

    public UserInput getUserInputById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public void increaseUsersUsed(UserInput input) {
        input.setUsersUsed(input.getUsersUsed() + 1);
    }
}
