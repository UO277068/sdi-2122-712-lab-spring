package com.uniovi.sdi2122712spring.entities;

import javax.persistence.*;

@Entity
public class Mark {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Double score;

    //Constructores
     public Mark(){

     }
    public Mark(Long i, String d, Double s){
         this.id=i;
         this.description=d;
         this.score=s;
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
