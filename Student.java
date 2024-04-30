/** 
 * Represents a student.
 */
public class Student {
	
	private int sid;                             
	private String name;                         
	private LinkedList<CourseTaken> courseList;
	
	/** 
	 * Constructs a new student with the given sid and name, and an empty course list.
	 * @param sid  the student's id
	 * @param name the student's name
	 */
	public Student(int sid, String name) {
		this.sid = sid;
		this.name = name;
		this.courseList = new LinkedList<CourseTaken>();
	}
	
	/** 
	 * Returns the id of this student.
	 * @return the sid of this student.
	 */
	public int getSid() {
		return this.sid;
	}
	
	/** 
	 * Returns the name of this student.
	 * @return the name of this student.
	 */
	public String getName() {
		return this.name;
	}
	
	/** 
	 * Adds the given course and grade to the course list of this student.
	 * @param c     the course to add
	 * @param grade the grade in the added course 
	 */
	public void addCourse(Course c, int grade) {
		// Put your code here.
		CourseTaken ct=new CourseTaken(c,grade);
		this.courseList.add(ct);
	}
	
	/**
	 * Returns the grade that this student got in the given course, 
	 *  or -1 if the course was not taken by this student.
	 * @param c - the returned grade will be the grade in this course.
	 * @return the grade that this student got in the given course
	 */
	public int gradeInCourse(Course c) {
		// Replace the following statement with your code.
		ListIterator<CourseTaken> itr=this.courseList.iterator();
		while (itr.hasNext())
		{
			if (itr.next().getCourse().getCid()==c.getCid())
			{
				return courseList.iterator().next().getGrade();
			}
		}
		return -1;
	}
	
	/** 
	 * Returns true if this student took the given course, false otherwise.
	 * @param c  the course we want to know whether or not the student took.
	 * @return true if this student took the given course, false otherwise.
	 */
	public boolean tookCourse(Course c) {
		if (gradeInCourse(c)==-1){
		return false;}
		return true;
	}
	
	/**
	 * Prints this student, all the courses that s/he took, and the grade point average.
	 */
	public String studentReport() {
		double sum=0.0;
		String report=this.toString()+"\n";
		ListIterator<CourseTaken> itr=this.courseList.iterator();
		while (itr.hasNext()) {
			CourseTaken ct=itr.next();
			report= report+ ct.toString()+"\n";
			sum = sum + ct.getGrade();
		}
		report+="Average : "+sum/courseList.size();
		return report;
	}
	
	public boolean equals(Student other){
		if (other==null)
			return false;
		if (this.sid==other.getSid())
			return true;

		return false;
	}
	/**
	 * Textual representation of this student.
	 */
	public String toString() {
		return "Student " + this.sid + ": " + this.name;
	}
}