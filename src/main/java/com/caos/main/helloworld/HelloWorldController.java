package com.caos.main.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

	
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-internationalized")
	public String helloWorldInternationalized() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("hello world");
	}
	
	@GetMapping(path="hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldbeanPath(@PathVariable String name) {
		return new HelloWorldBean(String.format(" Hello world %s", name));
	}
}
