package com.gmail.safordog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Group implements Voenkom {
	
	private String groupName;
	private Student[] group = new Student[10];
	
	public Group(Student[] group) {
		super();
		this.group = group;
	}
	
	public Group(String groupName) {
		super();
		this.groupName = groupName;
	}
	
	public Group() {
		
	}

	public void addSt(Student student) throws MyException {
		for (int i = 0; i < getGroup().length; i++) {
			if (getGroup()[i] == null) {
				student.setGroup(this.groupName);
				getGroup()[i] = student;
				System.out.println("Student " + getGroup()[i].getSurname() + " added.");
				break;
			} else if (i == getGroup().length - 1) throw new MyException();
		}
	}
	
	public void delSt(Student student) {
		for (int i = 0; i < getGroup().length; i++) {
			if (getGroup()[i].getSurname().equals(student.getSurname())) {
				getGroup()[i] = null;
				System.out.println("Student " + student.getSurname() + " deleted!");
				break;
			}
		}
	}
	
	private void sort() {
		for (int i = 0; i < getGroup().length - 1; i++) {
			for (int j = i + 1; j < getGroup().length; j++) {
				if (compSt(getGroup()[i], getGroup()[j]) > 0) {
					Student temp = getGroup()[i];
					getGroup()[i] = getGroup()[j];
					getGroup()[j] = temp;
				}
			}
		}
	}
	
	public int compSt(Student one, Student two) {
		if (one != null && two == null) {
			return 1;
		}
		if (one == null && two != null) {
			return -1;
		}
		if (one == null && two == null) {
			return 0;
		}
		return one.getSurname().compareTo(two.getSurname());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sort();
		for (int i = 0; i < getGroup().length; i++) {
			if (getGroup()[i] != null) {
				sb.append((i + 1) + ") ").append(getGroup()[i].toString());
				sb.append(System.lineSeparator());
			}
		}
		return sb.toString();
	}
	
	public void findSt(String surname) {
		for (int i = 0; i < getGroup().length; i++) {
			if (getGroup()[i].getSurname().equals(surname)) {
				System.out.println((i + 1) + ") " + getGroup()[i].getSurname() + " " 
			+ getGroup()[i].getName() + ": " + getGroup()[i].getGender() + "; " + getGroup()[i].getAge() 
			+ "; " + getGroup()[i].getAverageMark() + ".");
			}
		}
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public void addStInteract() throws MyException {
		Student student = new Student(); 
		student.setSurname(JOptionPane.showInputDialog(null, "Input surname: "));
		student.setName(JOptionPane.showInputDialog(null, "Input name: "));
		student.setGender(JOptionPane.showInputDialog(null, "Input gender: "));
		student.setAge(Integer.parseInt(JOptionPane.showInputDialog(null, "Input age: ")));
		student.setAverageMark(Double.parseDouble(JOptionPane.showInputDialog(null, "Input average mark: ")));
		student.setGroup(JOptionPane.showInputDialog(null, "Input group: "));
		for (int i = 0; i < getGroup().length; i++) {
			if (getGroup()[i] == null) {
				student.setGroup(this.groupName);
				getGroup()[i] = student;
				System.out.println("Student " + getGroup()[i].getSurname() + " added.");
				return;
			}
		}
		throw new MyException();
	}

	@Override
	public Student[] getNextSoilder(Student[] group) {
		int n = 0;
		for (int i = 0; i < group.length; i++) {
			if ((group[i] != null) && (group[i].getGender().equals("male")) && (group[i].getAge() >= 18)) {
				n++; 
			}	
		}
		Student[] groupForVoencom = new Student[n];
		int i = 0;
		for (Student st : group) {
			if ((st != null) && (st.getGender().equals("male")) && (st.getAge() >= 18)) {
				groupForVoencom[i++] = st;
			}
		}
		return groupForVoencom;
	}

	public Student[] getGroup() {
		return group;
	}

	public void setGroup(Student[] group) {
		this.group = group;
	}
	
	public void saveGroup(Student[] group) throws IOException {
		File save = new File("group.csv");
		if (!save.exists()) {
			save.createNewFile();
		}
		try (PrintWriter pw = new PrintWriter(save)) {
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				pw.print(group[i].getSurname() + ";" + group[i].getName() 
						+ ";" + group[i].getAge() + ";" + group[i].getAverageMark() 
						+ ";" + group[i].getGender());
				pw.println();
			}
		}
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		}
	
	}
	
	public Group getGroupFromFile(File file) {
		String str = "";
		Student[] arrStud = new Student[10];
		Group gr = new Group(arrStud);
		try (Scanner sc = new Scanner(file)) {
			for (; sc.hasNextLine();) {
				str = sc.nextLine();
				String[] arrStr = str.split(";");
				String surname = arrStr[0];
				String name = arrStr[1];
				int age = Integer.parseInt(arrStr[2]);
				double averMark = Double.parseDouble(arrStr[3]);
				String gender = arrStr[4];
				Student student = new Student(surname, name, gender, age, averMark, file.getName());
				for (int i = 0; i < arrStud.length; i++)
				if (arrStud[i] == null) {
					arrStud[i] = student;
					break;
				}
			}
			
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		}
		return gr;
			
		}
	
}
