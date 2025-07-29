package com.infosys.jpacruddemo.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_batches")
@NoArgsConstructor
public class Batches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

//    @Size(min = 1, message = "Batch id must have 3 chars")
    private @Getter @Setter int batchId;

    @NotBlank(message = "batchname required")
    private @Getter @Setter String batchName;
    @NotBlank(message = "startdate required")
    private @Getter @Setter String batchStartDate;
    private @Getter @Setter String batchEndDate;
//    public Batches(String batchEndDate, String batchStartDate, String batchName) {
//        this.batchEndDate = batchEndDate;
//        this.batchStartDate = batchStartDate;
//        this.batchName = batchName;
//    }

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
