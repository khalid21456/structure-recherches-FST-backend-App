package com.PFE.StructureRechercheFST.RestAPIs;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@SuppressWarnings("unused")
@RestController
@RequestMapping("/images")
@CrossOrigin
public class FileUploadController {

    // Directories where uploaded files will be stored
    private static final String UPLOAD_DIR_THEME = "src/main/resources/uploads/Themes/";
    private static final String UPLOAD_DIR_EVENT = "src/main/resources/uploads/Evenements/";
    private static final String UPLOAD_DIR_PROFILES = "src/main/resources/uploads/Profiles/";
    private static final String UPLOAD_DIR_PUBLICATIONS = "src/main/resources/uploads/Publications/";

    @PostMapping("/uploads/Theme")
    public String uploadThemeImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Please select a file to upload";
        }
        try {
            // Get the file and save it to the uploads directory
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR_THEME + file.getOriginalFilename());
            Files.write(path, bytes);
            return file.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file";
        }
    }

    @PostMapping("/uploads/Event")
    public String uploadEventImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Please select a file to upload";
        }
        try {
            // Get the file and save it to the uploads directory
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR_EVENT + file.getOriginalFilename());
            Files.write(path, bytes);
            return file.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file";
        }
    }

    @PostMapping("/uploads/Profile")
    public String uploadProfileImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Please select a file to upload";
        }
        try {
            // Get the file and save it to the uploads directory
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR_PROFILES + file.getOriginalFilename());
            Files.write(path, bytes);
            return file.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file";
        }
    }

    @PostMapping("/uploads/Publication")
    public String uploadPublicationImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Please select a file to upload";
        }
        try {
            // Get the file and save it to the uploads directory
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR_PUBLICATIONS + file.getOriginalFilename());
            Files.write(path, bytes);
            return file.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file";
        }
    }

}