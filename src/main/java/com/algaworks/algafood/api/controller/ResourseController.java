package com.algaworks.algafood.api.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/images")
@RestController
public class ResourseController {

	@GetMapping(value = "/get-file/{id}", produces = "application/zip")
	public @ResponseBody ResponseEntity<byte[]> getFile(@PathVariable Long id) throws IOException {
		String resourse = "/" + id.toString().concat(".zip");
		System.out.println("Resourse: " + resourse); // "/400.zip"
		
		
		InputStream in = getClass().getResourceAsStream(resourse);

		byte[] contents = IOUtils.toByteArray(in);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=400.zip");
		responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/zip");
		return new ResponseEntity<byte[]>(contents, responseHeaders, HttpStatus.OK);
	}

}
