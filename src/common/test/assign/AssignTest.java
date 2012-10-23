package common.test.assign;

public class AssignTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person _person = new Person() ;
		System.out.println(Animal.class.isAssignableFrom(_person.getClass()));
		System.out.println(_person instanceof Animal);
		System.out.println(_person instanceof Person);
		System.out.println(Person.class.isAssignableFrom(new Animal().getClass()));
	}

}
