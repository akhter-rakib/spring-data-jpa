package com.example.springdatajpa.service;

import com.example.springdatajpa.dao.UserRepository;
import com.example.springdatajpa.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void intDB() {
        List<User> userList = Stream.of(User.userDataPrepare("Rakib", "Software Engineer", 34),
                        User.userDataPrepare("Mumin", "Implementer Head", 33),
                        User.userDataPrepare("Soikot", "Project Manager", 34),
                        User.userDataPrepare("Zamil", "Software Engineer", 30))
                .collect(Collectors.toList());
        userRepository.saveAll(userList);
    }

    public List<User> getUserByProfession(String profession) {
        return userRepository.findByProfession(profession);
    }

    public int countByAge(int age) {
        return userRepository.countByAge(age);
    }

    public List<User> deleteUserByName(String name) {
        return userRepository.deleteByName(name);
    }

    public List<User> getByAgeAndProfession(int age, String profession) {
        return userRepository.findByProfessionAndAge(profession, age);
    }

    public List<User> getUserIgnoreCaseProfession(String profession) {
        return userRepository.findByProfessionIgnoreCase(profession);
    }

    public List<User> userListWithCustomSQL() {
        return userRepository.userCustomQueryAllList();
    }

    public void updateName(String name) {
        userRepository.updateName(name);
    }

    // sort
    public List<User> getUserSort(String field) {
        return userRepository.findAll(Sort.by(field));
    }

    // pagination
    public Page<User> getPaginatedUser() {
        return userRepository.findAll(PageRequest.of(0, 1));
    }

    // pagination and sorting
    public List<User> getAllUser(Integer pageNo, Integer pageSize, String sortBy, String sortDirection) {
        String sortDir = !sortDirection.isBlank() ? sortDirection : Sort.Direction.ASC.name();
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable paging = PageRequest.of(pageNo, pageSize, sort);
        Page<User> pagedResult = userRepository.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<User>();
        }
    }
}
