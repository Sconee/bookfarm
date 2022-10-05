package com.apps.bookfarm.model;

import javax.persistence.*;

@Entity
@Table (name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private Long authorId;
    @Column(name = "author_name")
    private String authorName;
    private int phoneNumber;

    public Author(String authorName, int phoneNumber) {
        this.authorName = authorName;
        this.phoneNumber = phoneNumber;
    }

    public Author() {

    }

    public Long getAuthorId() {
        return authorId;
    }


    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
