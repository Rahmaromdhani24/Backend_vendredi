package com.projet.BackendPfe.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projet.BackendPfe.Entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);
    User findByEmail(String email) ; 
	Boolean existsByCin(int cin);
	Boolean existsByEmail(String email);
	List<User> findByRole(String role);
	User  findByCin(int cin);

	
}
