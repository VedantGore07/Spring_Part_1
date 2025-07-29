package com.vedant.courseManagement;

import com.vedant.courseManagement.beans.Courses;
import com.vedant.courseManagement.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class CourseManagementApplication implements CommandLineRunner {

	@Autowired
	CourseServices courseServices;

	@Value("${spring.application.name}")
	private String appName;

	public static void main(String[] args) {
		SpringApplication.run(CourseManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner=new Scanner(System.in);

		System.out.println(appName);
		System.out.println("Enter 1 to add new Course");
		System.out.println("Enter 2 to find the Course on basis of id");
		System.out.println("Enter 3 to update Course details");
		System.out.println("Enter 4 to remove Course");
		System.out.println("Enter 5 Fetch Course by Instructor");
		System.out.println("Enter 6 Fetch Course by Category;");
		System.out.println("Enter 7 Fetch Course by Schedule");
		System.out.println("Enter your choice :-");



		int Operation =scanner.nextInt();
		switch (Operation){
			case 1:
				System.out.println("Enter course Title");
				String courseTitle = scanner.next();
				System.out.println("Enter course Description ");
				String courseDescription= scanner.next();
				System.out.println("Enter course Instructor");
				String courseInstructor = scanner.next();
				System.out.println("Enter course Category");
				String courseCategory = scanner.next();
				System.out.println("Enter course Schedule");
				String courseSchedule = scanner.next();

				Courses course1 = new Courses();
				course1.setCourseTitle(courseTitle);
				course1.setCourseDescription(courseDescription);
				course1.setCourseInstructor(courseInstructor);
				course1.setCourseCategory(courseCategory);
				course1.setCourseSchedule(courseSchedule);
				courseServices.addCourse(course1);
				break;

			case 2:
				System.out.println("Enter CourseId to see Course details");
				int CourseId = scanner.nextInt();
				try {
					Optional<Courses> optional = courseServices.findCourseById(CourseId);
					Courses courses = optional.get();
					System.out.println(courses.toString());
				} catch (Exception e) {
					System.err.println("Id not found");
				}
				break;

			case 3:
				System.out.println("Enter CourseId to update:");
				int updateId = scanner.nextInt();
				Optional<Courses> optionalCourses = courseServices.findCourseById(updateId);
				if (optionalCourses.isPresent()) {
					Courses existingCourse = optionalCourses.get();
					System.out.println("Existing Details:");
					System.out.println("courseTitle: " + existingCourse.getCourseTitle());
					System.out.println(" courseDescription: " + existingCourse.getCourseDescription());
					System.out.println("courseInstructor: " + existingCourse.getCourseInstructor());
					System.out.println("courseCategory:" + existingCourse.getCourseCategory());
					System.out.println("courseSchedule:" + existingCourse.getCourseSchedule());

					System.out.println("Enter course Title");
					String newTitle = scanner.next();
					System.out.println("Enter course Description ");
					String newDecsription = scanner.next();
					System.out.println("Enter course Instructor");
					String newInstructor = scanner.next();
					System.out.println("Enter course Category");
					String newCategory = scanner.next();
					System.out.println("Enter course Schedule");
					String newSchedule =scanner.next();

					existingCourse.setCourseTitle(newTitle);
					existingCourse.setCourseDescription(newDecsription);
					existingCourse.setCourseInstructor(newInstructor);
					existingCourse.setCourseCategory(newCategory);
					existingCourse.setCourseSchedule(newSchedule);

					courseServices.updateCourse(existingCourse);
					System.out.println("Course updated successfully.");
				}else {
					System.out.println("Course not found with ID: " + updateId);
				}
				break;

			case 4:
				System.out.println("Enter Course ID to delete:");
				int deleteId = scanner.nextInt();
				try {
					courseServices.deleteCourse(deleteId);
					System.out.println("Course deleted successfully.");
				} catch (Exception e) {
					System.out.println("Failed to delete. ID may not exist.");
				}
				break;

			case 5:
				System.out.println("Enter Instructor Name:");
				String instructor = scanner.next();
				List<Courses> byInstructor = courseServices.getByInstructor(instructor);
				if (byInstructor.isEmpty()) {
					System.out.println("No courses found for instructor " + instructor);
				} else {
					byInstructor.forEach(System.out::println);
				}
				break;

			case 6:
				System.out.println("Enter Course Category:");
				String category = scanner.next();
				List<Courses> byCategory = courseServices.getByCategory(category);
				if (byCategory.isEmpty()) {
					System.out.println("No courses found in category " + category);
				} else {
					byCategory.forEach(System.out::println);
				}
				break;

			case 7:
				System.out.println("Enter part of the schedule :");
				String schedulePart = scanner.next();
				List<Courses> bySchedule = courseServices.getBySchedule(schedulePart);
				if (bySchedule.isEmpty()) {
					System.out.println("No courses found in schedule: " + schedulePart);
				} else {
					bySchedule.forEach(System.out::println);
				}
				break;


		}

	}
}
