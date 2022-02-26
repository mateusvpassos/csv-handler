package br.com.mateus.csvhandler.endpoint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mateus.csvhandler.endpoint.domain.User;
import br.com.mateus.csvhandler.endpoint.exception.DatabaseException;
import br.com.mateus.csvhandler.endpoint.exception.ResourceNotFoundException;
import br.com.mateus.csvhandler.endpoint.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public User findUser(Long id) {
        Optional<User> optional = userRepository.findById(id);
        return optional.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found!"));
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Page<User> findAllPaged(PageRequest pageRequest) {
        return userRepository.findAll(pageRequest);
    }

    @Transactional
    public Long saveUser(User user) {
        return userRepository.save(user).getId();
    }

    @Transactional
    public User mergeUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("ID Not Found: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity Violation");
        }

    }
}
