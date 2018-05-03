package com.ibso.spring.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 在 @PreAuthorize 中我们可以利用内建的 SPEL 表达式：比如 'hasRole()' 来决定哪些用户有权访问。 需注意的一点是
 * hasRole 表达式认为每个角色名字前都有一个前缀 'ROLE_'。所以这里的 'ADMIN' 其实在 数据库中存储的是 'ROLE_ADMIN'
 * 。这个 @PreAuthorize 可以修饰Controller也可修饰Controller中的方法。
 **/
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository repository;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public List<NUser> getUsers() {
		List<NUser> copy = new ArrayList<NUser>();
		Iterator<NUser> iter = repository.findAll().iterator();
		while (iter.hasNext())
			copy.add(iter.next());
		return copy;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	NUser addUser(@RequestBody NUser addedUser) {
		return repository.save(addedUser);
	}

	@PostAuthorize("returnObject.username == principal.username or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public NUser getUser(@PathVariable String id) {
		return repository.findById(id).get();
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	NUser updateUser(@PathVariable Long id, @RequestBody NUser updatedUser) {
		updatedUser.setId(id);
		return repository.save(updatedUser);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	NUser removeUser(@PathVariable String id) {
		NUser deletedUser = repository.findById(id).get();
		repository.deleteById(id);
		return deletedUser;
	}

	@PostAuthorize("returnObject.username == principal.username or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public NUser getUserByUsername(@RequestParam(value = "username") String username) {
		return repository.findByUsername(username);
	}
}
