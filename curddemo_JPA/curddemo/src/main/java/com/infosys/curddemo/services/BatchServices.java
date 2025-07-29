package com.infosys.curddemo.services;


import com.infosys.curddemo.beans.Batches;
import com.infosys.curddemo.repos.BatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class BatchServices implements BatchServiceInterface {

    @Autowired
    BatchRepo batchRepo;

    @Override
    public void addBatch(Batches batch) {
        batchRepo.save(batch);
    }

    @Override
    public void addMultipleBatches(List<Batches> batchesList) {
        Iterable<Batches> batchInfo = batchRepo.saveAll(batchesList);
//        batchInfo.forEach(batch -> {
//            System.out.println(batch.toString());
//        });
    }

    @Override
    public Optional<Batches> findBatchById(int batchId) {
        return batchRepo.findById(batchId);
    }

    @Override
    public void updateOnBasisOfId(int batchId) {
       try{
           Optional<Batches> optional = batchRepo.findById(batchId);
           Batches batch = optional.get();
           if(batch != null){
               Scanner scanner = new Scanner(System.in);
               System.out.println("Enter new Startdate");
               String newDate = scanner.next();

               System.out.println("Enter new enddate");
               String endDate = scanner.next();

               batch.setBatchStartDate(newDate);
               batch.setBatchEndDate(endDate);

               batchRepo.save(batch);
           }
       }
       catch (Exception e){
           System.err.println("Batch Id not found in update batch in services"+e);
       }
    }

    @Override
    public void removeBatchById(int batchId) {
        try{
            batchRepo.deleteById(batchId);
        }
        catch (Exception e){
            System.err.println("not valid");
        }
    }

//    @Override
//    public List<Batches> findOnBasisOfBatchName(String batchName) {
//        return batchRepo.findOnBasisOfBatchName(batchName);
//    }

    @Override
    public List<Batches> findAllBatchesUsingQuery() {
        return batchRepo.showAllBatches();
    }

    @Override
    public Batches showBatchDetailsOnBasisOfStartDate(String batchStartDate, String batchName) {
        return batchRepo.showAllBatchesOnBasisOfStartDateAndName(batchStartDate, batchName);
    }

    @Override
    public void showAllNativeQuery() {

        List<Batches> batches = batchRepo.showAllBatchesNativeQuery();
        batches.forEach(batches1 -> System.out.println(batches1));
    }


}