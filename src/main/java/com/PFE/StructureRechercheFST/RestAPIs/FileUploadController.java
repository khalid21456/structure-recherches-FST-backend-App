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

    // Directory where uploaded files will be stored
    private static final String UPLOAD_DIR = "src/main/uploads/";

    @PostMapping("/uploads")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Please select a file to upload";
        }
        try {
            // Get the file and save it to the uploads directory
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
            Files.write(path, bytes);
            return "File uploaded successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file";
        }
    }
}