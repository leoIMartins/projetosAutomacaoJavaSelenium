package massateste;

import com.github.javafaker.Faker;

public abstract class MassaTeste {

	public static final String FIRST_NAME = Faker.instance().name().firstName();
	public static final String MIDDLE_NAME = Faker.instance().name().nameWithMiddle();
	public static final String LAST_NAME = Faker.instance().name().lastName();
	public static final String COMPANY = Faker.instance().hacker().abbreviation();
	public static final String EMAIL = Faker.instance().internet().emailAddress();
	public static final String ADRESS = Faker.instance().address().fullAddress();
	public static final String CITY = Faker.instance().address().city();
	public static final String STATE = "Arizona";
	public static final String ZIP = Faker.instance().address().zipCode();
	public static final String COUNTRY = "United States";
	public static final String TELEPHONE = Faker.instance().phoneNumber().cellPhone();
	public static final String REGION = "São Paulo";
	public static final String COMMENT = Faker.instance().chuckNorris().fact();
}
