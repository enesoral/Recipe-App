package com.enesoral.recipeapp.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    boolean saveRecipeImage(Long recipeId, MultipartFile multipartFile);
}
