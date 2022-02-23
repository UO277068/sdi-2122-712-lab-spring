package com.uniovi.sdi2122712spring.entities;

import javax.persistence.*;

@Entity
public class Mark {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Double score;

    @ManyToOne
    @JoinColumn(name= "user_id") //Recordar¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡
    private User user;

    //Constructores
     public Mark(){

     }

    public Mark(Long i, String d, Double s){
         this.id=i;
         this.description=d;
         this.score=s;
     }

     public Mark(String description , Double score, User user){
         super();
         this.description=description;
         this.user=user;
         this.score=score;
     }
    //

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", score=" + score +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
