package com.enesoral.recipeapp.converters;

import com.enesoral.recipeapp.domain.Note;
import com.enesoral.recipeapp.dto.NoteDto;

public interface NoteConverter {
    NoteDto convertToNoteDto(Note note);
    Note convertToNote(NoteDto noteDto);
}
