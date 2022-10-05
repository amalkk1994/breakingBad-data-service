package com.amc.breakingBad.uploadData;

import com.amc.breakingBad.uploadData.model.CharactersBB;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class UploadDataApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(UploadDataApplication.class, args);
	}

	public void run(String... args) throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		TypeReference<List<CharactersBB>> typeReference = new TypeReference<List<CharactersBB>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/characters.json");

		List<CharactersBB> charactersBB = objectMapper.readValue(inputStream,typeReference);

		System.out.println(charactersBB);

	}

}
