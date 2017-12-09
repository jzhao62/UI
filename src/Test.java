import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Test {

	ThirdScreen thirdScr ;

	//tests normalization functionality for valid values.
	@org.junit.jupiter.api.Test
	void testValidValues() {			
		Object[][] scores = {
				{"Dave",new Integer(3),new Integer(5),new Integer(4)},
				{"Casey",new Integer(3),new Integer(4),new Integer(4)},
				{"Jim",new Integer(5),new Integer(5),new Integer(3)},
				{"Matt",new Integer(5),new Integer(5),new Integer(3)},
				{"Sara",new Integer(4),new Integer(4),new Integer(3)},
				{"Jake",new Integer(4),new Integer(5),new Integer(3)},
				{"Sam",new Integer(5),new Integer(3),new Integer(4)}};

		thirdScr = new ThirdScreen(scores);

		Object[][] ddata = thirdScr.normalise(scores);
		Object[][] expected = null ;

		assertArrayEquals(ddata,ddata);	

	}

	//tests normalization functionality for illegal arguments like string which are unacceptable to the normalize method.
	//in this case the normalization code will return an empty array.
	@org.junit.jupiter.api.Test
	void testIllegalArgument() {			
		Object[][] scores = {
				{"Dave",new String("A"),new Integer(5),new Integer(4)},
				{"Casey",new Integer(3),new Integer(4),new Integer(4)},
				{"Jim",new Integer(5),new Integer(5),new Integer(3)},
				{"Matt",new Integer(5),new Integer(5),new Integer(3)},
				{"Sara",new Integer(4),new Integer(4),new Integer(3)},
				{"Jake",new Integer(4),new Integer(5),new Integer(3)},
				{"Sam",new Integer(5),new Integer(3),new Integer(4)}};

		thirdScr = new ThirdScreen(scores);
		Object[][] ddata = thirdScr.normalise(scores);
		Object[][] expected = null ;

		assertArrayEquals(ddata,ddata);	
	}

	//tests normalization functionality for zero values.
	@org.junit.jupiter.api.Test
	void testZeroArguments() {			
		Object[][] scores = {
				{"Dave",new Integer(0),new Integer(0),new Integer(0)},
				{"Casey",new Integer(0),new Integer(0),new Integer(0)},
				{"Jim",new Integer(0),new Integer(0),new Integer(0)},
				{"Matt",new Integer(0),new Integer(0),new Integer(0)},
				{"Sara",new Integer(0),new Integer(0),new Integer(0)},
				{"Jake",new Integer(0),new Integer(0),new Integer(0)},
				{"Sam",new Integer(0),new Integer(0),new Integer(0)}};

		thirdScr = new ThirdScreen(scores);
		Object[][] ddata = thirdScr.normalise(scores);	
		Object[][] expected = null ;

		assertArrayEquals(ddata,ddata);	

	}

	//tests normalization functionality for equal values.
	@org.junit.jupiter.api.Test
	void testAllEqualArguments() {			
		Object[][] scores = {
				{"Dave",new Integer(5),new Integer(5),new Integer(5)},
				{"Casey",new Integer(5),new Integer(5),new Integer(5)},
				{"Jim",new Integer(5),new Integer(5),new Integer(5)},
				{"Matt",new Integer(5),new Integer(5),new Integer(5)},
				{"Sara",new Integer(5),new Integer(5),new Integer(5)},
				{"Jake",new Integer(5),new Integer(5),new Integer(5)},
				{"Sam",new Integer(5),new Integer(5),new Integer(5)}};

		thirdScr = new ThirdScreen(scores);
		Object[][] ddata = thirdScr.normalise(scores);
		Object[][] expected = null ;

		assertArrayEquals(ddata,ddata);	

	}


	//tests normalization functionality for negative values.
	//in this case the normalization code returns an all negative array.
	@org.junit.jupiter.api.Test
	void testNegativeArguments() {			
		Object[][] scores = {
				{"Dave",new Integer(-1),new Integer(5),new Integer(5)},
				{"Casey",new Integer(5),new Integer(5),new Integer(5)},
				{"Jim",new Integer(5),new Integer(-1),new Integer(5)},
				{"Matt",new Integer(5),new Integer(5),new Integer(5)},
				{"Sara",new Integer(-1),new Integer(5),new Integer(5)},
				{"Jake",new Integer(5),new Integer(-1),new Integer(5)},
				{"Sam",new Integer(5),new Integer(5),new Integer(5)}};

		thirdScr = new ThirdScreen(scores);
		Object[][] ddata = thirdScr.normalise(scores);		
		assertArrayEquals(ddata,ddata);	

	}
	

	//tests normalization functionality for valid values.
	//the normalization should return one zero value. 
	@org.junit.jupiter.api.Test
	void testOneZeroValue() {			
		Object[][] scores = {
				{"Dave",new Integer(0),new Integer(0),new Integer(0)},
				{"Casey",new Integer(3),new Integer(4),new Integer(4)},
				{"Jim",new Integer(5),new Integer(5),new Integer(3)},
				{"Matt",new Integer(5),new Integer(5),new Integer(3)},
				{"Sara",new Integer(4),new Integer(4),new Integer(3)},
				{"Jake",new Integer(4),new Integer(5),new Integer(3)},
				{"Sam",new Integer(5),new Integer(3),new Integer(4)}};

		thirdScr = new ThirdScreen(scores);

		Object[][] ddata = thirdScr.normalise(scores);
		Object[][] expected = null ;

		assertArrayEquals(ddata,ddata);	

	}

}
