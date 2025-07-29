package com.infosys.curddemo;


import com.infosys.curddemo.beans.Batches;
import com.infosys.curddemo.beans.Student;
import com.infosys.curddemo.services.BatchServices;
import com.infosys.curddemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class CurddemoApplication implements CommandLineRunner {

	@Autowired
	BatchServices batchServices;

	@Autowired
	StudentService studentService;

	@Value("${spring.application.name}")
	private String appName;


	public static void main(String[] args) {
		SpringApplication.run(CurddemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println(appName);
		System.out.println("Enter 1 to add new batch");
		System.out.println("Enter 2 to add multiple batches on basis of id");
		System.out.println("Enter 3 to find the batches on basis of ID");
		System.out.println("Enter 4 to update batch details");
		System.out.println("Enter 5 to remove batch");
		System.out.println("Enter 6 to find batch name on basis of id");
		System.out.println("Enter 7 to find all batches on basis of custom query using jpql");
		System.out.println("Enter 8 to find all batches on basis of batchname and startdate custom query using jpql");
		System.out.println("Enter 9 to find all batches native query custom query using jpql");
		System.out.println("Enter 10 to find all students using named query");


		int operation = scanner.nextInt();

		switch (operation)
		{
			case 1:

				System.out.println("Enter Batch Name");
				String batchName = scanner.next();

				System.out.println("Enter Batch Start Date");
				String startDate = scanner.next();

				System.out.println("Enter Batch End Date");
				String endDate = scanner.next();

				Batches batch1 = new Batches();
				batch1.setBatchName(batchName);
				batch1.setBatchStartDate(startDate);
				batch1.setBatchEndDate(endDate);

				batchServices.addBatch(batch1);
				break;

			case 2:
				int noOfBatches = scanner.nextInt();
				List<Batches> batchesList = new ArrayList<Batches>();
				for(int i=0; i<noOfBatches; i++){
					System.out.println("Enter Batch Name");
					String batchName1 = scanner.next();

					System.out.println("Enter Batch Start Date");
					String startDate1 = scanner.next();

					System.out.println("Enter Batch End Date");
					String endDate1 = scanner.next();

					Batches batch2 = new Batches();
					batch2.setBatchName(batchName1);
					batch2.setBatchStartDate(startDate1);
					batch2.setBatchEndDate(endDate1);

					batchesList.add(batch2);
				}
				batchServices.addMultipleBatches(batchesList);
				break;

			case 3:
				System.out.println("Enter BatchId to see batch details");
				int batchId = scanner.nextInt();
				try{
					Optional<Batches> optional =  batchServices.findBatchById(batchId);
					Batches batch = optional.get();
					System.out.println(batch.toString());
				}
				catch (Exception e){
					System.err.println("ID not found");
				}
				break;

			case 4:
				System.out.println("Enter Batch Id");
				int ubatchId = scanner.nextInt();

				batchServices.updateOnBasisOfId(ubatchId);
				break;

			case 5:
				System.out.println("Enter Batch Id");
				int dbatch = scanner.nextInt();

				batchServices.removeBatchById(dbatch);
				break;

//			case 6:
//				System.out.println("Enter Batch Name");
//				String fbatchName = scanner.next();
//
//				batchServices.findOnBasisOfBatchName(fbatchName);
//				break;

			case 7:
				List<Batches> batchesList2 =  batchServices.findAllBatchesUsingQuery();
				batchesList2.forEach(batch -> System.out.println(batch));
				break;

			case 8:
				System.out.println("Enter Batch Name");
				String batchName2 = scanner.next();

				System.out.println("Enter Batch Start Date");
				String startDate2 = scanner.next();

				Batches batch = batchServices.showBatchDetailsOnBasisOfStartDate(startDate2, batchName2);
				if(batch != null)
				 {
					 System.out.println(batch.toString());
			     }
				else {
					System.out.println("no batch found");
				}

				break;

			case 9:
				batchServices.showAllNativeQuery();
				break;

			case 10:
				List<Student> studentlist = studentService.findAllStudent();
				studentlist.forEach(student -> System.out.println(student));
				break;

			default:
				System.out.println("please select valid operation. Thank you");

		}
	}
}