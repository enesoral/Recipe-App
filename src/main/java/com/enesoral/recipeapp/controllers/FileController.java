package com.enesoral.recipeapp.controllers;

import com.enesoral.recipeapp.dto.RecipeDto;
import com.enesoral.recipeapp.services.FileService;
import com.enesoral.recipeapp.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Controller
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {
    private final FileService fileService;
    private final RecipeService recipeService;

    @GetMapping("/{id}/image")
    public String showUploadForm(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findDtoById(Long.parseLong(id)));
        return "file/upload-image";
    }

    @PostMapping("/{id}/image")
    public String handleImagePost(@PathVariable String id,
                                  @RequestParam("imagefile") MultipartFile multipartFile) {
        fileService.saveRecipeImage(Long.parseLong(id), multipartFile);
        return "redirect:/recipe/" + id + "/show";
    }

    @GetMapping("/{id}/recipeimage")
    public void renderImageFromDb(@PathVariable String id, HttpServletResponse response) throws Exception {
        RecipeDto recipeDto = recipeService.findDtoById(Long.parseLong(id));
        byte[] byteArray = new byte[recipeDto.getImage().length];
        int i = 0;
        for(Byte wrappedByte : recipeDto.getImage()) {
            byteArray[i++] = wrappedByte;
        }
        response.setContentType("image/jpeg");
        InputStream is = new ByteArrayInputStream(byteArray);
        IOUtils.copy(is, response.getOutputStream());
    }
}
