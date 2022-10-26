package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 800,message = "Nhap it nhat 2 ky tu và khong qua 800 ki tu")
    @Pattern(regexp = "^[\s*a-zA-Z0-9]*$")
    private String name;

    @NotEmpty
    @Size(min = 2, max = 300,message = "Nhap it nhat 2 ky tu và khong qua 300 ki tu")
    @Pattern(regexp = "^[\s*a-zA-Z0-9]*$")
    private String singer;

    @NotEmpty
    @Size(min = 2, max = 1000,message = "Nhap it nhat 2 ky tu và khong qua 1000 ki tu")
    @Pattern(regexp = "^[\s*a-zA-Z0-9]*$")
    private String category;

    public Song() {
    }

    public Song(@NotEmpty @Size(min = 2,max = 800)@Pattern(regexp = "^[a-zA-Z0-9]*$")String name,
                @NotEmpty @Size(min = 2,max = 300)@Pattern(regexp = "^[a-zA-Z0-9]*$")String singer,
                @NotEmpty @Size(min = 2,max = 800)@Pattern(regexp = "^[a-zA-Z0-9]*$")String category) {
        this.name = name;
        this.singer = singer;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
