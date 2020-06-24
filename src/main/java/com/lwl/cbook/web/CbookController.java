package com.lwl.cbook.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CbookController {
		
		@RequestMapping(value = {"/home"})
		public String index() {
			return "Welcome to Cbook app!";
		}
		@RequestMapping("/api/cbook/names")
		public List<String> names(){
			return java.util.stream.Stream.of("Vijay","Ajay","Charan").collect(Collectors.toList());
		}
}
