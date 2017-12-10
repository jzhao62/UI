package TestCases;

import UI.ThirdScreen;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Test {

	ThirdScreen thirdScr ;

	//Tests normalization functionality for valid values.
	@org.junit.Test
	public void testValidValues() {
		Object[][] scores = {
				{"Dave",new Integer(3),new Integer(5),new Integer(4)},
				{"Casey",new Integer(3),new Integer(4),new Integer(4)},
				{"Jim",new Integer(5),new Integer(5),new Integer(3)},
				{"Matt",new Integer(5),new Integer(5),new Integer(3)},
				{"Sara",new Integer(4),new Integer(4),new Integer(3)},
				{"Jake",new Integer(4),new Integer(5),new Integer(3)},
				{"Sam",new Integer(5),new Integer(3),new Integer(4)}};

		thirdScr = new ThirdScreen(scores);

		Object[][] normalisedData = thirdScr.normalise(scores);
		Object[][] expectedData = {{"Dave", 0.14},
				{"Casey", 0.13},
				{"Jim", 0.15},
				{"Matt", 0.15},
				{"Sara", 0.13},
				{"Jake", 0.14},
				{"Sam", 0.14}};

		assertArrayEquals(normalisedData, expectedData);

	}

	//Tests normalization functionality for All Zero values.
	//The normalize function returns an array of all 0 scores.
	@org.junit.Test
	public void testAllZeroArguments() {
		Object[][] scores = {
				{"Dave",new Integer(0),new Integer(0),new Integer(0)},
				{"Casey",new Integer(0),new Integer(0),new Integer(0)},
				{"Jim",new Integer(0),new Integer(0),new Integer(0)},
				{"Matt",new Integer(0),new Integer(0),new Integer(0)},
				{"Sara",new Integer(0),new Integer(0),new Integer(0)},
				{"Jake",new Integer(0),new Integer(0),new Integer(0)},
				{"Sam",new Integer(0),new Integer(0),new Integer(0)}};

		thirdScr = new ThirdScreen(scores);
		Object[][] normalisedData = thirdScr.normalise(scores);
		Object[][] expectedData = {{"Dave", 0.0},
				{"Casey", 0.0},
				{"Jim", 0.0},
				{"Matt", 0.0},
				{"Sara", 0.0},
				{"Jake", 0.0},
				{"Sam", 0.0}};

		assertArrayEquals(normalisedData, expectedData);

	}

	//Tests normalization functionality for all equal values.
	//The Normalize function returns all equal scores for all students.
	@org.junit.Test
	public void testAllEqualArguments() {
		Object[][] scores = {
				{"Dave",new Integer(5),new Integer(5),new Integer(5)},
				{"Casey",new Integer(5),new Integer(5),new Integer(5)},
				{"Jim",new Integer(5),new Integer(5),new Integer(5)},
				{"Matt",new Integer(5),new Integer(5),new Integer(5)},
				{"Sara",new Integer(5),new Integer(5),new Integer(5)},
				{"Jake",new Integer(5),new Integer(5),new Integer(5)},
				{"Sam",new Integer(5),new Integer(5),new Integer(5)}};

		thirdScr = new ThirdScreen(scores);
		Object[][] normalisedData = thirdScr.normalise(scores);
		Object[][] expectedData = {
				{"Dave", 0.14},
				{"Casey", 0.14},
				{"Jim", 0.14},
				{"Matt", 0.14},
				{"Sara", 0.14},
				{"Jake", 0.14},
				{"Sam", 0.14}};
		;

		assertArrayEquals(normalisedData, expectedData);

	}


	//Tests normalization functionality for negative values.
	//In this case the normalization code returns an empty array
	@org.junit.Test
	public void testNegativeIntegerArguments() {
		Object[][] scores = {
				{"Dave",new Integer(-1),new Integer(5),new Integer(5)},
				{"Casey",new Integer(5),new Integer(5),new Integer(5)},
				{"Jim",new Integer(5),new Integer(-1),new Integer(5)},
				{"Matt",new Integer(5),new Integer(5),new Integer(5)},
				{"Sara",new Integer(-1),new Integer(5),new Integer(5)},
				{"Jake",new Integer(5),new Integer(-1),new Integer(5)},
				{"Sam",new Integer(5),new Integer(5),new Integer(5)}};

		thirdScr = new ThirdScreen(scores);
		Object[][] normalisedData = thirdScr.normalise(scores);
		Object[][] expectedData = new Object[0][0];

		assertEquals(normalisedData.length, expectedData.length);

	}


	//Tests normalization functionality for valid values, with one student's all scores as 0.
	//The normalization should return one zero value for that particular student.
	@org.junit.Test
	public void testOneZeroValue() {
		Object[][] scores = {
				{"Dave",new Integer(0),new Integer(0),new Integer(0)},
				{"Casey",new Integer(3),new Integer(4),new Integer(4)},
				{"Jim",new Integer(5),new Integer(5),new Integer(3)},
				{"Matt",new Integer(5),new Integer(5),new Integer(3)},
				{"Sara",new Integer(4),new Integer(4),new Integer(3)},
				{"Jake",new Integer(4),new Integer(5),new Integer(3)},
				{"Sam",new Integer(5),new Integer(3),new Integer(4)}};

		thirdScr = new ThirdScreen(scores);

		Object[][] normalisedData = thirdScr.normalise(scores);

		Object[][] expectedData = {
				{"Dave", 0.0},
				{"Casey", 0.15},
				{"Jim", 0.18},
				{"Matt", 0.18},
				{"Sara", 0.15},
				{"Jake", 0.17},
				{"Sam", 0.17}};
		;

		assertArrayEquals(normalisedData, expectedData);

	}

	//Tests normalization functionality for Floating Point numbers - Since we do not accept floating point numbers in the UI
	//In this case the normalization code returns an empty array.
	@org.junit.Test
	public void testFloatingPointArgument() {
		Object[][] scores = {
				{"Dave", new Double(5.5), new Integer(5), new Integer(4)},
				{"Casey", new Integer(3), new Integer(4), new Integer(4)},
				{"Jim", new Integer(5), new Integer(5), new Integer(3)},
				{"Matt", new Integer(5), new Integer(5), new Integer(3)},
				{"Sara", new Integer(4), new Double(4.4), new Integer(3)},
				{"Jake", new Integer(4), new Integer(5), new Integer(3)},
				{"Sam", new Integer(5), new Integer(3), new Integer(4)}};

		thirdScr = new ThirdScreen(scores);
		Object[][] normalisedData = thirdScr.normalise(scores);
		Object[][] expectedData = new Object[0][0];
		assertEquals(normalisedData.length, expectedData.length);
	}

	//Tests normalization functionality for null values as input.
	//The normalization code returns an empty array.
	@org.junit.Test
	public void testNullValue() {
		Object[][] scores = null;
		thirdScr = new ThirdScreen(scores);
		Object[][] normalisedData = thirdScr.normalise(scores);
		Object[][] expectedData = new Object[0][0];
		assertEquals(normalisedData.length, expectedData.length);

	}

	//Tests normalization functionality for empty values as input.
	//The normalization code returns an empty array.
	@org.junit.Test
	public void testEmptyValue() {
		Object[][] scores = {};
		thirdScr = new ThirdScreen(scores);
		Object[][] normalisedData = thirdScr.normalise(scores);
		Object[][] expectedData = new Object[0][0];
		assertEquals(normalisedData.length, expectedData.length);

	}

	//Tests normalization functionality for incomplete input with missing name or score parameters
	//The normalization code returns an empty array.
	@org.junit.Test
	public void testInCompleteInput() {
		Object[][] scores = {{"Dave"}, {new Integer(0), new Integer(1)}, {}, {new Integer(-1)}};
		thirdScr = new ThirdScreen(scores);
		Object[][] normalisedData = thirdScr.normalise(scores);
		Object[][] expectedData = new Object[0][0];
		assertEquals(normalisedData.length, expectedData.length);
	}

	//Tests normalization functionality for less than 2 rows(group count).
	//The normalization should returns an empty array.
	@org.junit.Test
	public void testLessThanTwoGroupCounts() {
		Object[][] scores = {{"Dave", new Integer(0), new Integer(0), new Integer(0)}};

		thirdScr = new ThirdScreen(scores);

		Object[][] normalisedData = thirdScr.normalise(scores);
		Object[][] expectedData = new Object[0][0];
		assertEquals(normalisedData.length, expectedData.length);

	}

	//Tests normalization functionality for more than 7 group counts.
	//The normalization returns an empty array.
	@org.junit.Test
	public void testMoreThanSevenGroupCount() {
		Object[][] scores = {
				{"Dave", new Integer(0), new Integer(0), new Integer(0)},
				{"Casey", new Integer(3), new Integer(4), new Integer(4)},
				{"Jim", new Integer(5), new Integer(5), new Integer(3)},
				{"Matt", new Integer(5), new Integer(5), new Integer(3)},
				{"Sara", new Integer(4), new Integer(4), new Integer(3)},
				{"Jake", new Integer(4), new Integer(5), new Integer(3)},
				{"Sam", new Integer(5), new Integer(3), new Integer(4)},
				{"My3", new Integer(5), new Integer(3), new Integer(4)}};

		thirdScr = new ThirdScreen(scores);

		Object[][] normalisedData = thirdScr.normalise(scores);
		Object[][] expectedData = new Object[0][0];
		assertEquals(normalisedData.length, expectedData.length);

	}

	//Tests normalization functionality for valid  group counts.
	//The normalization code should return accurate values.
	@org.junit.Test
	public void testValidGroupCount() {
		Object[][] scores = {
				{"Dave", new Integer(5), new Integer(4), new Integer(4)},
				{"Casey", new Integer(3), new Integer(4), new Integer(4)},
				{"Jim", new Integer(5), new Integer(5), new Integer(3)},
				{"Matt", new Integer(5), new Integer(5), new Integer(3)}};

		thirdScr = new ThirdScreen(scores);

		Object[][] normalisedData = thirdScr.normalise(scores);
		Object[][] expectedData = {{"Dave", 0.26},
				{"Casey", 0.22},
				{"Jim", 0.26},
				{"Matt", 0.26}};

		assertArrayEquals(normalisedData, expectedData);

	}

	//Tests normalization functionality for illegal arguments like string which are unacceptable to the normalize method.
	//In this case the normalization code will return a empty array
	@org.junit.Test
	public void testIllegalStringArgument() {
		Object[][] scores = {
				{"Dave", new String("A"), new Integer(5), new Integer(4)},
				{"Casey", new Integer(3), new Integer(4), new Integer(4)},
				{"Jim", new Integer(5), new Integer(5), new Integer(3)},
				{"Matt", new Integer(5), new Integer(5), new Integer(3)},
				{"Sara", new Integer(4), new Integer(4), new Integer(3)},
				{"Jake", new Integer(4), new Integer(5), new Integer(3)},
				{"Sam", new Integer(5), new Integer(3), new Integer(4)}};

		thirdScr = new ThirdScreen(scores);
		Object[][] normalisedData = thirdScr.normalise(scores);
		Object[][] expectedData = new Object[0][0];

		assertEquals(normalisedData.length, expectedData.length);
	}

	//Tests normalization functionality for illegal arguments like Character values which are unacceptable to the normalize method.
	//In this case the normalization code returns an empty array.
	@org.junit.Test
	public void testIllegalCharacterArgument() {
		Object[][] scores = {
				{"Dave", new Character(','), new Integer(5), new Integer(4)},
				{"Casey", new Integer(3), new Integer(4), new Integer(4)},
				{"Jim", new Integer(5), new Integer(5), new Integer(3)},
				{"Matt", new Integer(5), new Integer(5), new Integer(3)},
				{"Sara", new Integer(4), new Integer(4), new Integer(3)},
				{"Jake", new Integer(4), new Integer(5), new Integer(3)},
				{"Sam", new Integer(5), new Integer(3), new Integer(4)}};

		thirdScr = new ThirdScreen(scores);
		Object[][] normalisedData = thirdScr.normalise(scores);
		Object[][] expectedData = new Object[0][0];
		assertEquals(normalisedData.length, expectedData.length);
	}

}
