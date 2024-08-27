package org.ogleh.userservice.services;

import lombok.RequiredArgsConstructor;
import org.ogleh.userservice.dao.UserRequest;
import org.ogleh.userservice.dto.UsersDto;
import org.ogleh.userservice.entities.Department;
import org.ogleh.userservice.entities.Users;
import org.ogleh.userservice.mappers.UserMapper;
import org.ogleh.userservice.repository.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UsersRepository usersRepository;
    private final RestTemplate restTemplate;

    public void createUser(UserRequest request) {
        usersRepository.save(UserMapper.userDtoToUser(request));
    }

    public UsersDto getUser(int userID) {

        Optional<Users> findUser = usersRepository.findById(userID);

        Users user = null;
        Department department = null;

        if (findUser.isPresent()) {
            user = findUser.get();
            department = restTemplate
                    .getForObject("http://localhost:8081/department/"+user.getDepartmentId(), Department.class);
        }

        assert user != null;
        assert department != null;
        return UserMapper.userAndDepartmentToUserDto(user, department);

    }
}
