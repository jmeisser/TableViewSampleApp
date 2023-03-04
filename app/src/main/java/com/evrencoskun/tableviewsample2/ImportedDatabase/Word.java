package com.evrencoskun.tableviewsample2.ImportedDatabase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    public String mWord;
    @ColumnInfo(name = "team")
    public String mTeam;
    @ColumnInfo(name = "data")
    public String mData;
    @ColumnInfo(name = "score")
    public String mScore;
    @ColumnInfo(name = "birthdate")
    public String birthdate;
    @ColumnInfo(name = "gender")
    public String gender;
    @ColumnInfo(name = "age")
    public String age;
    @ColumnInfo(name = "job")
    public String job;
    @ColumnInfo(name = "salary")
    public String salary;
    @ColumnInfo(name = "created_at")
    public String created_at;
    @ColumnInfo(name = "updated_at")
    public String updated_at;
    @ColumnInfo(name = "address")
    public String address;
    @ColumnInfo(name = "zipcode")
    public String zipcode;
    @ColumnInfo(name = "mobile")
    public String mobile;
    @ColumnInfo(name = "fax")
    public String fax;

    public Word(@NonNull String word) {
        this.mWord = word;
        this.mTeam = "TestTeam";
        this.mData = "TestData";
        this.mScore = "TestScore";
        this.birthdate = "birthdate";
        this.gender = "gender";
        this.age = "age";
        this.job = "job";
        this.salary = "1.00";
        this.created_at = "created_at";
        this.updated_at = "updated_at";
        this.address = "address";
        this.zipcode = "zipcode";
        this.mobile = "mobile";
        this.fax = "fax";
    }

    public void setData(String data){
        this.mData = data;
    }
    public void setTeam(String team){
        this.mTeam = team;
    }
    public void setScore(String score){
        this.mScore = score;
    }

    public String getWord(){return this.mWord;}

    public String getData(){return this.mData;}

    public String getTeam(){return this.mTeam;}

    public String getScore(){return this.mScore;}
}