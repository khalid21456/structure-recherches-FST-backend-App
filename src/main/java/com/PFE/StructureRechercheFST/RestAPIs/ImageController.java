package com.PFE.StructureRechercheFST.RestAPIs;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Component
@RestController
@SuppressWarnings("unused")
@CrossOrigin
@RequestMapping("/readImages")
public class ImageController {

    @GetMapping("/Theme/{imageName}")
    public ResponseEntity<Resource> getThemeImage(@PathVariable String imageName) throws IOException {
        Resource resource;
        resource = new ClassPathResource("uploads/Themes/"+imageName);
        MediaType contentType;
        if (imageName.toLowerCase().endsWith(".png")) {
            contentType = MediaType.IMAGE_PNG;
        } else if (imageName.toLowerCase().endsWith(".jpg") || imageName.toLowerCase().endsWith(".jpeg")) {
            contentType = MediaType.IMAGE_JPEG;
        } else {
            contentType = MediaType.IMAGE_JPEG;
        }
        return ResponseEntity.ok()
                .contentType(contentType)
                .body(resource);

    }

    @GetMapping("/Profile/{imageName}")
    public ResponseEntity<Resource> getProfileImage(@PathVariable String imageName) throws IOException {
        Resource resource;
        resource = new ClassPathResource("uploads/Profiles/"+imageName);
        MediaType contentType;
        if (imageName.toLowerCase().endsWith(".png")) {
            contentType = MediaType.IMAGE_PNG;
        } else if (imageName.toLowerCase().endsWith(".jpg") || imageName.toLowerCase().endsWith(".jpeg")) {
            contentType = MediaType.IMAGE_JPEG;
        } else {
            contentType = MediaType.IMAGE_JPEG;
        }
        return ResponseEntity.ok()
                .contentType(contentType)
                .body(resource);

    }

    @GetMapping("/Publication/{imageName}")
    public ResponseEntity<Resource> getPublicationImage(@PathVariable String imageName) throws IOException {
        Resource resource;
        resource = new ClassPathResource("uploads/Publications/"+imageName);
        MediaType contentType;
        if (imageName.toLowerCase().endsWith(".png")) {
            contentType = MediaType.IMAGE_PNG;
        } else if (imageName.toLowerCase().endsWith(".jpg") || imageName.toLowerCase().endsWith(".jpeg")) {
            contentType = MediaType.IMAGE_JPEG;
        } else {
            contentType = MediaType.IMAGE_JPEG;
        }
        return ResponseEntity.ok()
                .contentType(contentType)
                .body(resource);

    }
}
