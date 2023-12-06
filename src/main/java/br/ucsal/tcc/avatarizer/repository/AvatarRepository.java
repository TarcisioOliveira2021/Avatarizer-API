package br.ucsal.tcc.avatarizer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ucsal.tcc.avatarizer.modal.Avatar;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Long> {
	Optional<Avatar> findByAvatarCodeAndIdentificationAndType(String avatarCode, String identification, String type);
}
