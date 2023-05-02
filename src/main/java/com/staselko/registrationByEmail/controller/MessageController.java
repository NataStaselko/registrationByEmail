package com.staselko.registrationByEmail.controller;

import com.staselko.registrationByEmail.utils.ContentResponse;
import com.staselko.registrationByEmail.utils.UserProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/content")
@RequiredArgsConstructor
public class MessageController {

    private final UserProvider userProvider;

    @GetMapping
    public ResponseEntity<ContentResponse> getMessage(){
        ContentResponse content = new ContentResponse();
        content.setMessage(userProvider.getCurrentUser().getLogin());
        return ResponseEntity.ok(content);
    }
}
