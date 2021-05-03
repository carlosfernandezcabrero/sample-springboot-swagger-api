package com.cfernandez.samplespringbootswaggerapi.adapter.web;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "home",
	value = "Home")
class HomeController {
	
	@GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
	@ApiOperation(tags = "home", value = "Welcome HTML code")
	public ResponseEntity<String> home(){
		return ResponseEntity.ok().body("<header><h1>Welcome to my API</h1></header>");
	}

}
