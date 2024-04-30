
/**
 * Represents a college, and college management operations.
 * A college has courses, and students. Students take courses and get grades.
 * (See the Course, Student, and CourseTaken classes for more details).
 */
public class College {
	
	private String name; // the name of this college
	private LinkedList<Course> courses;
	private LinkedList<Student> students;
	
	/**
	 * Constructs a new college, with empty student and course lists.
	 */
	public College(String name) {
		this.name = name;
		this.courses = new LinkedList<Course>();
		this.students = new LinkedList<Student>();
	}
	
	/** 
	 * Adds the given course to the course list of this college.
	 * @param cid   course id.
	 * @param title course title.
	 */
	public void addCourse(int cid, String title) {
		// Put your code here
		if (this.getCourse(cid) == null)
			courses.add(new Course(cid, title));
	}
	
	/**
	 * Returns a list of all the courses.
	 */
	public LinkedList<Course> coursesList() {
		return this.courses;
	}

	/** 
	 * If the given course is in this college, removes it and returns true.
	 * Otherwise returns false.
	 * @param  cid the course to remove.
	 * @return True if the course was removed, false if there is no such course. 
	 */
	public boolean removeCourse(int cid) {
		// Replace the return statement with your code.
		// Note: You can get the course with the given cid by calling getCourse
		return courses.remove(getCourse(cid));
	}
	
	// Returns the course that has the given id, or null if there is no such course.
	public Course getCourse(int cid) {
		//
		Course c1= new Course(cid,null);
		ListIterator<Course> itr=courses.iterator();
		while (itr.hasNext())
		{
			Course c=itr.next();
			if (c.equals(c1))
			{
				return c;
			}

		}
		return null;
	}
	
	/** 
	 * Adds the given student to the students list of this college.
	 * @param sid   student id
	 * @param name  student name
	 */
	public void addStudent(int sid, String name) {
		// Put your code here
		if (getStudent(sid) == null) {
			students.add(new Student(sid, name));
		}
	}


	
	/**
	 * Returns a list of all the students.
	 */
	public LinkedList<Student> studentsList() {
		return students;
	}
	
	/** 
	 * If the given student is in this college, removes it and returns true.
	 * Otherwise returns false.
	 * @param  sid  the student's id.
	 * @return True if the student was removed, false if there is no such student. 
	 */
	public boolean removeStudent(int sid) {
		// Replace the return statement with your code.
		// Note: You can get the student with the given sid by calling the getStudent method.
		return students.remove(getStudent(sid));
	}
	
	// Returns the student that has the given id, or null if there is no such student.
	public Student getStudent(int sid) {
		// Replace the return statement with your code.
		ListIterator<Student> itr=this.students.iterator();
		while (itr.hasNext())
		{
			Student s= itr.next();
			if (s.getSid()==sid)
			{
				return s;
			}

		}
		return null;
	}
	
	/** 
	 * Adds the given course to the course list of the given student.
	 * @param sid   student id
	 * @param cid   course id
	 * @param grade student's grade in the course 
	 */
	public void addCourseTaken(int sid, int cid, int grade) {
		// Put your code here.
		if (getCourse(cid)!=null && getStudent(sid)!=null &&grade>=0 && grade<=100)
		{getStudent(sid).addCourse(getCourse(cid),grade);}
	}
	
	/** 
	 * Returns the student report of the given student.
	 * See the Student class for more details.
	 * @param sid  student id
	 */
	public String studentReport(int sid) {
		// Put your code here
		// Your code should call the student's studentReport method
		if (getStudent(sid)!=null)
		{return getStudent(sid).studentReport();}
		return null;
	}
	
	// Returns a list of all the students who took the given course
	public LinkedList<Student> studentsWhoTook(Course c) {
		// replace the following statement with your code.
		LinkedList<Student> took=new LinkedList<Student>();
		ListIterator<Student> itr=this.students.iterator();
		while (itr.hasNext())
		{
			Student s=itr.next();
			if (s.tookCourse(c)){
				took.add(s);
			}
		}
		return took;
	}
	
	// Returns a list of the all the student got the given grade or above it 
	public LinkedList<Student> studentsWithGrade(Course c, int grade) {
		// replace the following statement with your code.
		LinkedList<Student> above=new LinkedList<Student>();
		ListIterator<Student> itr=this.students.iterator();
		while (itr.hasNext())
		{
			Student s=itr.next();
			if (s.gradeInCourse(c)>=grade){
				above.add(s);
			}
		}
		return above;
	}

	// Returns a list of courses with the grade averages of all the students who took it
	public LinkedList<CourseTaken> getCoursesAverages() {
		// replace the following statement with your code.
		LinkedList<CourseTaken> avarages=new LinkedList<CourseTaken>();
		ListIterator<Course> itr1=this.courses.iterator();
		while (itr1.hasNext())
		{
			double sum=0.0;
			Course c=itr1.next();
			LinkedList<Student> took=studentsWhoTook(c);
			ListIterator<Student> itr2=took.iterator();
			while (itr2.hasNext())
			{
				sum=sum+itr2.next().gradeInCourse(c);
			}

			if (took.size()==0)
			{
				      CourseTaken ct= new CourseTaken(c,(-1));
				      avarages.add(ct);
			}
				else {
			          CourseTaken ct= new CourseTaken(c,(int)sum/took.size());
				      avarages.add(ct);
			}

		}
		return avarages;
	}
	/**
	 * Returns the students with the highest grade in the given course.
	 * @param cid  course id
	 */
        public LinkedList<Student> topPerfomerReport(int cid) {
			if (getCourse(cid) != null){
			int max=0;
		    LinkedList<Student> top=new LinkedList<Student>();
			ListIterator<Student> itr2=top.iterator();
			LinkedList<Student> took=studentsWhoTook(getCourse(cid));
			ListIterator<Student> itr1=took.iterator();
			while (itr1.hasNext())
			{
				Student s=itr1.next();
				if (s.gradeInCourse(getCourse(cid))==max)
				{
					max=s.gradeInCourse(getCourse(cid));
					top.add(s);
			    }
				else {
					if(s.gradeInCourse(getCourse(cid))>max)
					{
						max=s.gradeInCourse(getCourse(cid));
						top=new LinkedList<Student>();
						top.add(s);

					}
				}

		}
		return top;
		// Put your code here
	}
			return null;}

	/** 
	 * Returns the college name
	 * @return the college name 
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * A textual representation of this college, along with its courses and students.
	 */
	public String toString() {
		String str = name + "\n";
		str += "courses:" + "\n";
		str += courses.toString() + "\n";
		str += "students:" + "\n";
		str += students.toString() + "\n";
		return str;
	}
}
