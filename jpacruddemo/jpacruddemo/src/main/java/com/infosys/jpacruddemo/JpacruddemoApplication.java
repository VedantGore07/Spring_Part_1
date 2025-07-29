package com.infosys.jpacruddemo;

import com.infosys.jpacruddemo.beans.Batches;
import com.infosys.jpacruddemo.services.BatchServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class JpacruddemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpacruddemoApplication.class, args);

	}
	@Autowired
	BatchServices batchServices;

//	@Value("${spring.application.name}")
	private String appName;


	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
//		System.out.println(appName);
		System.out.println("1. Add new batch");
		System.out.println("2. save multiple");
		System.out.println("3. find batch by id");
		System.out.println("4. Update batch detail by id");
		System.out.println("5. List all batches");
		System.out.println("6. Remove a batch");
		System.out.println("7. Find batch by name");
		System.out.println("8. Find by start and end date");
		System.out.println("9. custom query list all");
		System.out.println("10. batches based on start date and name");
		System.out.println("11. show all batches native query");
		System.out.println("12. batch name by id native");
		System.out.print("Enter option : ");
		int operation = scanner.nextInt();
		switch (operation) {
			case 1:
				System.out.println("Enter batch name : ");
				String batchName = scanner.next();
				System.out.println("Enter batch start date : ");
				String batchStartDate=  scanner.next();
				System.out.println("Enter batch end date : ");
				String batchEndDate=  scanner.next();
				Batches batch1 = new Batches();
				batch1.setBatchName(batchName);
				batch1.setBatchStartDate(batchStartDate);
				batch1.setBatchEndDate(batchEndDate);
				batchServices.addBatch(batch1);
				break;
			case 2:
				System.out.println("Enter no. of batches to save : ");
				int numOfBatches = scanner.nextInt();
				List<Batches> batchesList = new ArrayList<Batches>();
				for(int i=0 ; i<numOfBatches ; i++){
					System.out.println("Enter batch name : ");
					String batchName1 = scanner.next();
					System.out.println("Enter batch start date : ");
					String batchStartDate1=  scanner.next();
					System.out.println("Enter batch end date : ");
					String batchEndDate1=  scanner.next();
					Batches batch2 = new Batches();
					batch2.setBatchName(batchName1);
					batch2.setBatchStartDate(batchStartDate1);
					batch2.setBatchEndDate(batchEndDate1);
					batchesList.add(batch2);
				}
				batchServices.saveMultiple(batchesList);
				break;
			case 3:
				System.out.println("Enter batch id : ");
				int batchId = scanner.nextInt();
				try{
					Optional<Batches> batch = batchServices.findById(batchId);
					System.out.println(batch.toString());
				} catch (Exception e) {
					System.err.println(e);
				}
				break;
			case 4:
				System.out.println("Enter batch id : ");
				int batchId1 = scanner.nextInt();
				batchServices.updateBatchById(batchId1);
				break;
			case 5:
				System.out.println("Printing all batches");
				batchServices.listAllBatches();
			case 6:
				System.out.println("Enter batch id to delete : ");
				int batchId2 = scanner.nextInt();
				batchServices.removeBatch(batchId2);
				break;
			case 7:
				System.out.println("Enter batch name : ");
				String fbatchName = scanner.next();
				List<Batches> batches = batchServices.findOnBasisOfBatchName(fbatchName);
				batches.forEach(batch -> System.out.println(batch.toString()));
				break;
			case 8:
				System.out.println("Enter startdate : ");
				String startDate = scanner.next();
				System.out.println("Enter end date : ");
				String endDate = scanner.next();
				List<Batches> batches1 = batchServices.findOnBasisOfStartDateAndEndDate(startDate, endDate);
				batches1.forEach(batches2 -> System.out.println(batches2.toString()));
			case 9:
				batchServices.findMyBatches();
				break;
			case 10:
				System.out.print("batch date");
				String batchStartDate1 = scanner.next();
				System.out.print("batch name");
				String batchName1 = scanner.next();
				Batches batches2 = batchServices.serviceShowAllBatchesOnBasisOfStartDateAndName(batchStartDate1, batchName1);
				System.out.println(batches2);
				break;
			case 11:
				batchServices.nativeShowBatches();
				break;
			case 12:
				System.out.print("enter batch id : ");
				int batchId3 = scanner.nextInt();
				System.out.println(batchServices.nativeBatchNameById(batchId3));
				break;	
			default:
				System.out.println("Select appropriate options");
		}
	}
}
