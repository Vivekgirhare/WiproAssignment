//12.Create a class called Student with the following details: RollNo, StudName, MarksInEng, 
//MarksInMaths and MarksInScience. Write getters and setters for the all variables. RollNo
//should be automatically generated whenever a new student is added.
//
//	     Create a class called Standard with 8 students’ details and write separate method for each of 
//the following tasks and invoke the same.
//1. To display the entire roll no and the name of the students in the class in the ascending order of roll no.
//2. To display the roll no and the name of the student who has got the highest percentage.
//3. To display the roll no and the name of the student who scored highest mark 
//in mathematics.
//4. To display the roll no and the name of the student in the ascending order of the total marks in mathematics and science alone.
//5. To display the roll no, name, total marks, percentage and rank of all the students in the descending order of rank.


package javaAssignment;

public class que12 {

	private static int counter = 1;
    private int rollNo;
    private String studName;
    private int eng, maths, sci;

    public que12(String name, int eng, int maths, int sci) {
        this.rollNo = counter++;
        this.studName = name;
        this.eng = eng;
        this.maths = maths;
        this.sci = sci;
    }

    public int getRollNo() { return rollNo; }
    public String getStudName() { return studName; }
    public int getTotal() { return eng + maths + sci; }
    public double getPercentage() { return getTotal() / 3.0; }
    public int getMaths() { return maths; }
    public int getMathsSciTotal() { return maths + sci; }

    @Override
    public String toString() {
        return rollNo + " - " + studName;
    }

}
