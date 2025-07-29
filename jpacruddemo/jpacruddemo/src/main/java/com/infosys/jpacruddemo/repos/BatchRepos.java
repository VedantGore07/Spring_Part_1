package com.infosys.jpacruddemo.repos;

import com.infosys.jpacruddemo.beans.Batches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepos extends JpaRepository<Batches, Integer> {
    public List<Batches> findByBatchName(String batchName);
    public List<Batches> findByBatchStartDateAndBatchEndDate(String batchStartDate, String batchEndDate);

    @Query("select batch from Batches batch")
    public List<Batches> showAllBatches();

    @Query("select batch from Batches batch where batch.batchStartDate= :bsd AND batch.batchName= :bn")
    public Batches showBatchOnBasisOfStartDateAndName(@Param("bsd") String startDate,@Param("bn") String batchName);

    @Query(value = "select * from tb_batches", nativeQuery = true)
    public List<Batches> showAllBatchesNativeQuery();

    @Query(value = "select batch_name from tb_batches where batch_id = ?1", nativeQuery = true)
    public String showBatchNameByIdNative(int batchId);
}
