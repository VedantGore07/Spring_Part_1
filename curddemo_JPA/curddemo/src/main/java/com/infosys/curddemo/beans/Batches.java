package com.infosys.curddemo.beans;

import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
@Table(name="tb_batches")
public class Batches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Size(min = 1, message = "batch id must have 3 character")
    private  int batchId;


    @NotBlank(message = "batch name can not be empty")
    private  String batchName;

    @NotBlank(message = "batch start date can not be empty")
    private  String batchStartDate;
    private  String batchEndDate;

//    @Email private String trainerEmail;    => this will check the valid email

//    public Batches(String batchName, String batchStartDate, String batchEndDate) {
//        this.batchName = batchName;
//        this.batchStartDate = batchStartDate;
//        this.batchEndDate = batchEndDate;
//    }

//    @Size(min = 3, message = "batch id must have 3 character")
    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public @NotBlank(message = "batch name can not be empty") String getBatchName() {
        return batchName;
    }

    public void setBatchName(@NotBlank(message = "batch name can not be empty") String batchName) {
        this.batchName = batchName;
    }

    public @NotBlank(message = "batch start date can not be empty") String getBatchStartDate() {
        return batchStartDate;
    }

    public void setBatchStartDate(@NotBlank(message = "batch start date can not be empty") String batchStartDate) {
        this.batchStartDate = batchStartDate;
    }

    public  String getBatchEndDate() {
        return batchEndDate;
    }

    public void setBatchEndDate(String batchEndDate) {
        this.batchEndDate = batchEndDate;
    }


    @Override
    public String toString() {
        return "Batches{" +
                "batchId=" + batchId +
                ", batchName='" + batchName + '\'' +
                ", batchStartDate='" + batchStartDate + '\'' +
                ", batchEndDate='" + batchEndDate + '\'' +
                '}';
    }


}