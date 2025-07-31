//3.The total number of students in a class are 90 out of which 45 are boys. If 50% of the total students secured grade 'A' out of which 20 are boys, then write a program to calculate the total number of girls getting grade 'A'.

package javaAssignment;

public class que3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int totalStudents = 90;
        int boys = 45;
        int totalAGrade = totalStudents / 2;  // 50% of 90 = 45
        int boysAGrade = 20;
        int girlsAGrade = totalAGrade - boysAGrade;

        System.out.println("Number of girls who got Grade A: " + girlsAGrade);

	}

}
