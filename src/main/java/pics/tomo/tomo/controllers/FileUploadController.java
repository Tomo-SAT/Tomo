package pics.tomo.tomo.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pics.tomo.tomo.daos.UsersRepository;
import pics.tomo.tomo.models.User;

@Controller
    public class FileUploadController {

        private UsersRepository usersRepo;

        public FileUploadController(UsersRepository usersRepo) {
            this.usersRepo = usersRepo;
        }

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
                @RequestParam(value = "url", required = false) String url,
                @RequestParam(value = "id", required = false) Long userId
        ) {

            User loggedInUser = (User) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();

            System.out.println("[saveFile] url: " + url);
            User user = usersRepo.findOne(loggedInUser.getId());
            user.setProfilePicture(url);
            usersRepo.save(user);
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
            return "redirect:/profile";
        }
    }

