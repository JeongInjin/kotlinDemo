package com.example.demo.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "team")
class Team(

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    val id: Long? = null,

    var name: String? = null,

    @JsonIgnore
    @OneToMany(mappedBy = "team")
    var members: MutableList<Member> = mutableListOf(),

    ) {

    override fun toString(): String {
        return "Team(id=$id, name=$name)"
    }


}