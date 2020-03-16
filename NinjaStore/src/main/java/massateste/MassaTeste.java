package massateste;

import com.github.javafaker.Faker;

public abstract class MassaTeste {

	public static final String FIRST_NAME = Faker.instance().name().firstName();
	public static final String LAST_NAME = Faker.instance().name().lastName();
	public static final String EMAIL = Faker.instance().internet().emailAddress();
	public static final String PHONE = Faker.instance().phoneNumber().cellPhone();
	public static final String ADRESS1 = Faker.instance().address().fullAddress();
	public static final String CITY = Faker.instance().address().city();
	public static final String POST_CODE = Faker.instance().address().zipCode();
	public static final String COUNTRY = "Brazil";
	public static final String REGION = "São Paulo";
	public static final String COMMENT = Faker.instance().chuckNorris().fact();
}
