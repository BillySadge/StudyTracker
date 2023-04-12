package by.bsuir.studytracker.repositories;

import by.bsuir.studytracker.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>  {

        Optional<User> findByEmail(String email);
}
