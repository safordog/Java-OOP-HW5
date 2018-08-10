/*
 * 3. Усовершенствуйте класс, описывающий группу студентов,
 * добавив возможность сохранения группы в файл.
 * 4. Реализовать обратный процесс. Т.е. считать данные о
 * группе из файла, и на их основе создать объект типа группа.
 */

package com.gmail.safordog;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws MyException, IOException {
		
		Group gr = new Group();
		gr.setGroupName("25/05");
		Student st = new Student();
		Student stOne = new Student("Washington", "George", "male", 24, 4.5, "25/04");
		Student stTwo = new Student("Adams", "John", "male", 25, 4.2, "25/04");
		Student stThree = new Student("Jefferson", "Thomas", "male", 20, 4.7, "25/04");
		Student stFour = new Student("Madison", "James", "male", 17, 4.0, "25/04");
		Student stFive = new Student("Monroe", "Lisa", "female", 24, 4.9, "25/04");
		Student stSix = new Student("Adams", "John Quincy", "male", 17, 3.5, "25/04");
		Student stSeven = new Student("Jackson", "Andrew", "male", 21, 5.0, "25/04");
		Student stEight = new Student("Van", "Martina", "female", 20, 4.5, "25/04");
		Student stNine = new Student("Harrison", "William Henry", "male", 22, 4.7, "25/04");
		Student stTen = new Student("Tyler", "John", "male", 24, 4.4, "25/04");
		Student stEleven = new Student("Polk", "James K.", "male", 25, 4.6, "25/04");
		try {
		gr.addSt(stOne);
		gr.addSt(stTwo);
		gr.addSt(stThree);
		gr.addSt(stFour);
		gr.addSt(stFive);
		gr.addSt(stSix);
		gr.addSt(stSeven);
		gr.addSt(stEight);
		gr.addSt(stNine);
		gr.addSt(stTen);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		System.out.println("Compare average mark: ");
		Arrays.sort(gr.getGroup(), new CompareAverageMark());
		for (Student temp : gr.getGroup()) {
			System.out.println(temp);
		}
		System.out.println();
		System.out.println("Compare age: ");
		Arrays.sort(gr.getGroup(), new CompareAge());
		for (Student temp : gr.getGroup()) {
			System.out.println(temp);
		}
		System.out.println();
		System.out.println("Compare gender: ");
		Arrays.sort(gr.getGroup(), new CompareGender());
		for (Student temp : gr.getGroup()) {
			System.out.println(temp);
		}
		System.out.println();
		System.out.println("Group for VOENCOM: ");
		gr.getNextSoilder(gr.getGroup());
		for (Student temp : gr.getNextSoilder(gr.getGroup())) {
		System.out.println(temp);
		}
		gr.saveGroup(gr.getGroup());
		gr.getGroupFromFile(new File("group.csv"));

	}

}
