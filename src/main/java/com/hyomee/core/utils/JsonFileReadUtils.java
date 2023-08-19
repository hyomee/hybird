package com.hyomee.core.utils;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

@RequiredArgsConstructor
@Component
public class JsonFileReadUtils {

    private static String mockDir ;

    @Value("${mockdir}")
    public void setMockDir(String mockDir) {
       this.mockDir = mockDir;
    }

    public static <T> T jsonLoading(String filename , Class<?> className) throws FileNotFoundException {

        Reader reader = new FileReader(mockDir + "\\" + filename + ".json");

        return (T) new Gson().fromJson(reader, className);

    }
}
