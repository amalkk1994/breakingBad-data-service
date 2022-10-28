package com.amc.breakingBad.uploadData;

import com.amc.breakingBad.uploadData.model.CharactersBB;
import com.amc.breakingBad.uploadData.model.QuotesBB;
import com.amc.breakingBad.uploadData.repository.CharacterBBRepository;
import com.amc.breakingBad.uploadData.repository.QuotesBBRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class UploadDataApplication implements CommandLineRunner {

	@Autowired
	private CharacterBBRepository characterBBRepository;

	@Autowired
	private QuotesBBRepository quotesBBRepository;
	public static void main(String[] args) {

		SpringApplication.run(UploadDataApplication.class, args);
	}

	public void run(String... args) throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		TypeReference<List<CharactersBB>> typeReference = new TypeReference<List<CharactersBB>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/characters.json");

		List<CharactersBB> charactersBB = objectMapper.readValue(inputStream,typeReference);

		// CharactersBB isExisting = characterBBRepository.findByChar_id(charactersBB.get(0).getChar_id());

		for (CharactersBB characterBB: charactersBB) {

			CharactersBB isExisting = characterBBRepository.findByName(characterBB.getName());
			System.out.println(isExisting);

			if (isExisting == null) {
				System.out.println("Not Existing...inserting:" + characterBB.getName());
				characterBB.setCharId(characterBB.getChar_id());
				characterBBRepository.save(characterBB);
			} else {
				System.out.println(characterBB.getName() + " is Existing...");
			}

		}

		TypeReference<List<QuotesBB>> typeReferenceQuotes = new TypeReference<List<QuotesBB>>(){};
		InputStream inputStreamQuotes  = TypeReference.class.getResourceAsStream("/json/quotes.json");

		List<QuotesBB> quotesBB = objectMapper.readValue(inputStreamQuotes,typeReferenceQuotes);

		for (QuotesBB quoteBB: quotesBB) {

			QuotesBB isExistingQuote = quotesBBRepository.findByQuote(quoteBB.getQuote());
			System.out.println(isExistingQuote);

			if (isExistingQuote == null) {
				System.out.println("Not Existing...inserting:" + quoteBB.getQuote());
				quoteBB.setQuoteId(quoteBB.getQuote_id());
				quotesBBRepository.save(quoteBB);
			} else {
				System.out.println(quoteBB.getQuote() + " is Existing...");
			}

		}

	}

}
