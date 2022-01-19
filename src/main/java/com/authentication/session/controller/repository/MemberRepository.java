package com.authentication.session.controller.repository;

import com.authentication.session.controller.model.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

}
