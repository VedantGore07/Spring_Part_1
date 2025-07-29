package com.infosys.jpacruddemo.services;

import com.infosys.jpacruddemo.beans.Batches;

import java.util.List;
import java.util.Optional;

public interface BatchServiceInterface {
    public void addBatch(Batches batch);
//    public void saveMultiple(List<Batches> batches);

    void saveMultiple(List<Batches> batches);
    Optional<Batches> findById(int batchId);
//    public void findBatch(int batchId);
    public void updateBatchById(int batchId);
    public void listAllBatches();
    public void removeBatch(int batchId);
    public List<Batches> findOnBasisOfBatchName(String batchName);
    public List<Batches> findOnBasisOfStartDateAndEndDate(String batchStartDate, String batchendDate);
    public void findMyBatches();
    public Batches serviceShowAllBatchesOnBasisOfStartDateAndName(String batchStartDate, String batchName);
    public void nativeShowBatches();
    public String nativeBatchNameById(int batchId);
}
