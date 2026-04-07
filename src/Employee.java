


/**
 * The entity we're storing in our node
 */
// jeff is great
public class Employee implements Comparable<Employee> {
	
	private String name;
	private Integer id;
	private String position;
	
	public Employee(String name, Integer id, String position) {
		this.name = name;
		this.id = id;
		this.position = position;
	}
	
 	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass()) 
			return false;
		Employee e = (Employee) o;
		return (this.name.equals(e.name) && this.id.equals(e.id) && this.position.equals(e.position));
		
	}
	

	public String toString() {
		return name + " " + id + " " + position;
	}
	
	//
	public int compareTo(Employee o) {
		
		return (this.id).compareTo(o.id);
	 
	}
}
