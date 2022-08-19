package com.ekang.demo.movieapi.util;

import com.ekang.demo.movieapi.model.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageUtils {
    private final MessageSource messageSource;

    public MessageDto get(String key) {
        return new MessageDto(messageSource.getMessage(key, null, LocaleContextHolder.getLocale()));
    }

    public MessageDto get(String key, String value) {
        return new MessageDto(messageSource.getMessage(key, new String[]{value}, LocaleContextHolder.getLocale()));
    }
}
