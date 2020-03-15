package com.enesoral.recipeapp.services;

import com.enesoral.recipeapp.domain.Recipe;
import com.enesoral.recipeapp.dto.RecipeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class FileServiceImpl implements FileService {

    private final RecipeService recipeService;

    @Override
    public boolean saveRecipeImage(Long recipeId, MultipartFile multipartFile) {
        try {
            RecipeDto recipe = recipeService.findDtoById(recipeId);
            Byte[] byteObjects = new Byte[multipartFile.getBytes().length];
            int i = 0;
            for(byte b: multipartFile.getBytes()) {
                byteObjects[i++] = b;
            }
            recipe.setImage(byteObjects);
            recipeService.saveRecipeDto(recipe);

        } catch(IOException e) {
            return false;
        }
        return true;
    }
}
