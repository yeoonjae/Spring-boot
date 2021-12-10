package com.infren.study.demowebmvc;

import java.io.File;
import java.io.IOException;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileController {

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/file")
    public String uploadFileForm(Model model) {
        return "files/index";
    }

    @PostMapping("/file")
    public String uploadFile(@RequestParam MultipartFile file,
        RedirectAttributes attributes) {
        String message = file.getOriginalFilename() + " is uploaded.";
        System.out.println(message);
        attributes.addFlashAttribute("message", message);
        return "redirect:/events/list";
    }

    @GetMapping("/file/{filename}")
    public ResponseEntity<Resource> fileDownload(@PathVariable String filename) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + filename);
        File file = resource.getFile();

        Tika tika = new Tika();
        String mediaType = tika.detect(file);

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION,
                "attachement; filename=\"" + resource.getFilename() + "\"")
            .header(HttpHeaders.CONTENT_TYPE, mediaType)
            .header(HttpHeaders.CONTENT_LENGTH, file.length() + "")
            .body(resource);

    }
}
