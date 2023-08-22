package com.hyomee.core.utils;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;

@RequiredArgsConstructor
@Component
public class JsonFileReadUtils {

    private static String mockDir ;

    @Value("${mockdir}")
    public void setMockDir(String mockDir) {
       this.mockDir = mockDir;
    }

    @SuppressWarnings("unchecked")
    public static <T> T jsonLoading(String filename , Class<?> className) throws FileNotFoundException, UnsupportedEncodingException {
        String filepath = mockDir + "\\" + filename + ".json";
        Reader reader = new FileReader(filepath);

//        BufferedReader reader01 = new BufferedReader(new InputStreamReader(new FileInputStream(filepath),"UTF-8"));

        return (T) new Gson().fromJson(reader, className);

    }
}
