package com.example.demo.repository.team

import com.example.demo.entity.Team
import org.springframework.data.jpa.repository.JpaRepository

interface TeamRepository : JpaRepository<Team, Long>, TeamCustomRepository {
}