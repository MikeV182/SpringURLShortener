package com.mikeV.URLShortener.services;

import com.mikeV.URLShortener.model.UserInput;
import com.mikeV.URLShortener.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final ClientRepository clientRepository;

    public void add(UserInput newUrl) {
        log.info("Added new URL");
        clientRepository.save(newUrl);
    }

    public void update(UserInput savedUrl) {
        UserInput input = clientRepository.findById(savedUrl.getId()).orElse(null);
        if (input != null) {
            log.info("Updated existing URL {}", input);
            input.setShortURL(savedUrl.getShortURL());
            input.setOriginURL(savedUrl.getOriginURL());
        } else {
            input = new UserInput();
            input.setOriginURL(savedUrl.getOriginURL());
            input.setShortURL(savedUrl.getShortURL());
            log.info("Created new URL {}", input);
        }
        clientRepository.save(input);
    }

    public UserInput getUserInputById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
}
