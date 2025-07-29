package com.infosys.curddemo.repos;

import com.infosys.curddemo.beans.Batches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepo extends JpaRepository<Batches,Integer> {

//    List<Batches> findOnBasisOfBatchName(String batchName);

//    ******************** JPQL  *********************

    @Query("select batch from Batches batch")
    public List<Batches> showAllBatches();

//    don't give space when passing parameter
//    while passing parameter write columnname= :parameter name
    @Query("select batch from Batches batch where batch.batchStartDate= :bsd AND batch.batchName= :bn")
//    bind parameter using @param
    public Batches showAllBatchesOnBasisOfStartDateAndName(@Param("bsd") String startDate, @Param("bn") String batchName);

    @Query(value = "select * from tb_batches", nativeQuery = true)
    public List<Batches> showAllBatchesNativeQuery();
}