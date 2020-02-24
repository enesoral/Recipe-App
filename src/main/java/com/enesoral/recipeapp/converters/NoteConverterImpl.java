package com.enesoral.recipeapp.converters;

import com.enesoral.recipeapp.domain.Note;
import com.enesoral.recipeapp.dto.NoteDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NoteConverterImpl implements NoteConverter {

    private final ModelMapper modelMapper;

    @Override
    public NoteDto convertToNoteDto(Note note) {
        if (note == null) {
            return null;
        }
        return modelMapper.map(note, NoteDto.class);
    }

    @Override
    public Note convertToNote(NoteDto noteDto) {
        if (noteDto == null) {
            return null;
        }
        return modelMapper.map(noteDto, Note.class);
    }
}
