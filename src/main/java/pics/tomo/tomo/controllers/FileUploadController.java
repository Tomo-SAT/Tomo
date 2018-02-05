package pics.tomo.tomo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
    public class FileUploadController {

//        @Value("${file-upload-path}")
//        private String uploadPath;

        @GetMapping("img-display")
        public String showUploadFileForm() {
            return "img-display";
        }

        @PostMapping("/profile/image")
        @ResponseBody
        public String saveFile(
                //@RequestParam(name = "img-display") MultipartFile uploadedFile,
                @RequestParam("url") String url,
                @RequestParam("id") long userId
        ) {


            System.out.println("[saveFile] url: " + url);
            // INJECT THE USER REPOSITORY
            // CALL THE METHOD findOne USING THE userId variable
            // images.setProfilePic(url);
            // usersRepository.save(user);

//            String filename = uploadedFile.getOriginalFilename();
//            String filepath = Paths.get(uploadPath, filename).toString();
//            File destinationFile = new File(filepath);
//            try {
//                uploadedFile.transferTo(destinationFile);
//                model.addAttribute("message", "File successfully uploaded!");
//            } catch (IOException e) {
//                e.printStackTrace();
//                model.addAttribute("message", "Oops! Something went wrong! " + e);
//            }
            return "ok";
        }
    }

