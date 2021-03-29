package com.example.demo.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import com.example.demo.dao.IssueRepo;
import com.example.demo.model.Issue;
//import com.sun.el.stream.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;

@RestController
public class IssueController
{
	@Autowired
	IssueRepo repo;

	@DeleteMapping("/issue/{aid}")
	public String deleteIssue(@PathVariable int aid)
	{
		Issue a=repo.getOne(aid);
		repo.delete(a);
		return "one row deleted";
	}
	@PutMapping(path="/issue")
	public Issue saveorUpdate(@RequestBody Issue issue)
	{
		repo.save(issue);
		return issue;
	}
	@PostMapping(path="/issue")
	public Issue addIssue(@RequestBody Issue issue)
	{
		repo.save(issue);
		return issue;
	}
	@GetMapping(path="/issue")
	public List<Issue> getIssues()
	{
		return repo.findAll();
	}
	@RequestMapping("/issue/{aid}")
	public java.util.Optional<Issue> getIssue(@PathVariable("aid") int aid)
	{
		return repo.findById(aid);
	}
}
