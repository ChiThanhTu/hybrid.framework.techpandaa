package utilities;

import com.github.javafaker.Faker;

public class DataUtil {
private Faker faker;
public static DataUtil getData() {
	return new DataUtil();
}
public DataUtil() {
	faker = new Faker();
}

public String getFirstName() {
	return faker.name().firstName();
}

public String getLastName() {
	return faker.name().lastName();
}

public String getFulltName() {
	return getFirstName() + " "+ getLastName();
}

public String getEmailAddress() {
	return faker.internet().emailAddress();
}
public String getUserName() {
	return faker.name().username();
}
public String getPassword() {
	return faker.internet().password();
}
public String cardNumber() {
	return faker.finance().creditCard();
}

}
