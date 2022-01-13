package com.example.demo.entity

import javax.persistence.*


@Entity
class Member(

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    val id: Long? = null,
    var username: String,
    var age: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    var team: Team? = null,

    ) {
    fun changeTeam(team: Team) {
        this.team?.members?.remove(this)

        team.members.add(this)
        this.team = team
    }

    override fun toString(): String {
        return "Member(id=$id, username='$username', age=$age, team=$team)"
    }


//    override fun toString(): String {
//        return "Member(id=$id, username=$username, age=$age)"
//    }
}