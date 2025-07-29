package com.infosys.curddemo.services;

import com.infosys.curddemo.beans.Batches;
import org.hibernate.engine.jdbc.batch.spi.Batch;

import java.util.List;
import java.util.Optional;

public interface BatchServiceInterface {

    public void addBatch(Batches batch);

    public void addMultipleBatches(List<Batches> batchesList);

    public Optional<Batches> findBatchById(int batchId);

    public void updateOnBasisOfId(int batchId);

    public void removeBatchById(int batchId);

//    List<Batches> findOnBasisOfBatchName(String batchName);


//*********************** jpql


    public List<Batches> findAllBatchesUsingQuery();

    public Batches showBatchDetailsOnBasisOfStartDate(String batchStartDate, String batchName);

    public void showAllNativeQuery();



}
