package com.infosys.jpacruddemo.services;

import com.infosys.jpacruddemo.beans.Batches;
import com.infosys.jpacruddemo.repos.BatchRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class BatchServices implements BatchServiceInterface {
    @Autowired
    BatchRepos batchRepos;

    @Override
    public void addBatch(Batches batch) {
        batchRepos.save(batch);
    }

    @Override
    public void saveMultiple(List<Batches> batches) {
        Iterable<Batches> batchInfo = batchRepos.saveAll(batches);
        batchInfo.forEach(batch -> batch.toString());
    }

    @Override
    public Optional<Batches> findById(int batchId) {
        Optional<Batches> batchesOptional = batchRepos.findById(batchId);
        return batchesOptional;
    }

    @Override
    public void updateBatchById(int batchId) {
        try{
            Optional<Batches> optional = batchRepos.findById(batchId);
            Batches batch = optional.get();
            if(batch != null){
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter new start date : ");
                String newStartDate = sc.next();
                System.out.println("Enter new end date : ");
                String newEndDate = sc.next();
                batch.setBatchStartDate(newStartDate);
                batch.setBatchEndDate(newEndDate);
                batchRepos.save(batch);
            }
        } catch (Exception e){
            System.err.println("Batch id not found or other error : "+e);
        }
    }

    @Override
    public void listAllBatches() {
        List<Batches> batches = batchRepos.findAll();
        batches.forEach(batch -> System.out.println(batch.toString()));
    }

    @Override
    public void removeBatch(int batchId) {
        try{
            batchRepos.deleteById(batchId);
        } catch (Exception e) {
            System.err.println("Batch id invalid or other error : "+e);
        }
    }

    @Override
    public List<Batches> findOnBasisOfBatchName(String batchName) {
        return batchRepos.findByBatchName(batchName);
    }

    @Override
    public List<Batches> findOnBasisOfStartDateAndEndDate(String batchStartDate, String batchEndDate) {
        return batchRepos.findByBatchStartDateAndBatchEndDate(batchStartDate, batchEndDate);
    }

    @Override
    public void findMyBatches() {
        List<Batches> batches = batchRepos.showAllBatches();
        batches.forEach(batches1 -> System.out.println(batches1.toString()));
    }

    @Override
    public Batches serviceShowAllBatchesOnBasisOfStartDateAndName(String batchStartDate, String batchName) {
        return batchRepos.showBatchOnBasisOfStartDateAndName(batchStartDate, batchName);
    }

    @Override
    public void nativeShowBatches() {
        List<Batches> batches = batchRepos.showAllBatchesNativeQuery();
        batches.forEach(batches1 -> System.out.println(batches1));
    }

    @Override
    public String nativeBatchNameById(int batchId) {
        return batchRepos.showBatchNameByIdNative(batchId);
    }
}
