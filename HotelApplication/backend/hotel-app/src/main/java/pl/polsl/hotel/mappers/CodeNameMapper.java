package pl.polsl.hotel.mappers;

import org.springframework.lang.NonNull;
import pl.polsl.hotel.models.CodeName;
import pl.polsl.hotel.views.CodeNamePatch;
import pl.polsl.hotel.views.CodeNamePost;
import pl.polsl.hotel.views.CodeNameView;

public interface CodeNameMapper {

    void map(CodeNamePost codeNamePost, CodeName codeName);

    @NonNull
    CodeNameView map(CodeName codeName);

    void map(CodeNamePatch codeNamePatch, CodeName codeName);

}
